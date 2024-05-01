package com.example.profilepage;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        ImageView profileImageView = findViewById(R.id.profileImageView);
        TextView nameTextView = findViewById(R.id.nameTextView);
        TextView emailTextView = findViewById(R.id.emailTextView);

        // Set profile data
        profileImageView.setImageResource(R.drawable.profile_picture); // Set your profile picture here
        nameTextView.setText("John Doe"); // Set your name here
        emailTextView.setText("john.doe@example.com"); // Set your email here
    }
}
