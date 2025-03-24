package com.example.segundoparcial

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    var txtCodigo:EditText?=null
    var txtNombre:EditText?=null
    var txtEdad:EditText?=null
    var txtTelefono:EditText?=null
    var txtCiudad:EditText?=null
    lateinit var con: SQLite
    lateinit var baseDatos: SQLiteDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtCodigo=findViewById(R.id.txtCodigo)
        txtNombre=findViewById(R.id.txtNombre)
        txtEdad=findViewById(R.id.txtEdad)
        txtTelefono=findViewById(R.id.txtTelefono)
        txtCiudad=findViewById(R.id.txtCiudad)
        con=SQLite(this,"Segundo_parcial2",null,1)
        baseDatos=con.writableDatabase
    }

    fun insertar(view:View){

        //Nixon Gutierrez 2019-1306 Dev

        var codigo=txtCodigo?.text.toString()
        var nombre=txtNombre?.text.toString()
        var edad=txtEdad?.text.toString()
        var telefono=txtTelefono?.text.toString()
        var ciudad=txtCiudad?.text.toString()

        if(codigo.isEmpty()==false && nombre.isEmpty()==false && edad.isEmpty()==false && telefono.isEmpty()==false && ciudad.isEmpty()==false){
            var registro=ContentValues()
            registro.put("codigo",codigo)
            registro.put("nombre",nombre)
            registro.put("edad",edad)
            registro.put("telefono",telefono)
            registro.put("ciudad",ciudad)
            baseDatos.insert("personas",null,registro)

            txtCodigo?.setText("")
            txtNombre?.setText("")
            txtEdad?.setText("")
            txtTelefono?.setText("")
            txtCiudad?.setText("")

            Toast.makeText(this,"Se insertado exitosamente",Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this,"Los campos deben tener texto",Toast.LENGTH_LONG).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        baseDatos.close()
        con.close()
    }
}