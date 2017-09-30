package com.example.nhem.test.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ctrls on 26/09/2017.
 */

public class DatabaseHandle {
    private static final String TAG = "DatabaseHandle";
    private MyDatabase myDatabase;

    public DatabaseHandle(Context context){
        myDatabase = new MyDatabase(context);
    }
    private static DatabaseHandle databaseHandle;
    public static DatabaseHandle getInstance(Context context){
        if (databaseHandle == null){
            databaseHandle = new DatabaseHandle(context);
        }
        return databaseHandle;
    }
    private SQLiteDatabase sqLiteDatabase;
    public List<AnswerModel> getListAnswerMusic(){
        List<AnswerModel> answerModelList = new ArrayList<>();
        sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM db_music", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String kind = cursor.getString(1);
            String content = cursor.getString(2);

            AnswerModel answerModel = new AnswerModel(id, kind, content);
            answerModelList.add(answerModel );
            cursor.moveToNext();
        }
        Log.d(TAG, "getListAnswer: " + answerModelList.toString());
        return answerModelList;
    }
    public List<AnswerModel> getListAnswerQuote(){
        List<AnswerModel> answerModelList = new ArrayList<>();
        sqLiteDatabase = myDatabase.getReadableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM db_quote", null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            int id = cursor.getInt(0);
            String kind = cursor.getString(1);
            String content = cursor.getString(2);

            AnswerModel answerModel = new AnswerModel(id, kind, content);
            answerModelList.add(answerModel );
            cursor.moveToNext();
        }
        Log.d(TAG, "getListAnswer: " + answerModelList.toString());
        return answerModelList;
    }
}
