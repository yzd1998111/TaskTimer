package com.example.yuanzhendong.tasktimer;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AppDatabase extends SQLiteOpenHelper{
    private static final String TAG = "AppDatabase";
    public static final String DATABASE_NAME = "TaskTimer.db";
    public static final int DATABASE_VERSION = 1;

    private static AppDatabase instance = null;

    public AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "AppDatabase: constructor");
    }

    static AppDatabase getInstance(Context context) {
        Log.d(TAG, "getInstance: starts");
        if (instance == null) {
            instance = new AppDatabase(context);
        }
        Log.d(TAG, "getInstance: ends");
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        Log.d(TAG, "onCreate: starts");
        String sSQL;
        sSQL = "create table TASKS (_id integer primary key not null, Name not null, Description text, Sortorder integer);";
        Log.d(TAG, "onCreate: " + sSQL);
        sqLiteDatabase.execSQL(sSQL);
        Log.d(TAG, "onCreate: ends");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: starts");
        switch (oldVersion) {
            case 1:
                break;
            default:
                throw new IllegalStateException("onupgrade with unknown newVersion" + newVersion);
        }
        Log.d(TAG, "onUpgrade: ends");
    }
}
