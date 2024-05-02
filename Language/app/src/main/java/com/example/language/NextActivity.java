package com.example.language;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class NextActivity extends AppCompatActivity {

    TextView languag;
    ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);

        languag=findViewById(R.id.language);
        imageView=findViewById(R.id.image);
        String language = getIntent().getStringExtra("LANGUAGE");
        if(language.equals("Java")){
            languag.setText(language);
            imageView.setImageResource(R.drawable.ljava);

        }
        if(language.equals("JavaScript")){
            languag.setText(language);
            imageView.setImageResource(R.drawable.javascript);

        }
        if(language.equals("Python")){
            languag.setText(language);
            imageView.setImageResource(R.drawable.python);

        }
        if(language.equals("C++")){
            languag.setText(language);
            imageView.setImageResource(R.drawable.cpp);

        }
    }
}