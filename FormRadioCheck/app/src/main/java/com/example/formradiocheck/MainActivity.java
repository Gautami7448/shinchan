package com.example.formradiocheck;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText addressEditText;
    private EditText prnEditText;
    private EditText phoneEditText;
    private RadioGroup genderRadioGroup;
    private CheckBox newsletterCheckBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        addressEditText = findViewById(R.id.addressEditText);
        prnEditText = findViewById(R.id.prnEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        genderRadioGroup = findViewById(R.id.genderRadioGroup);
        newsletterCheckBox = findViewById(R.id.newsletterCheckBox);
        Button submitButton = findViewById(R.id.submitButton);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitForm();
            }
        });
    }

    private void submitForm() {
        String name = nameEditText.getText().toString();
        String address = addressEditText.getText().toString();
        String prnNumber = prnEditText.getText().toString();
        String phoneNumber = phoneEditText.getText().toString();

        // Get selected gender
        int selectedGenderId = genderRadioGroup.getCheckedRadioButtonId();
        RadioButton selectedGenderRadioButton = findViewById(selectedGenderId);
        String gender = selectedGenderRadioButton.getText().toString();

        // Check if the newsletter checkbox is checked
        boolean subscribeToNewsletter = newsletterCheckBox.isChecked();

        // Display a toast message with the form data
        String message = "Name: " + name + "\nAddress: " + address + "\nPRN Number: " + prnNumber
                + "\nPhone Number: " + phoneNumber + "\nGender: " + gender
                + "\nSubscribe to newsletter: " + subscribeToNewsletter;
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
