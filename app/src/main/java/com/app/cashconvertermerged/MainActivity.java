package com.app.cashconvertermerged;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button simpleConverterButton, improvedConverterButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simpleConverterButton =  findViewById(R.id.btn_simple_converter);
        improvedConverterButton = findViewById(R.id.btn_improved_converter);
        simpleConverterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SimpleConverter.class));
            }
        });

        improvedConverterButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, ImprovedConverter.class));

            }
        });
    }
}