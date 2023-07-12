package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText display;
    private float op1;
    private float op2;
    private char operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.input);
        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(getString(R.string.Display).equals(display.getText().toString())){
                    display.setText("");
                }
            }
        });

    }

    private void updateText(String strToAdd){
        String leftStr = display.getText().toString();
        int cursorPos = display.getSelectionStart();
        display.setText(leftStr + strToAdd);
        display.setSelection(cursorPos + 1);
    }

    public void EqualsBtn(View view){
        op2 = Float.parseFloat(display.getText().toString());
        switch (operation){
            case '/': display.setText(String.valueOf(op1/op2)); break;
            case '*': display.setText(String.valueOf(op1*op2)); break;
            case '+': display.setText(String.valueOf(op1+op2)); break;
            case '-': display.setText(String.valueOf(op1-op2)); break;
        }
    }
    public void ClearBtn(View view){
        display.setText("");
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
    public void DivideBtn(View view){
        op1 = Float.parseFloat(display.getText().toString());
        operation = '/';
        display.setText("");
    }
    public void MultiplyBtn(View view){
        op1 = Float.parseFloat(display.getText().toString());
        operation = '*';
        display.setText("");
    }
    public void AddBtn(View view){
        op1 = Float.parseFloat(display.getText().toString());
        operation = '+';
        display.setText("");
    }
    public void SubtractBtn(View view){
        op1 = Float.parseFloat(display.getText().toString());
        operation = '-';
        display.setText("");
    }
    public void PointBtn(View view){
        updateText(".");
    }

}