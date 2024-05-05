package com.example.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {
    Spinner spin;
    EditText name, height, weight;
    Button button;
    AutoCompleteTextView autoCompleteTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spin = findViewById(R.id.spinner);
        name = findViewById(R.id.editTextText);
        height = findViewById(R.id.editTextNumber);
        weight = findViewById(R.id.editTextNumber2);
        button = findViewById(R.id.button);
        autoCompleteTextView = findViewById(R.id.autoCompleteTextView);

        String[] loc = getResources().getStringArray(R.array.location);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, loc);
        autoCompleteTextView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nam = name.getText().toString();
                String metric = spin.getSelectedItem().toString();
                String bmi;

                Intent intent = new Intent(MainActivity.this,  summary.class);

                String weigh = weight.getText().toString();
                Double weightt = Double.parseDouble(weigh);

                String heigh = height.getText().toString();
                Double heighh = Double.parseDouble(heigh);

                if (metric.equals("m-kg")) {
                    Double bmi1 = weightt / (heighh * heighh);
                    bmi = bmi1.toString();
                } else {
                    Double bmi1 = 730 * (weightt / (heighh * heighh));
                    bmi = bmi1.toString();
                }

                intent.putExtra("bmi", bmi);
                intent.putExtra("height", heighh);
                intent.putExtra("key", nam);
                startActivity(intent);
            }
        });



    }

}
