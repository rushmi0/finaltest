package com.example.finaltest;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Calculate extends AppCompatActivity {

    EditText inputTemperature;
    Spinner spinFrom, spinTo;
    TextView resultTextView;
    Button calcuBTN; // Added Button reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculate);

        inputTemperature = findViewById(R.id.inputTemperature);
        resultTextView = findViewById(R.id.resultTextView);

        spinFrom = findViewById(R.id.spinFrom);
        spinTo = findViewById(R.id.spinTo);
        calcuBTN = findViewById(R.id.calcuBTN);


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.temperature_units,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinFrom.setAdapter(adapter);
        spinTo.setAdapter(adapter);

        // Set up listener for item selection
        spinFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convertTemperature();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {

            }
        });

        spinTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                convertTemperature();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                //
            }
        });


        // Set click listener for the button
        calcuBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convertTemperature();
            }
        });
    }

    private void convertTemperature() {
        String fromUnit = spinFrom.getSelectedItem().toString();
        String toUnit = spinTo.getSelectedItem().toString();

        if (!inputTemperature.getText().toString().isEmpty()) {
            double inputTemp = Double.parseDouble(inputTemperature.getText().toString());
            double resultTemp;

            if (fromUnit.equals("Celsius") && toUnit.equals("Fahrenheit")) {
                resultTemp = (inputTemp * 9 / 5) + 32;
            } else if (fromUnit.equals("Celsius") && toUnit.equals("Kelvin")) {
                resultTemp = inputTemp + 273.15;
            } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Celsius")) {
                resultTemp = (inputTemp - 32) * 5 / 9;
            } else if (fromUnit.equals("Fahrenheit") && toUnit.equals("Kelvin")) {
                resultTemp = ((inputTemp - 32) * 5 / 9) + 273.15;
            } else if (fromUnit.equals("Kelvin") && toUnit.equals("Celsius")) {
                resultTemp = inputTemp - 273.15;
            } else if (fromUnit.equals("Kelvin") && toUnit.equals("Fahrenheit")) {
                resultTemp = ((inputTemp - 273.15) * 9 / 5) + 32;
            } else {
                resultTemp = inputTemp;
            }

            resultTextView.setText(String.format("%.2f %s", resultTemp, toUnit));
        }
    }
}
