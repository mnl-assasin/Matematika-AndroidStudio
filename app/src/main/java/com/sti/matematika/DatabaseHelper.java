package com.sti.matematika;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "DB_MATEMATIKA";
    public static final int DB_VERSION = 1;

    private static DatabaseHelper mInstance = null;

    private DatabaseHelper(Context mContext) {
        super(mContext, DB_NAME, null, DB_VERSION);
    }

    public static DatabaseHelper getInstance(Context mContext) {
        if (mInstance == null) {
            mInstance = new DatabaseHelper(mContext);
        }

        return mInstance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
//		db.execSQL("CREATE TABLE IF NOT EXISTS tbl_emission_history(id varchar, emission_type integer, emission_value real, area varchar)");
        db.execSQL("CREATE TABLE IF NOT EXISTS tbl_score(game_type integer, difficulty integer, name varchar, score varchar)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // TODO Auto-generated method stub
        db.execSQL("DROP TABLE IF EXISTS tbl_score");
        onCreate(db);
    }

}
