package com.example.myapp;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class UtilDatabase {
    List<String> list = new ArrayList<String>();

    List<String> listAdapter = new ArrayList<String>();

    public void insertar(SQLiteDatabase db, Ventas e ){

        ContentValues nuevoRegistro = new ContentValues();

        nuevoRegistro.put("fecha_venta", e.get_fecha_venta());

        nuevoRegistro.put("venta_golosinas", e.get_venta_golosinas());

        nuevoRegistro.put("venta_aseo", e.get_venta_aseo());

        nuevoRegistro.put("venta_escolares", e.get_venta_escolares());


//Insertar un registro

        db.insert("ventas",null,nuevoRegistro);

    }

    public String consultarbyMes(SQLiteDatabase db, String agno, String mes ){
        String mes = agno+'-'+mes;
        String mes_ini = agno+'-'+mes+'-01';
        String mes_fin = agno+'-'+mes+'-31';
        List<String> list = new ArrayList<String>();

        StringBuilder sb = new StringBuilder();

//PARA HACER CONSULTA POR IDENTIFICACION

        int i=0;

        Cursor c = db.rawQuery("SELECT SUM(venta_golosinas) as golosinas, sum(venta_aseo) as aseo, sum(venta_escolares) as escolares FROM ventas WHERE identificacion between  '"+mes_ini+"' and '"+mes_fin+"'",null);

        if (c.moveToFirst()){

            do{

                i++;

                String reg_mes = mes;

                String reg_golosinas = String.valueOf( c.getInt(1));//c.getString(1);

                String reg_aseo = String.valueOf( c.getInt(2));//c.getString(2);

                String reg_escolares = String.valueOf( c.getInt(3));

                list.add(reg_mes +" " + reg_golosinas+" "+reg_aseo+" "+reg_escolares);

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



    public  void eliminar(SQLiteDatabase db, String fecha_venta ){


        StringBuilder sb = new StringBuilder();

//PARA HACER CONSULTA POR IDENTIFICACION  Y ELIMINAR



        db.delete("ventas", "fecha_venta='"+fecha_venta+"'",null);


    }


    public void modificar(SQLiteDatabase db, Ventas e ,String fecha_venta ) {

        ContentValues updateVenta = new ContentValues();

        //  nuevoRegistro.put("identificacion", e.getIdentificacion());

        updateVenta.put("venta_golosinas", e.get_venta_golosinas());

        updateVenta.put("venta_aseo", e.get_venta_aseo());

        updateVenta.put("venta_escolares", e.get_venta_escolares());


//Insertar un registro

        String[] args= new String[]{fecha_venta};

        db.update("ventas",updateVenta, "fecha_venta=?", args);

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
