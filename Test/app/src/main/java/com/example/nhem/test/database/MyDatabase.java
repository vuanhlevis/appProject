package com.example.nhem.test.database;

import android.content.Context;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

/**
 * Created by ctrls on 26/09/2017.
 */

public class MyDatabase extends SQLiteAssetHelper {
    private static final String DATABASE_NAME = "emotion.db";
    private static final int DATABASE_VERSION = 1;

    public MyDatabase(Context context) {
        super(context, DATABASE_NAME, null,
                DATABASE_VERSION);
    }
}
