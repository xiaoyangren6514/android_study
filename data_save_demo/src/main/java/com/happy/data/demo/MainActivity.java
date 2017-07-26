package com.happy.data.demo;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.happy.data.demo.db.MySQLiteOpenHelper;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private MySQLiteOpenHelper sqLiteOpenHelper;

    private SQLiteDatabase sqLiteDB = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void create_db(View view) {
        sqLiteOpenHelper = new MySQLiteOpenHelper(this, "test.db", null, 1);
        sqLiteDB = sqLiteOpenHelper.getWritableDatabase();
    }

    public void upgrade_db(View v) {
        sqLiteOpenHelper = new MySQLiteOpenHelper(this, "test.db", null, 3);
        sqLiteOpenHelper.getWritableDatabase();
    }

    public void add(View v) {
        sqLiteDB = sqLiteOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "旺财");
        values.put("mobile", 123456);
        long i = sqLiteDB.insert("user", null, values);
        Log.i(TAG, "add i = " + i);
        query(v);
    }

    public void update(View view) {
        sqLiteDB = sqLiteOpenHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", "旺财");
        values.put("mobile", 1234567890);
        long i = sqLiteDB.update("user", values, " name = ? ", new String[]{"旺财"});
        Log.i(TAG, "update i = " + i);
        query(view);
    }

    public void delete(View view) {
        sqLiteDB = sqLiteOpenHelper.getWritableDatabase();
        long i = sqLiteDB.delete("user", "name = ?", new String[]{"旺财"});
        Log.i(TAG, "delete i = " + i);
        query(view);
    }

    public void query(View view) {
        sqLiteDB = sqLiteOpenHelper.getWritableDatabase();
        Cursor cursor = sqLiteDB.query("user", null, null, null, null, null, null);
        if (cursor.moveToNext()) {
            do {
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int mobile = cursor.getInt(cursor.getColumnIndex("mobile"));
                Log.i(TAG, "query:\n name:" + name + ",mobile:" + mobile);
            } while (cursor.moveToNext());
        }
        cursor.close();
    }

    /**
     * 保存数据
     *
     * @param content
     */
    private void save(String content) {
        try {
            FileOutputStream fileOutputStream = openFileOutput("data", MODE_PRIVATE);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 读取数据
     *
     * @return
     */
    private String load() {
        StringBuilder sb = new StringBuilder();
        try {
            FileInputStream fileInputStream = openFileInput("data");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

}

