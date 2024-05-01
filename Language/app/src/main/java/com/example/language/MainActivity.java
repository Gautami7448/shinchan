package com.example.language;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find buttons
        Button javaButton = findViewById(R.id.java);
        Button cppButton = findViewById(R.id.cpp);
        Button pythonButton = findViewById(R.id.python);
        Button javascriptButton = findViewById(R.id.javascript);

        // Set click listeners for each button
        javaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity("Java");
            }
        });

        cppButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity("C++");
            }
        });

        pythonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity("Python");
            }
        });

        javascriptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startNextActivity("JavaScript");
            }
        });
    }

    // Method to start the next activity and pass data
    private void startNextActivity(String language) {
        Intent intent = new Intent(MainActivity.this, NextActivity.class);
        intent.putExtra("LANGUAGE", language);
        startActivity(intent);
    }
}
