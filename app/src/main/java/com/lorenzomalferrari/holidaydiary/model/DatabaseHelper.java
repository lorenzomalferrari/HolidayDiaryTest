package com.lorenzomalferrari.holidaydiary.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     * Nome del file dove sarà contenuto tutto il database
     */
    public static final String DATABASE_NAME = "holidayDiary.db";
    /**
     * Nome della tabella contenente tutti gli utenti e con i loro rispettivi dati
     */
    public static final String TABLE_NAME = "User";
    /**
     * Lista delle colonne presenti nella tabella User
     */
    public static final String COL_1 = "id";
    public static final String COL_2 = "firstName";
    public static final String COL_3 = "lastName";
    public static final String COL_4 = "username";
    public static final String COL_5 = "password";
    public static final String COL_6 = "email";
    public static final String COL_7 = "city";
    public static final String COL_8 = "country";
    public static final String COL_9 = "gender";
    public static final String COL_10 = "age";
    public static final String COL_11 = "birthdate";
    public static final String COL_12 = "registration_date";
    public static final String COL_13 = "last_login";

    /**
     *
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    /**
     *
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + "(id INTEGER PRIMARY KEY,firstName VARCHAR(255),lastName VARCHAR(255)," +
                "username VARCHAR(255),password VARCHAR(255),email VARCHAR(255),city VARCHAR(255),country VARCHAR(255),gender CHAR(1)" +
                ",age VARCHAR(255),birthdate DATE,registration_date DATETIME,last_login DATETIME)");
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    /**
     *
     * @param arrayList
     * @return
     */
    public boolean insertData(ArrayList arrayList){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2,arrayList.get(0).toString());
        contentValues.put(COL_3,arrayList.get(1).toString());
        contentValues.put(COL_4,arrayList.get(2).toString());
        contentValues.put(COL_5,arrayList.get(3).toString());
        contentValues.put(COL_6,arrayList.get(4).toString());
        contentValues.put(COL_7,arrayList.get(5).toString());
        contentValues.put(COL_8,arrayList.get(6).toString());
        contentValues.put(COL_9,arrayList.get(7).toString());
        contentValues.put(COL_10,arrayList.get(8).toString());
        contentValues.put(COL_11,arrayList.get(9).toString());
        contentValues.put(COL_12,arrayList.get(10).toString());
        contentValues.put(COL_13,arrayList.get(11).toString());
        long isInsert = db.insert(TABLE_NAME,null,contentValues);
        if (isInsert == -1)
            return false;
        else
            return true;
    }
}
