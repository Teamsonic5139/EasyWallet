package com.example.beam.easywallet.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Beam on 12/10/2017.
 */

public class WallletDB extends SQLiteOpenHelper{

    private static final String DATABASE_NAME = "wallet.db";
    private static final int DATABASE_VERSION = 8;

    public static final String TABLE_NAME = "walletTable";
    public static final String COL_ID = "_id";
    public static final String COL_TITLE = "name";
    public static final String COL_PRICE = "price";
     public static final String COL_IMAGE = "image";

    private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
            + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COL_IMAGE + " TEXT, "
            + COL_TITLE + " TEXT, "
            + COL_PRICE + " TEXT)";


    public WallletDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        insertInitialData(db);
    }

    private void insertInitialData(SQLiteDatabase db) {
        ContentValues cv = new ContentValues();
        cv.put(COL_IMAGE,"ic_income.png");
        cv.put(COL_TITLE, "คุณพ่อให้เงิน");
        cv.put(COL_PRICE, "8000");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"ic_expense.png");
        cv.put(COL_TITLE, "จ่ายค่าหอ");
        cv.put(COL_PRICE, "2500");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"ic_expense.png");
        cv.put(COL_TITLE, "ซื้อล็อตเตอรี่ 1 ชุด");
        cv.put(COL_PRICE, "700");
        db.insert(TABLE_NAME, null, cv);

        cv = new ContentValues();
        cv.put(COL_IMAGE,"ic_income.png");
        cv.put(COL_TITLE, "ถูกล็อตเตอรี่รางวัลที่ 1");
        cv.put(COL_PRICE, "300000000");
        db.insert(TABLE_NAME, null, cv);


    }

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

}
