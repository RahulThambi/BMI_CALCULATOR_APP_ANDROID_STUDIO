package com.example.bmi_calculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class summary extends AppCompatActivity {
    TextView textView11, textView12, textView10;
    ImageView imageView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
        textView11 = findViewById(R.id.textView11);
        textView12 = findViewById(R.id.textView12);
        textView10 = findViewById(R.id.textView10);
        imageView2 = findViewById(R.id.imageView2);

        Intent intent = getIntent();
        String name = intent.getStringExtra("key");
        String bmi = intent.getStringExtra("bmi");
        Double height = intent.getDoubleExtra("height", 0.0);

        if (bmi != null) {
            double bm = Double.parseDouble(bmi);
            DecimalFormat decimalFormat = new DecimalFormat("#.#");
            String formattedBmi = decimalFormat.format(bm);

            textView11.setText(formattedBmi);
            textView10.setText(name + " your BMI is: ");

            if (bm < 18.5) {
                textView12.setText("You are underweight");
                imageView2.setImageResource(R.drawable.underweight);
            } else if (bm < 24.9) {
                textView12.setText("You are normal");
                imageView2.setImageResource(R.drawable.normal);
            } else if (bm < 29.9) {
                textView12.setText("You are overweight");
                imageView2.setImageResource(R.drawable.overweight);
            } else if (bm < 34.9) {
                textView12.setText("You are obese");
                imageView2.setImageResource(R.drawable.obese);
            } else {
                textView12.setText("You are extremely obese");
                imageView2.setImageResource(R.drawable.ext_obese);
            }
        } else {
            // Handle the case where bmi is null
        }
    }

    @Override
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
            Intent intent = new Intent(summary.this,MainActivity.class);
            startActivity(intent);
            return true;
        }
        else
        {
            return super.onOptionsItemSelected(item);
        }

    }

    public void back(View v) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void ideal_weight(View v) {
        Intent intent = new Intent(this, idealweight.class);
        intent.putExtra("bmi", getIntent().getStringExtra("bmi"));
        intent.putExtra("height", getIntent().getDoubleExtra("height", 0.0));
        startActivity(intent);
    }
}
