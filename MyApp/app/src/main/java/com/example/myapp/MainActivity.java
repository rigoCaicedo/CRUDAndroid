package com.example.myapp;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private TextView resul;

    private EditText identificacion, nombre, curso, nota1, nota2, nota3;

    SQLiteDatabase db;

    UtilDatabase ubd=new UtilDatabase();

    private List<String> list = new ArrayList<String>();

    private List<String> listAdapter = new ArrayList<String>();

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        identificacion = (EditText)findViewById(R.id.txtIdent);

        nombre = (EditText)findViewById(R.id.txtNombre);

        curso = (EditText)findViewById(R.id.txtCurso);

        nota1 = (EditText)findViewById(R.id.txtNota1);

        nota2 = (EditText)findViewById(R.id.txtNota2);

        nota3 = (EditText)findViewById(R.id.txtNota3);

        resul = (TextView)findViewById(R.id.resultado);

    }

    public SQLiteDatabase abrirConexion() {

        Database us = new Database(this, "DBEstudiantes", null, 1);

        return db = us.getWritableDatabase();

    }

    public void metodo(View v){

        String eident = identificacion.getText().toString();

        String enombre = nombre.getText().toString();

        String ecurso = curso.getText().toString();

        String enota1 = nota1.getText().toString();

        String enota2 = nota2.getText().toString();

        String enota3 = nota3.getText().toString();

        if (eident.equals("")||enombre.equals("")||ecurso.equals("")||enota1.equals("")||enota2.equals("")||enota3.equals("")){

            Toast.makeText(this, "No pueden dejar campos vacios",

                    Toast.LENGTH_LONG).show();

        }else{

            Estudiante ingEstudiante = new Estudiante();

            ingEstudiante.setIdentificacion(identificacion.getText().toString());

            ingEstudiante.setNombre(nombre.getText().toString());

            ingEstudiante.setCurso(curso.getText().toString());

            ingEstudiante.setNota1(Float.parseFloat(nota1.getText().toString()));

            ingEstudiante.setNota2(Float.parseFloat(nota2.getText().toString()));

            ingEstudiante.setNota3(Float.parseFloat(nota3.getText().toString()));

            switch (v.getId()){

                case R.id.btnGuardar:

                    db = abrirConexion();

                    ubd.insertar(db,ingEstudiante);

                    Toast.makeText(this,"Estudiante Almacendado", Toast.LENGTH_SHORT).show();

                    clearText();

                    db.close();

                    break;

            }

        }

    }



    public void metodoCons(View v1){

        String eident = identificacion.getText().toString();

        if (eident.equals("")){

            Toast.makeText(this, "No puede dejar el campo identificacion vacio",

                    Toast.LENGTH_LONG).show();

        }else{

            Estudiante ingEstudiante2 = new Estudiante();

            ingEstudiante2.setIdentificacion(identificacion.getText().toString());

            switch (v1.getId()) {

                case R.id.btnConsultar:

                    db = abrirConexion();

                    String respuesta=ubd.consultarbyIdent(db, ingEstudiante2.getIdentificacion());

                    db.close();

                    resul.setText(respuesta);

                    break;
                case R.id.btnlimpiarCam:
                    clearText();
                 break;
            }

        }

    }



    public void modificar(View v){

        String eident = identificacion.getText().toString();

        String enombre = nombre.getText().toString();

        String ecurso = curso.getText().toString();

        String enota1 = nota1.getText().toString();

        String enota2 = nota2.getText().toString();

        String enota3 = nota3.getText().toString();

        if (eident.equals("")||enombre.equals("")||ecurso.equals("")||enota1.equals("")||enota2.equals("")||enota3.equals("")){

            Toast.makeText(this, "No pueden dejar campos vacios",

                    Toast.LENGTH_LONG).show();

        }else{

            Estudiante ingEstudiante = new Estudiante();

            ingEstudiante.setIdentificacion(identificacion.getText().toString());

            ingEstudiante.setNombre(nombre.getText().toString());

            ingEstudiante.setCurso(curso.getText().toString());

            ingEstudiante.setNota1(Float.parseFloat(nota1.getText().toString()));

            ingEstudiante.setNota2(Float.parseFloat(nota2.getText().toString()));

            ingEstudiante.setNota3(Float.parseFloat(nota3.getText().toString()));

            switch (v.getId()){

                case R.id.btnModificar:

                    db = abrirConexion();

                    ubd.modificar(db,ingEstudiante,ingEstudiante.getIdentificacion());

                    Toast.makeText(this,"Estudiante Editado ", Toast.LENGTH_SHORT).show();

                    clearText();

                    db.close();

                    break;

            }

        }

    }







    public  void eliminardatos(View v1){


        String eident = identificacion.getText().toString();

        if (eident.equals("")){

            Toast.makeText(this, "No puede dejar el campo identificacion vacio",

                    Toast.LENGTH_LONG).show();

        }else{

            Estudiante ingEstudiante2 = new Estudiante();

            ingEstudiante2.setIdentificacion(identificacion.getText().toString());

            switch (v1.getId()) {

                case R.id.btnEliminar:

                    db = abrirConexion();

                    ubd.eliminar(db, "'"+ingEstudiante2.getIdentificacion()+"'");


                    db.close();

              //      resul.setText(respuesta);

               clearText();

                    break;

            }

        }




    }















    private void clearText() {

        identificacion.setText("");

        nombre.setText("");

        curso.setText("");

        nota1.setText("");

        nota2.setText("");

        nota3.setText("");

        //resultado.setText("");
        resul.setText("");

    }
}
