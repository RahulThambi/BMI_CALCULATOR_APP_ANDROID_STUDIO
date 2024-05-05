package com.example.bmi_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class idealweight extends AppCompatActivity
{
    TextView textView14;
    Button button4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_idealweight);
        textView14 = findViewById(R.id.textView14);
        button4 = findViewById(R.id.button4);


        Intent intent = getIntent();
        double bmi = intent.getDoubleExtra("bmi", 0.0);
        double height = intent.getDoubleExtra("height", 0.0);

        String idealWeightRange = calculateIdealWeightRange(bmi, height);
        textView14.setText("Ideal weight range: " + idealWeightRange);

        button4.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intt = new Intent(idealweight.this, summary.class);
                startActivity(intt);
            }
        });
    }

    public String calculateIdealWeightRange(double bmi, double height) {
        double minWeight;
        double maxWeight;

        if (bmi < 18.5) { // Underweight
            minWeight = Math.round(18.5 * height * height * 10.0) / 10.0;
            maxWeight = Math.round(24.9 * height * height * 10.0) / 10.0;
        } else if (bmi < 24.9) { // Normal weight
            minWeight = Math.round(18.5 * height * height * 10.0) / 10.0;
            maxWeight = Math.round(24.9 * height * height * 10.0) / 10.0;
        } else if (bmi < 29.9) { // Overweight
            minWeight = Math.round(24.9 * height * height * 10.0) / 10.0;
            maxWeight = Math.round(29.9 * height * height * 10.0) / 10.0;
        } else if (bmi < 34.9) { // Obese
            minWeight = Math.round(29.9 * height * height * 10.0) / 10.0;
            maxWeight = Math.round(34.9 * height * height * 10.0) / 10.0;
        } else { // Extremely obese
            minWeight = Math.round(34.9 * height * height * 10.0) / 10.0;
            maxWeight = Double.POSITIVE_INFINITY; // No upper limit
        }

        DecimalFormat decimalFormat = new DecimalFormat("#.#");
        String formattedMinWeight = decimalFormat.format(minWeight);
        String formattedMaxWeight = decimalFormat.format(maxWeight);

        return formattedMinWeight + " - " + formattedMaxWeight;
    }

    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.page_viewer_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item)
    {
        int itemId = item.getItemId();

        if (itemId == R.id.item1)
        {
            Intent intent = new Intent(idealweight.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }

    }
}
