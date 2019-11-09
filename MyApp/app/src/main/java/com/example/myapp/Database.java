package com.example.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Database extends SQLiteOpenHelper {

    String scriptDDL ="CREATE TABLE estudiante(identificacion VARCHAR(50), nombre VARCHAR(50), curso VARCHAR(50), nota1 DOUBLE, nota2 DOUBLE, nota3 DOUBLE)";

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(scriptDDL);

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("Drop table if exists estudiante");

        db.execSQL(scriptDDL);

    }
}
