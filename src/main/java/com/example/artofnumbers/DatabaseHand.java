package com.example.artofnumbers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peto-1 on 4/26/2015.
 */
public class DatabaseHand extends SQLiteOpenHelper{

//Static variables
//version de base de datos

    private static final int DATABASE_VERSION = 1;

//  nombre de base de datos

    private static final String DATABASE_NAME = "basedatos";

//    nombre de base de datos de respuestas

    private static final String TABLE_RESPUESTAS = "tablarespuestas";

//    Nombre de las columnas de la tabla de respuestas

    private static final String KEY_ID = "_id";
    private static final String KEY_RESPUESTAS = "columnarespuestas";

    public DatabaseHand(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

//    creando las tablas

    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE_RESPUESTAS = "CREATE TABLE " + TABLE_RESPUESTAS + "(" + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_RESPUESTAS + " STRING" + ")";
        db.execSQL(CREATE_TABLE_RESPUESTAS);
    }

//    Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//Drop tabla vieja si existe

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESPUESTAS);

//        Crear la tabla de nuevo

        onCreate(db);

    }

/**
 * Toda la paz(Create, Read, Update, Delete) Operations
 */

    // Agregando nueva respuesta

void addRespuesta(RespuestaClass respuesta){
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_RESPUESTAS, respuesta.getRespuesta());// Respuesta

//    INSERTANDO FILA

    db.insert(TABLE_RESPUESTAS, null, values);
    db.close(); // cerrando la base de datos

}

//    Getting single respuesta

    RespuestaClass getRespuesta(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_RESPUESTAS, new String[] { KEY_ID, KEY_RESPUESTAS },
                KEY_ID + "=?", new String[] { String.valueOf(id) }, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        RespuestaClass respuesta = new RespuestaClass(cursor.getInt(0),
                cursor.getString(1));
        return respuesta;

    }
//GETTING ALL RESPUESTAS

public ArrayList<String> getAllrespuestas(){

ArrayList<String> respuestaClassListtodas = new ArrayList<String>();
//    Query de todo
    String selectQuery = "SELECT * FROM " + TABLE_RESPUESTAS;
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery,null);
//    loop de todas las columnas y agregando a la lista respuestaClassListtodas
    if (cursor.moveToFirst()){
do {
    RespuestaClass respuesta = new RespuestaClass();
    respuesta.setID(cursor.getInt(0));
    String respuestan = cursor.getString(1);
//    Agregando la respuesta a la lista
    respuestaClassListtodas.add(respuestan);
}while (cursor.moveToNext());
    }
//    regresa la lista de respuestas
    return respuestaClassListtodas;
}

//    updating una unica respuesta

   public int updateRespuesta(RespuestaClass respuesta) {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(KEY_RESPUESTAS, respuesta.getRespuesta());
//       updating una fila
       return db.update(TABLE_RESPUESTAS, values, KEY_ID + " = ?",
               new String[] {String.valueOf(respuesta.getID())});

   }
//Deleting single respuesta
    public void deleteRespuesta(RespuestaClass respuesta){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RESPUESTAS, KEY_ID + " = ?",
                new String[] {String.valueOf(respuesta.getID())});
        db.close();

    }

//    getting respuestas count

  public int getRespuestasCount(){
      String countQuery = "SELECT * FROM " + TABLE_RESPUESTAS;
      SQLiteDatabase db = this.getReadableDatabase();
      Cursor cursor = db.rawQuery(countQuery, null);
      cursor.close();
      return cursor.getCount();

  }

}
