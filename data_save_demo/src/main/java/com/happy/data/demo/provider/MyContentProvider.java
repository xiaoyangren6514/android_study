package com.happy.data.demo.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.happy.data.demo.db.MySQLiteOpenHelper;

public class MyContentProvider extends ContentProvider {

    public static final int BOOK_DIR = 0;
    public static final int BOOK_ITEM = 1;
    public static final int TEACHER_DIR = 2;
    public static final int TEACHER_ITEM = 3;

    private static UriMatcher uriMatcher;

    private static final String AUTHORITY = "com.happ.data.demo";

    private MySQLiteOpenHelper sqLiteOpenHelper;

    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, "book", BOOK_DIR);
        uriMatcher.addURI(AUTHORITY, "book/#", BOOK_ITEM);
        uriMatcher.addURI(AUTHORITY, "teacher", TEACHER_DIR);
        uriMatcher.addURI(AUTHORITY, "teacher/#", TEACHER_ITEM);
    }

    public MyContentProvider() {

    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        SQLiteDatabase writableDatabase = sqLiteOpenHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                return writableDatabase.delete("book", selection, selectionArgs);
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                return writableDatabase.delete("book", "id = ?", new String[]{bookId});
        }
        return 0;
    }

    @Override
    public String getType(Uri uri) {
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                return "vnd.android.cursor.dir/vnd" + AUTHORITY + ".book";
            case BOOK_ITEM:
                return "vnd.android.cursor.item/vnd" + AUTHORITY + ".book";
            case TEACHER_DIR:
                return "vnd.android.cursor.dir/vnd" + AUTHORITY + ".teacher";
            case TEACHER_ITEM:
                return "vnd.android.cursor.item/vnd" + AUTHORITY + ".teacher";
        }
        return null;
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
            case BOOK_ITEM:
                long newBookId = sqLiteDatabase.insert("book", null, values);
                return Uri.parse("content://" + AUTHORITY + "/book/" + newBookId);
        }
        return null;
    }

    @Override
    public boolean onCreate() {
        sqLiteOpenHelper = new MySQLiteOpenHelper(getContext(), "test2.db", null, 5);
        return true;
    }

    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {
        SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                return sqLiteDatabase.query("book", projection, selection, selectionArgs, null, null, sortOrder);
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                return sqLiteDatabase.query("book", projection, "id = ?", new String[]{bookId}, null, null, sortOrder);
        }
        return null;
    }

    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        SQLiteDatabase sqLiteDatabase = sqLiteOpenHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case BOOK_DIR:
                return sqLiteDatabase.update("book", values, selection, selectionArgs);
            case BOOK_ITEM:
                String bookId = uri.getPathSegments().get(1);
                return sqLiteDatabase.update("book", values, "id = ?", new String[]{bookId});
        }
        return 0;
    }
}
