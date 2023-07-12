package com.example.signupandlogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.google.android.material.button.MaterialButtonToggleGroup;

import java.util.regex.*;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtUser, txtPass;
    private Button signUp;
    private String regEx = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!])[A-Za-z\\d@$!]{8,}$";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtUser = findViewById(R.id.txt_username);
        txtPass = findViewById(R.id.txt_password);
        signUp = findViewById(R.id.btn_signup);
        signUp.setOnClickListener(this);
    }

    public void onClick(View view){
        String username = txtUser.getText().toString();
        String password = txtPass.getText().toString();
        if(validate(password)){
            Bundle bundle = new Bundle();
            bundle.putString(username, username);
            bundle.putString(password, password);
            Intent it = new Intent(this, Login.class);
            it.putExtra("data", bundle);
            startActivity(it);
        }else{
            Toast.makeText(getBaseContext(), "Invalid Password", Toast.LENGTH_LONG).show();
        }

    }
    public boolean validate(String password){
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }


}