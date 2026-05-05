package com.example.habitationandroid;

import android.os.Bundle;

import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {


    private EditText etSurfaceArea, etRoomCount;
    private CheckBox cbSwimmingPool;
    private TextView tvResultOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        // 2. Ensure Button is imported
        Button btnCalculate = findViewById(R.id.btnCalculateTax);
        btnCalculate.setOnClickListener(v -> calculateLocalTax());
    }

    private void initViews() {
        etSurfaceArea = findViewById(R.id.etSurfaceArea);
        etRoomCount = findViewById(R.id.etRoomCount);
        cbSwimmingPool = findViewById(R.id.cbSwimmingPool);
        tvResultOutput = findViewById(R.id.tvResultOutput);
    }

    private void calculateLocalTax() {
        double area = parseDoubleSafe(etSurfaceArea);
        int rooms = parseIntSafe(etRoomCount);
        boolean hasPool = cbSwimmingPool.isChecked();

        // Logic for tax calculation
        double baseTax = area * 2;
        double extraTax = (rooms * 50) + (hasPool ? 100 : 0);
        double totalTax = baseTax + extraTax;

        tvResultOutput.setText("Montant total des impôts : " + totalTax + " DH");
    }


    private double parseDoubleSafe(EditText input) {
        try {
            String value = input.getText().toString().trim();
            return value.isEmpty() ? 0 : Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private int parseIntSafe(EditText input) {
        try {
            String value = input.getText().toString().trim();
            return value.isEmpty() ? 0 : Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
