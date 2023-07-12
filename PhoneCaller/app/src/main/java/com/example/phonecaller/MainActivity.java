package com.example.phonecaller;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText phoneDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneDisplay = findViewById(R.id.phone_number_edit_text);
        phoneDisplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    phoneDisplay.setText("");
            }
        });
    }
    public void makePhoneCall(View view) {
        String phoneNumber = phoneDisplay.getText().toString().trim();
        startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber)));
    }
    public void savePhoneNumber(View view) {
        String phoneNumber = phoneDisplay.getText().toString().trim();
        Intent saveIntent = new Intent(Intent.ACTION_INSERT);
        saveIntent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        saveIntent.putExtra(ContactsContract.Intents.Insert.PHONE, phoneNumber);
        startActivity(saveIntent);
    }
    public void updateText(String strToAdd){
        String leftStr = phoneDisplay.getText().toString();
        int cursorPos = phoneDisplay.getSelectionStart();
        phoneDisplay.setText(leftStr + strToAdd);
        phoneDisplay.setSelection(cursorPos + 1);
    }
    public void ClearBtn(View view){
        phoneDisplay.setText("");
    }
    public void ZeroBtn(View view){
        updateText("0");
    }
    public void OneBtn(View view){
        updateText("1");
    }
    public void TwoBtn(View view){
        updateText("2");
    }
    public void ThreeBtn(View view){
        updateText("3");
    }
    public void FourBtn(View view){
        updateText("4");
    }
    public void FiveBtn(View view){
        updateText("5");
    }
    public void SixBtn(View view){
        updateText("6");
    }
    public void SevenBtn(View view){
        updateText("7");
    }
    public void EightBtn(View view){
        updateText("8");
    }
    public void NineBtn(View view){
        updateText("9");
    }
    public void starBtn(View view){
        updateText("*");
    }
    public void hashBtn(View view){
        updateText("#");
    }
}
