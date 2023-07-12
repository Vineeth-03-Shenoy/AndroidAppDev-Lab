package com.example.parser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class ViewActivity extends AppCompatActivity {
    TextView xmlDisplay, jsonDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        xmlDisplay = findViewById(R.id.xmlDisplay);
        jsonDisplay = findViewById(R.id.jsonDisplay);

        String dataType = getIntent().getStringExtra("dataType");

        if(dataType.equals("xml")){
            try {
                parseXml();
            } catch (ParserConfigurationException | IOException | SAXException  e) {
                throw new RuntimeException(e);
            }
        }
        else if(dataType.equals("json")){
            try {
                parseJson();
            } catch (IOException | JSONException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void parseXml() throws ParserConfigurationException, IOException, SAXException {
            InputStream is = getAssets().open("city.xml");
            Document doc = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(is);
            StringBuilder sB = new StringBuilder();
            sB.append("XML DATA");
            sB.append("\n-------------");
            NodeList nodeList = doc.getElementsByTagName("place");
            for(int i=0; i<nodeList.getLength();i++){
                Node node = nodeList.item(i);
                Element ele = (Element)node;
                sB.append("\n Name:").append(getValue("name",ele));
                sB.append("\n Latitude:").append(getValue("lat",ele));
                sB.append("\n Longitude:").append(getValue("long",ele));
                sB.append("\n Temperature:").append(getValue("temperature",ele));
                sB.append("\n Humidity: ").append(getValue("humidity",ele));
                sB.append("\n----------");
            }
            xmlDisplay.setText(sB.toString());
            jsonDisplay.setText("NO JSON DATA");
    }
    public void parseJson() throws IOException, JSONException {

            InputStream is = getAssets().open("city.json");
            StringBuilder sB = new StringBuilder();
            int size=is.available();
            byte[] buffer=new byte[size];
            is.read(buffer);
            JSONArray jsonArray = new JSONArray(new String(buffer));
            sB.append("JSON DATA");
            sB.append("\n--------");
            for(int i=0;i<jsonArray.length();i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                sB.append("\n Name:").append(jsonObject.getString("name"));
                sB.append("\n Latitude:").append(jsonObject.getString("lat"));
                sB.append("\n Longitude:").append(jsonObject.getString("long"));
                sB.append("\n Temperature:").append(jsonObject.getString("temperature"));
                sB.append("\n Humidity:").append(jsonObject.getString("humidity"));
                sB.append("\n----------");
            }
            jsonDisplay.setText(sB.toString());
            xmlDisplay.setText("NO XML DATA");
            is.close();
    }
    private String getValue(String tag,Element ele){
        return
                ele.getElementsByTagName(tag).item(0).getChildNodes().item(0).getNodeValue();
    }
}