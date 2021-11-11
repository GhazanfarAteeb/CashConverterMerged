package com.app.cashconvertermerged;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

public class SimpleConverter extends AppCompatActivity {
    double[] convertedValues;
    EditText values;
    Button convert;
    TextView result;
    double value, res;
    ImageView buttonBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_converter);
        init();
        setListeners();
    }

    private void init() {
        convertedValues = new double[3];
        values = findViewById(R.id.et_value);
        convert = findViewById(R.id.btn_convert);
        result = findViewById(R.id.tv_result);
        buttonBack = findViewById(R.id.back_button);
    }

    private void setListeners() {
        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRadioButtonConvertedFromClicked();
                onRadioButtonConvertedToClicked();
                result.setText(res + "");
            }
        });
        buttonBack.setOnClickListener(view -> {
            startActivity(new Intent(SimpleConverter.this,MainActivity.class));
        });
    }


    // taking one unit as a base unit and convert all the units to that unit
    // (taking euro as base unit in it)
    public void onRadioButtonConvertedFromClicked() {
        if (!values.getText().toString().isEmpty()) {
            if (((RadioButton)(findViewById(R.id.rb_euro))).isChecked()) {
                value = Double.parseDouble(values.getText().toString());
            }

            else if (((RadioButton)(findViewById(R.id.rb_us_dollars))).isChecked()) {
                value = Double.parseDouble(values.getText().toString()) * 0.87;
            }
            else if (((RadioButton)(findViewById(R.id.rb_rmb))).isChecked()) {
                value = Double.parseDouble(values.getText().toString()) / 7.36;
            }
        }

    }

    public void onRadioButtonConvertedToClicked() {
        if (!values.getText().toString().isEmpty()) {
            if (((RadioButton)(findViewById(R.id.rb_euro2))).isChecked()) {
                res = value;
            }
            else if (((RadioButton)(findViewById(R.id.rb_us_dollars2))).isChecked()) {
                res = value / 0.87;
            }
            else if (((RadioButton)(findViewById(R.id.rb_rmb2))).isChecked()) {
                res = value * 7.36;
            }
        }
    }
}