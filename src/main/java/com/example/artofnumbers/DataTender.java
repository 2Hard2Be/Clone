package com.example.artofnumbers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Peto-1 on 4/12/2015.
 */
public class DataTender {

//    Data base fields

    private SQLiteDatabase database;
    private DBscroll dbhelper;
    private String[] allColumns = {DBscroll.COLUMN_ID, DBscroll.COLUMN_RESPUESTA};

    public DataTender(Context context){

dbhelper = new DBscroll(context);
    }

    public void open() throws SQLException{

        database = dbhelper.getWritableDatabase();
    }

    public void close() {

        dbhelper.close();
    }

    public Respuestas createRespuesta(String respuesta) {

        ContentValues values = new ContentValues();
        values.put(DBscroll.COLUMN_RESPUESTA, respuesta);
        long insertId = database.insert(DBscroll.TABLE_RESPUESTAS, null, values);
        Cursor cursor = database.query(DBscroll.TABLE_RESPUESTAS, allColumns, DBscroll.COLUMN_ID+
        " = "+insertId,null,null,null,null);
        cursor.moveToFirst();
        Respuestas nuevaRespuesta = cursorToRespuesta(cursor);
        cursor.close();
        return nuevaRespuesta;
    }

    public void deleteRespuesta(Respuestas respuesta){

        long id = respuesta.getId();
        database.delete(DBscroll.TABLE_RESPUESTAS, DBscroll.COLUMN_ID + " = " + id, null);

    }

    public List<Respuestas> getAllRespuestas() {

        List<Respuestas> respuestas  = new ArrayList<Respuestas>();
        Cursor cursor = database.query(DBscroll.TABLE_RESPUESTAS, allColumns, null, null, null,
                null, null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){

            Respuestas respuesta = cursorToRespuesta(cursor);
            respuestas.add(respuesta);
            cursor.moveToNext();
        }

        cursor.close();
        return respuestas;
    }
private Respuestas cursorToRespuesta (Cursor cursor){

    Respuestas respuesta = new Respuestas();
    respuesta.setId(cursor.getLong(0));
    respuesta.setRespuesta(cursor.getString(1));
    return respuesta;
}

}
