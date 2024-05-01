package com.example.countdown;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView countdownTextView;
    private Button startButton;
    private Button stopButton;
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        countdownTextView = findViewById(R.id.countdownTextView);
        startButton = findViewById(R.id.startButton);
        stopButton = findViewById(R.id.stopButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startTimer();
            }
        });

        stopButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopTimer();
            }
        });
    }

    private void startTimer() {
        long durationInMillis = 60000; // 1 minute

        countDownTimer = new CountDownTimer(durationInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long secondsUntilFinished = millisUntilFinished / 1000;
                long minutes = secondsUntilFinished / 60;
                long seconds = secondsUntilFinished % 60;
                String timeLeftFormatted = String.format("%02d:%02d", minutes, seconds);
                countdownTextView.setText("Time left: " + timeLeftFormatted);
            }

            @Override
            public void onFinish() {
                countdownTextView.setText("Countdown finished");
            }
        }.start(); // Start the countdown timer

        // Disable start button while timer is running
        startButton.setEnabled(false);
        // Enable stop button while timer is running
        stopButton.setEnabled(true);
    }

    private void stopTimer() {
        if (countDownTimer != null) {
            countDownTimer.cancel();
            countdownTextView.setText("Countdown stopped");
        }

        // Enable start button after stopping the timer
        startButton.setEnabled(true);
        // Disable stop button after stopping the timer
        stopButton.setEnabled(false);
    }
}
