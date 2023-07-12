package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.*;

public class MainActivity extends AppCompatActivity {

    TextView display;
    CountDownTimer countDownTimer;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.text_view);
    }

    public void startBtn(View v){
        countDownTimer = new CountDownTimer(Long.MAX_VALUE, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                counter++;
                display.setText(String.valueOf(counter));
            }

            @Override
            public void onFinish() {
            }
        };
        countDownTimer.start();
    }
    public void stopBtn(View view){
        if(countDownTimer!=null){
            countDownTimer.cancel();
        }
    }
    public void restartBtn(View view){
        counter = 1;
        display.setText(String.valueOf(counter));
    }
}

