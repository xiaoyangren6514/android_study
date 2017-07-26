package com.happy.data.demo.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by zhonglongquan on 2017/4/7.
 */

public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    private Context context;

    private static final String CREATE_TABLE_USER = "create table user (" +
            " id integer primary key autoincrement," +
            " name text, " +
            " mobile integer " +
            ")";

    private static final String CREATE_TABLE_TEACHER = "create table teacher (" +
            " id integer primary key autoincrement, "
            + "name text,"
            + "mobile integer"
            +
            ")";

    public MySQLiteOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_USER);
        Toast.makeText(context, "create database success", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");
        onCreate(db);
        Toast.makeText(context, "upgrade database success", Toast.LENGTH_SHORT).show();
    }
}
