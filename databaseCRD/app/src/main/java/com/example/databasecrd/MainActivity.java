package com.example.databasecrd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText nameEditText, ageEditText;
    private RecyclerView recyclerView;
    private MyDatabaseHelper databaseHelper;
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.name_edit_text);
        ageEditText = findViewById(R.id.age_edit_text);
        recyclerView = findViewById(R.id.recycler_view);

        databaseHelper = new MyDatabaseHelper(this);
        adapter = new MyAdapter(databaseHelper.getAllData());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        findViewById(R.id.create_button).setOnClickListener(v -> {
            String name = nameEditText.getText().toString();
            String age = ageEditText.getText().toString();
            if (!name.isEmpty() && !age.isEmpty()) {
                databaseHelper.insertData(name, Integer.parseInt(age));
                adapter.updateData(databaseHelper.getAllData());
                clearInputFields();
            } else {
                Toast.makeText(this, "Please enter name and age", Toast.LENGTH_SHORT).show();
            }
        });

        adapter.setOnItemClickListener(position -> {
            databaseHelper.deleteData(adapter.getItem(position).getId());
            adapter.updateData(databaseHelper.getAllData());
        });
    }

    private void clearInputFields() {
        nameEditText.getText().clear();
        ageEditText.getText().clear();
    }
}
