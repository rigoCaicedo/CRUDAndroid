package com.example.myapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class Database extends SQLiteOpenHelper {

    String scriptDDL ="CREATE TABLE ventas(venta_golosinas bigint, venta_aseo bigint, venta_escolares bigint";

    public Database(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {

        super(context, name, factory, version);

    }

    @Override

    public void onCreate(SQLiteDatabase db) {

        db.execSQL(scriptDDL);

    }

    @Override

    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("Drop table if exists ventas");

        db.execSQL(scriptDDL);

    }
}
