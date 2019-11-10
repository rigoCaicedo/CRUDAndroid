package com.example.myapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UtilDatabase {
    List<String> list = new ArrayList<String>();

    List<String> listAdapter = new ArrayList<String>();

    public void insertar(SQLiteDatabase db, Estudiante e ){

        ContentValues nuevoRegistro = new ContentValues();

        nuevoRegistro.put("identificacion", e.getIdentificacion());

        nuevoRegistro.put("nombre", e.getNombre());

        nuevoRegistro.put("curso", e.getCurso());

        nuevoRegistro.put("nota1", e.getNota1());

        nuevoRegistro.put("nota2", e.getNota2());

        nuevoRegistro.put("nota3", e.getNota3());

//Insertar un registro

        db.insert("estudiante",null,nuevoRegistro);

    }

    public String consultarbyIdent(SQLiteDatabase db, String ident ){

        List<String> list = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();

//PARA HACER CONSULTA POR IDENTIFICACION

        int i=0;

        Cursor c = db.rawQuery("SELECT * FROM estudiante WHERE identificacion ="+ident,null);

        if (c.moveToFirst()){

            do{

                i++;

                String regIdent =String.valueOf( c.getInt(0));

                String regNombre = c.getString(1);

                String regCurso = c.getString(2);

                String regNota1 = String.valueOf( c.getInt(3));

                String regNota2 = String.valueOf( c.getInt(4));

                String regNota3 = String.valueOf( c.getInt(5));

                list.add(regIdent +" " + regNombre+" "+regCurso+" "+regNota1+" "+regNota2+" "+regNota3);

            }while(c.moveToNext());

            if (c != null && !c.isClosed()) {

                c.close();

            }

        }

        for(String name:list){

            sb.append(name);

            sb.append("\n");

        }

        return sb.toString();

    }
/*
    public void Eliminar(SQLiteDatabase db, String ident ){




//Insertar un registro

        db.delete("estudiante","identificacion = "+ident);

    }
*/



    public  void eliminar(SQLiteDatabase db, String ident ){


        StringBuilder sb = new StringBuilder();

//PARA HACER CONSULTA POR IDENTIFICACION



        db.delete("estudiante", "identificacion="+ident,null);


    }



    public List<String> getList() {

        return list;

    }

    public void setList(List<String> list) {

        this.list = list;

    }

    public List<String> getListAdapter() {

        return listAdapter;

    }

    public void setListAdapter(List<String> listAdapter) {

        this.listAdapter = listAdapter;

    }
}
