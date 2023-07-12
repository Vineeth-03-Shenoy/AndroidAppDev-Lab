package com.example.texttospeech;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    EditText editText;
    Button button;
    TextToSpeech textToSpeech;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        editText = findViewById(R.id.edit_text);
        button = findViewById(R.id.button);

        // Initialize TextToSpeech engine
        textToSpeech = new TextToSpeech(this, this);

        // Set click listener for button
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                if (text != null && !text.isEmpty()) {
                    // Convert text to speech
                    Bundle params = new Bundle();
                    params.putString(TextToSpeech.Engine.KEY_PARAM_UTTERANCE_ID, "");
                    textToSpeech.speak(text, TextToSpeech.QUEUE_FLUSH, params, "text_to_speech");
                }
            }
        });
    }
    @Override
    public void onDestroy() {
        // Shutdown TextToSpeech engine
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
    @Override
    public void onInit(int status) {
        // Set TextToSpeech language to default
        if (status == TextToSpeech.SUCCESS) {
            textToSpeech.setLanguage(Locale.US);
            textToSpeech.setSpeechRate(0.8f);
        }
    }


}
