package com.lorenzomalferrari.holidaydiary.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {

    /**
     *
     */
    public static final String DATABASE_NAME = "holidayDiary.db";
    /**
     *
     */
    public static final String TABLE_NAME = "User";
    /**
     * Lista delle colonne presenti nella tabella User
     * (Tecnica alternativa)
     */
    String[] COL_TABLE = new String[]{"id","firstName","lastName","username","password","email",
            "city","country","gender","age","birthdate","registration_date","last_login"};

    /**
     * Costructor
     * @param context
     */
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    /**
     * Creo la tabella nel database
     * @param db
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+ TABLE_NAME + "(" +
                "id INTEGER PRIMARY KEY," +
                "firstName VARCHAR(255)," +
                "lastName VARCHAR(255)," +
                "username VARCHAR(255)," +
                "password VARCHAR(255)," +
                "email VARCHAR(255)," +
                "city VARCHAR(255)," +
                "country VARCHAR(255)," +
                "gender CHAR(1)," +
                "age VARCHAR(255)," +
                "birthdate DATE," +
                "registration_date DATETIME," +
                "last_login DATETIME)");
    }

    /**
     *
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(ArrayList arrayList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TABLE[1],arrayList.get(0).toString());
        contentValues.put(COL_TABLE[2],arrayList.get(1).toString());
        contentValues.put(COL_TABLE[3],arrayList.get(2).toString());
        contentValues.put(COL_TABLE[4],arrayList.get(3).toString());
        contentValues.put(COL_TABLE[5],arrayList.get(4).toString());
        contentValues.put(COL_TABLE[6],arrayList.get(5).toString());
        contentValues.put(COL_TABLE[7],arrayList.get(6).toString());
        contentValues.put(COL_TABLE[8],arrayList.get(7).toString());
        //contentValues.put(COL_TABLE[9],calcAge());//con birthdate calcolare l'età
        contentValues.put(COL_TABLE[10],arrayList.get(8).toString());
        long result = db.insert(TABLE_NAME,null ,contentValues);
        if(result == -1)
            return false;
        else
            return true;
    }

    /**
     * Ottengo tutti i dati degli utenti presenti all'interno del database
     * @return
     */
    public Cursor getAllData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    /**
     * Ottengo tutti i dat dell'utente controllando i valori dei campi del login
     * @param email
     * @param password
     * @return
     */
    public Cursor getData(String email,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+TABLE_NAME + " WHERE email = '"+email+"' AND password = '"+password+"'",null);
        return res;
    }

    /**
     * Metodo ancora da costruire
     * @param id
     * @param firstName
     * @param lastName
     * @param username
     * @return
     */
    public boolean updateData(String id,String firstName,String lastName,String username) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_TABLE[0],id);
        contentValues.put(COL_TABLE[1],firstName);
        contentValues.put(COL_TABLE[2],lastName);
        contentValues.put(COL_TABLE[3],username);
        db.update(TABLE_NAME, contentValues, "ID = ?",new String[] { id });
        return true;
    }

    /**
     * Cancello l'utente sapendo il suo id
     * @param id
     * @return
     */
    public Integer deleteData (String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(TABLE_NAME, "ID = ?",new String[] {id});
    }


    /**
     * Metodo per calcolare l'età dell'utente
     * P.S. : Metodo da mettere da qualche altra parte
     * @return
     */
    public int calcAge(){
        int age = 0;

        return age;
    }
}
