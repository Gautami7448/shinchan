package com.example.radiobutton;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {

    RadioButton male, female;
    ImageView mi, fi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        male = findViewById(R.id.m);
        female = findViewById(R.id.f);
        mi = findViewById(R.id.img1);
        fi = findViewById(R.id.img2);

        // Set up a listener for the male RadioButton
        male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // If male RadioButton is checked, make mi ImageView visible
                if (isChecked) {
                    mi.setVisibility(View.VISIBLE);
                    // Make fi ImageView invisible
                    fi.setVisibility(View.INVISIBLE);
                } else {
                    // If male RadioButton is unchecked, make mi ImageView invisible
                    mi.setVisibility(View.INVISIBLE);
                }
            }
        });

        // Set up a listener for the female RadioButton
        female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // If female RadioButton is checked, make fi ImageView visible
                if (isChecked) {
                    fi.setVisibility(View.VISIBLE);
                    // Make mi ImageView invisible
                    mi.setVisibility(View.INVISIBLE);
                } else {
                    // If female RadioButton is unchecked, make fi ImageView invisible
                    fi.setVisibility(View.INVISIBLE);
                }
            }
        });
    }
}
