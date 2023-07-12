package com.example.signupandlogin;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

public class Login extends AppCompatActivity implements View.OnClickListener {

        private EditText txtUser, txtPass;
        private Button logIn;
        private int counter =0;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login);
                txtUser = findViewById(R.id.txt_login_username);
                txtPass = findViewById(R.id.txt_login_password);
                logIn = findViewById(R.id.btn_login_signin);
                logIn.setOnClickListener(this);
        }

        public void onClick(View view){
                String username = txtUser.getText().toString();
                String password = txtPass.getText().toString();
                Bundle bundle = getIntent().getBundleExtra("data");
                String user = bundle.getString(username);
                String pass = bundle.getString(password);
                if(user.equals(username) && pass.equals(password)){
                        Toast.makeText(this, "SUCCESSFUL", Toast.LENGTH_LONG).show();
                }else{
                        counter++;
                        if(counter==3){
                                Toast.makeText(this, "Failed LOGIN", Toast.LENGTH_LONG).show();
                                Intent it = new Intent(this, MainActivity.class);
                                startActivity(it);
                        }else{
                                Toast.makeText(this, "Failed Attempt"+ counter, Toast.LENGTH_LONG).show();
                        }

                }


        }
}
