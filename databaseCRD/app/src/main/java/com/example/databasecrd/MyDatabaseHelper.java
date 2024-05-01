package com.example.databasecrd;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "my_database";
    private static final int DATABASE_VERSION = 1;

    public MyDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create your database tables here
        db.execSQL("CREATE TABLE IF NOT EXISTS my_table (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "name TEXT, " +
                "age INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Upgrade your database schema here
        db.execSQL("DROP TABLE IF EXISTS my_table");
        onCreate(db);
    }

    public List<DataModel> getAllData() {
        List<DataModel> dataList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM my_table", null);

        if (cursor.moveToFirst()) {
            do {
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                dataList.add(new DataModel(id, name, age));
            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return dataList;
    }

    public void insertData(String name, int age) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("age", age);
        db.insert("my_table", null, values);
        db.close();
    }

    public void deleteData(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("my_table", "_id=?", new String[]{String.valueOf(id)});
        db.close();
    }
}
