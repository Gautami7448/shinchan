package com.example.signup;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextEmail, editTextUsername, editTextPassword, editTextReenterPassword;
    private Button buttonSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize EditText and Button
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextUsername = findViewById(R.id.editTextUsername);
        editTextPassword = findViewById(R.id.editTextPassword);
        editTextReenterPassword = findViewById(R.id.editTextReenterPassword);
        buttonSignUp = findViewById(R.id.buttonSignUp);

        // Set onClickListener for the Sign Up button
        buttonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUp();
            }
        });
    }

    // Method to perform sign up
    private void signUp() {
        // Get the values entered by the user
        String email = editTextEmail.getText().toString().trim();
        String username = editTextUsername.getText().toString().trim();
        String password = editTextPassword.getText().toString().trim();
        String reenteredPassword = editTextReenterPassword.getText().toString().trim();

        // Perform validation
        if (email.isEmpty() || username.isEmpty() || password.isEmpty() || reenteredPassword.isEmpty()) {
            // Show error message if any field is empty
            Toast.makeText(this, "Please fill in all the fields", Toast.LENGTH_SHORT).show();
        } else if (!email.endsWith("@gmail.com")) {
            // Show error message if email format is invalid
            Toast.makeText(this, "Please enter a valid Gmail address", Toast.LENGTH_SHORT).show();
        } else if (!password.equals(reenteredPassword)) {
            // Show error message if passwords don't match
            Toast.makeText(this, "Passwords do not match", Toast.LENGTH_SHORT).show();
        } else {
            // If validation passes, you can proceed with sign up logic here
            // For demonstration, just displaying a success message
            Toast.makeText(this, "Sign up successful", Toast.LENGTH_SHORT).show();
            // Clear the input fields after successful sign up
            clearInputFields();
        }
    }

    // Method to clear input fields
    private void clearInputFields() {
        editTextEmail.getText().clear();
        editTextUsername.getText().clear();
        editTextPassword.getText().clear();
        editTextReenterPassword.getText().clear();
    }
}
