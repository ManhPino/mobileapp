package com.example.numberramdom;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    TextView txt;
    Button btn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        anhXa();
        getNumberRandom();
    }
    private void getNumberRandom(){
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random ram = new Random();
                int number = ram.nextInt(10);
                txt.setText("Your Number :" + number);
            }
        });
    }
    private void anhXa() {
        txt = findViewById(R.id.textNumber);
        btn = findViewById(R.id.btnNumber);
    }

}