package com.example.datetime;

import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView dateTextView;
    private TextView timeTextView;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get references to TextViews
        dateTextView = findViewById(R.id.dateTextView);
        timeTextView = findViewById(R.id.timeTextView);

        // Initialize Handler
        handler = new Handler();

        // Update time and date TextView initially
        updateTime();

        // Schedule task to update time and date TextView every second
        handler.postDelayed(timeDateUpdater, 1000);
    }

    // Runnable to update time and date TextView
    private Runnable timeDateUpdater = new Runnable() {
        @Override
        public void run() {
            updateTime();
            // Schedule the task to run again after 1 second
            handler.postDelayed(this, 1000);
        }
    };

    // Method to update time and date TextView
    private void updateTime() {
        // Get current date and time
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MMM dd, yyyy", Locale.getDefault());
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a", Locale.getDefault());

        // Set current date and time to TextViews
        dateTextView.setText(dateFormat.format(currentDate));
        timeTextView.setText(timeFormat.format(currentDate));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Remove any pending post of timeDateUpdater
        handler.removeCallbacks(timeDateUpdater);
    }
}
