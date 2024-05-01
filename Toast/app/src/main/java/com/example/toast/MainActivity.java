package com.example.toast;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button snackbarButton = findViewById(R.id.snackbar_button);
        snackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(v, "Snackbar Message", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Action", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Action to perform when action button is clicked
                    }
                });
                snackbar.show();
            }
        });

        Button toastButton = findViewById(R.id.toast_button);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Toast Message", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
