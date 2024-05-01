package com.example.openurl;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<TableRow> tableRows = new ArrayList<>();
        tableRows.add(new TableRow("Java", "James Gosling", "https://www.java.com"));
        tableRows.add(new TableRow("Python", "Guido van Rossum", "https://www.python.org"));
        tableRows.add(new TableRow("C++", "Bjarne Stroustrup", "https://www.cplusplus.com"));

        TableAdapter adapter = new TableAdapter(tableRows, this);
        recyclerView.setAdapter(adapter);
    }
}
