package com.example.playsound;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer1;
    private MediaPlayer mediaPlayer2;
    // Declare MediaPlayer variables for each sound

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize MediaPlayers
        mediaPlayer1 = MediaPlayer.create(this, R.raw.sound1);
        mediaPlayer2 = MediaPlayer.create(this, R.raw.sound2);
        // Initialize MediaPlayers for each sound

        // Set onClickListeners for play and stop buttons for each sound
        Button soundButton1Play = findViewById(R.id.soundButton1Play);
        Button soundButton1Stop = findViewById(R.id.soundButton1Stop);
        Button soundButton2Play = findViewById(R.id.soundButton2Play);
        Button soundButton2Stop = findViewById(R.id.soundButton2Stop);

        soundButton1Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(mediaPlayer1, soundButton1Play, soundButton1Stop);
            }
        });

        soundButton1Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSound(mediaPlayer1, soundButton1Play, soundButton1Stop);
            }
        });

        soundButton2Play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playSound(mediaPlayer2, soundButton2Play, soundButton2Stop);
            }
        });

        soundButton2Stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopSound(mediaPlayer2, soundButton2Play, soundButton2Stop);
            }
        });

        // Set other onClickListeners for additional sounds as needed
    }

    private void playSound(MediaPlayer mediaPlayer, Button playButton, Button stopButton) {
        mediaPlayer.start();
        playButton.setVisibility(View.GONE);
        stopButton.setVisibility(View.VISIBLE);
    }

    private void stopSound(MediaPlayer mediaPlayer, Button playButton, Button stopButton) {
        mediaPlayer.pause();
        mediaPlayer.seekTo(0);
        playButton.setVisibility(View.VISIBLE);
        stopButton.setVisibility(View.GONE);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mediaPlayer1.release();
        mediaPlayer2.release();
        // Release MediaPlayers for each sound
    }
}
