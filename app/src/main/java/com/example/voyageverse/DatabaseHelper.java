package com.example.voyageverse;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "profiles.db";
    private static final int DATABASE_VERSION = 1;

    // Table name and column names
    public static final String TABLE_PROFILE = "profile";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_EMAIL = "email";
    public static final String COLUMN_AREA = "area";

    // SQL query to create the profile table
    private static final String SQL_CREATE_PROFILE_TABLE =
            "CREATE TABLE " + TABLE_PROFILE + " (" +
                    COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    COLUMN_NAME + " TEXT," +
                    COLUMN_EMAIL + " TEXT," +
                    COLUMN_AREA + " TEXT)";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_PROFILE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Handle database upgrades as needed
    }

    // Method to add a new profile record
    public long addProfile(String name, String email, String area) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_EMAIL, email);
        values.put(COLUMN_AREA, area);

        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(TABLE_PROFILE, null, values);
        db.close();
        return newRowId;
    }
}
