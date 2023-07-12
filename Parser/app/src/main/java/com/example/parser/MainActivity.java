package com.example.parser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
public class MainActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void xmlClick(View v){
        Intent it=new Intent(this, ViewActivity.class);
        it.putExtra("dataType", "xml");
        startActivity(it);
    }
    public void jsonClick(View v){
        Intent it=new Intent(this, ViewActivity.class);
        it.putExtra("dataType", "json");
        startActivity(it);
    }

}
