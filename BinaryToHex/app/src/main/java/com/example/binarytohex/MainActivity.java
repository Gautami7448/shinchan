package com.example.binarytohex;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Button convert;
    TextView result;
    Spinner sp;
    String[] conversions = {"Hex", "Binary"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        convert = findViewById(R.id.cnv);
        result = findViewById(R.id.result);
        sp = findViewById(R.id.spn);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, conversions);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp.setAdapter(adapter);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                convert();
            }
        });
    }

    private void convert() {
        String input = editText.getText().toString().trim();
        if (!input.isEmpty()) {
            try {
                int number = Integer.parseInt(input);
                String conversionType = sp.getSelectedItem().toString();
                String convertedResult = "";

                if (conversionType.equals("Hex")) {
                    convertedResult = Integer.toHexString(number);
                } else if (conversionType.equals("Binary")) {
                    convertedResult = Integer.toBinaryString(number);
                }

                result.setText(convertedResult);
            } catch (NumberFormatException e) {
                result.setText("Invalid input");
            }
        } else {
            result.setText("Please enter a number");
        }
    }
}
