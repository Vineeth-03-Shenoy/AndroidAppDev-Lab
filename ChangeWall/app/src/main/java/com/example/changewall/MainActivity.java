package com.example.changewall;

import androidx.appcompat.app.AppCompatActivity;
import android.app.WallpaperManager;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button changeBtn;
    int[] ia = new int[]{
            R.drawable.img1,
            R.drawable.img2,
            R.drawable.img3,
            R.drawable.img4,
            R.drawable.img5,
            R.drawable.img6
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeBtn = findViewById(R.id.btn_wallpaper);
        changeBtn.setOnClickListener(this);
    }

    public void onClick(View view){
        new Timer().schedule(new MyTimer(), 0,5000);
    }
    class MyTimer extends TimerTask{
        public void run(){
            WallpaperManager wlp = WallpaperManager.getInstance(getBaseContext());
            Random random = new Random();
            try {
                wlp.setBitmap(BitmapFactory.decodeResource(getResources(), ia[random.nextInt(5)]));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}