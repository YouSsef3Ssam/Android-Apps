package com.example.youssefessam.training;

import android.os.DropBoxManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvResult;
    private EditText etTemp;
    private Spinner dropdown;
    private Spinner dropdown1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etTemp = (EditText) findViewById(R.id.etTemp);
        tvResult = (TextView) findViewById(R.id.tvResult);
        dropdown = (Spinner)findViewById(R.id.spinner1);

        String[] items = new String[]{"Celsius", "Fahrenheit", "Kelvin"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        dropdown1 = (Spinner)findViewById(R.id.spinner2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown1.setAdapter(adapter1);

    }


    public void Convert(View view) {

        if (etTemp.getText().equals("") || etTemp.getText().length() == 0 || etTemp.getText() == null)
            tvResult.setText("Temperature Required *");

        else if (etTemp.getText().charAt(0) == '.' && etTemp.getText().length() == 1)
            tvResult.setText("Invalid Value *");

        else {

            double temp = Double.parseDouble(String.valueOf(etTemp.getText()));
            String value = dropdown.getSelectedItem().toString();
            String value2 = dropdown1.getSelectedItem().toString();

            if (value == "Celsius")
            {
                if (value2 == value)
                    tvResult.setText(temp + " °C");
                else if (value2 == "Fahrenheit")
                    tvResult.setText(((temp * 9) / 5 + 32) + " °F");
                else
                    tvResult.setText((temp + 273.15) + " °K");
            }
            else if (value == "Fahrenheit")
            {
                if (value2 == value)
                    tvResult.setText(temp + " °F");
                else if (value2 == "Celsius")
                    tvResult.setText(((temp - 32) * 5 / 9) + " °C");
                else
                    tvResult.setText(((temp + 459.67) * 5 / 9) + " °K");
            }
            else
            {
                if (value2 == value)
                    tvResult.setText(temp + " °K");
                else if (value2 == "Celsius")
                    tvResult.setText((temp - 273.15) + " °C");
                else
                    tvResult.setText((temp * 9 / 5 - 459.67) + " °F");
            }
        }
    }
}
