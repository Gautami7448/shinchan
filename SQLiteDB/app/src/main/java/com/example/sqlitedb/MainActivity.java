package com.example.sqlitedb;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextName, editTextAge;
    private Button buttonAdd, buttonDelete;
    TextView t1;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.edit_text_name);
        editTextAge = findViewById(R.id.edit_text_age);
        buttonAdd = findViewById(R.id.button_add);
        buttonDelete = findViewById(R.id.button_delete);
        t1=findViewById(R.id.text1);

        dbHelper = new DatabaseHelper(this);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editTextName.getText().toString().trim();
                String ageString = editTextAge.getText().toString().trim();

                if (name.isEmpty() || ageString.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter name and age", Toast.LENGTH_SHORT).show();
                    return;
                }

                int age = Integer.parseInt(ageString);

                if (dbHelper.addData(name, age)) {
                    Toast.makeText(MainActivity.this, "Data inserted", Toast.LENGTH_SHORT).show();
                    editTextName.setText("");
                    editTextAge.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Error inserting data", Toast.LENGTH_SHORT).show();
                }
                t1.append("\nName: "+ name +", Age: "+ age +"\n");
            }
        });



        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbHelper.deleteData();
                Toast.makeText(MainActivity.this, "All data deleted", Toast.LENGTH_SHORT).show();
                t1.setText("");
            }

        });
    }
}
