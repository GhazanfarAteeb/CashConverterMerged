package com.app.cashconvertermerged;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

public class ImprovedConverter extends AppCompatActivity {
    EditText editTextConvertedFrom,
            editTextConvertedTo;

    Button button0, button1, button2,
            button3, button4, button5,
            button6, button7, button8,
            button9, buttonBackspace, buttonAC,
            buttonDecimal;

    ImageView buttonBack;

    int spinnerConvertedToIndex,
            spinnerConvertedFromIndex;
    String text;
    boolean isDecimalEntered;
    Spinner spinnerConvertedFrom, spinnerConvertedTo;

    CashConverter cashConverter;
    ArrayAdapter<String> converterAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_improved_converter);

        init();
        setAdapters();
        setListeners();
    }
    private void init() {
        spinnerConvertedFrom = findViewById(R.id.spinner_converted_from);
        spinnerConvertedTo = findViewById(R.id.spinner_converted_to);

        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonBackspace = findViewById(R.id.button_backspace);
        buttonAC = findViewById(R.id.button_ac);
        buttonDecimal = findViewById(R.id.button_decimal);
        buttonBack = findViewById(R.id.back_button);
        isDecimalEntered = false;

        editTextConvertedTo = findViewById(R.id.edit_text_converted_to);
        editTextConvertedFrom = findViewById(R.id.edit_text_converted_from);



        cashConverter = new CashConverter();
    }

    private void setAdapters() {
        converterAdapter = new ArrayAdapter<>(ImprovedConverter.this,R.layout.support_simple_spinner_dropdown_item,CashConverter.cashTypes);
        spinnerConvertedFrom.setAdapter(converterAdapter);
        spinnerConvertedTo.setAdapter(converterAdapter);
    }

    private void setListeners() {
        button0.setOnClickListener(view -> {
            if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                text = editTextConvertedFrom.getText().toString()+"0";
                editTextConvertedFrom.setText(text);
            }
        });

        button1.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"1";
            editTextConvertedFrom.setText(text);
        });

        button2.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"2";
            editTextConvertedFrom.setText(text);
        });

        button3.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"3";
            editTextConvertedFrom.setText(text);
        });

        button4.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"4";
            editTextConvertedFrom.setText(text);
        });

        button5.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"5";
            editTextConvertedFrom.setText(text);
        });

        button6.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"6";
            editTextConvertedFrom.setText(text);
        });

        button7.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"7";
            editTextConvertedFrom.setText(text);
        });

        button8.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"8";
            editTextConvertedFrom.setText(text);
        });

        button9.setOnClickListener(view -> {
            text = editTextConvertedFrom.getText().toString()+"9";
            editTextConvertedFrom.setText(text);
        });

        buttonDecimal.setOnClickListener(view -> {
            if (!isDecimalEntered) {
                if (editTextConvertedFrom.getText().toString().isEmpty()) {
                    text = editTextConvertedFrom.getText().toString()+"0.";
                }
                else {
                    text = editTextConvertedFrom.getText().toString()+".";
                }
                isDecimalEntered = true;
                editTextConvertedFrom.setText(text);
            }
        });

        buttonAC.setOnClickListener(view -> {
            isDecimalEntered = false;
            editTextConvertedFrom.setText(null);
            editTextConvertedTo.setText(null);
        });

        buttonBackspace.setOnClickListener(view -> {
            if(!editTextConvertedFrom.getText().toString().isEmpty()) {
                text = editTextConvertedFrom.getText().toString();
                text = new StringBuffer().append(text).deleteCharAt(text.length()-1).toString();
                editTextConvertedFrom.setText(text);
                if (!text.contains(".")) {
                    isDecimalEntered = false;
                }
                if (text.equals("0")||text.isEmpty()) {
                    editTextConvertedFrom.setText(null);
                    editTextConvertedTo.setText(null);
                }
                else {
                    convert();
                }
            }
        });
        spinnerConvertedFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinnerConvertedFromIndex = i;

                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });

        spinnerConvertedTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                spinnerConvertedToIndex = i;
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) { }
        });


        editTextConvertedFrom.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (!editTextConvertedFrom.getText().toString().isEmpty()) {
                    convert();
                }
            }
        });

        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(ImprovedConverter.this,MainActivity.class));
        });
    }

    private void convert() {
        if (!editTextConvertedFrom.getText().toString().isEmpty())
            editTextConvertedTo.setText(
                    cashConverter.getResult(
                            Double.parseDouble(editTextConvertedFrom.getText().toString()),
                            spinnerConvertedFromIndex,
                            spinnerConvertedToIndex)
            );
    }
}