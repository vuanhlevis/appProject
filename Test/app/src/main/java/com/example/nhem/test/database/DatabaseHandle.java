package com.example.nhem.test.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import static com.example.nhem.test.Tab2_status.KIND;

/**
 * Created by ctrls on 26/09/2017.
 */

public class DatabaseHandle {
    private static final String EMOTION = "love";
    private MyDatabase myDatabase;

    public DatabaseHandle(Context context) {
        myDatabase = new MyDatabase(context);
    }

    private static DatabaseHandle databaseHandle;

    public static DatabaseHandle getInstance(Context context) {
        if (databaseHandle == null) {
            databaseHandle = new DatabaseHandle(context);
        }
        return databaseHandle;
    }

    private SQLiteDatabase sqLiteDatabase;


    public String getMusicAnswer() {
        sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursorMusic;
        if (KIND == "'*'")
        cursorMusic = sqLiteDatabase.rawQuery("SELECT content FROM db_music ORDER BY RANDOM() LIMIT 1", null);
        else
        cursorMusic = sqLiteDatabase.rawQuery("SELECT content FROM db_music WHERE kind == " + KIND +" ORDER BY RANDOM() LIMIT 1", null);
        cursorMusic.moveToFirst();
        return cursorMusic.getString(0);
    }

    public String getQuoteAnswer() {
        sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursorQuote;
        if (KIND == "'*'")
            cursorQuote = sqLiteDatabase.rawQuery("SELECT content FROM db_quote ORDER BY RANDOM() LIMIT 1", null);
        else {
            if (KIND == "'sadlove'") KIND = "'love'";
            if (KIND == "'sadjob'") KIND = "'job'";
            cursorQuote = sqLiteDatabase.rawQuery("SELECT content FROM db_quote WHERE kind == " + KIND + " ORDER BY RANDOM() LIMIT 1", null);
        }
        cursorQuote.moveToFirst();
        return cursorQuote.getString(0);
    }
}

