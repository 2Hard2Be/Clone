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

    private static DatabaseHand sInstance;
    private static final int DATABASE_VERSION = 1;

//  nombre de base de datos

    private static final String DATABASE_NAME = "basedatos";

//    nombre de tabla de respuestas y tabla de preguntas

    private static final String TABLE_RESPUESTAS = "tablarespuestas";
    private static final String TABLE_PREGUNTAS = "tablapreguntas";
    private static final String TABLE_EQUATIONS = "tablaecuaciones";

//    Nombre de las columnas de la tabla de respuestas y preguntas

    private static final String KEY_ID = "_id";
    private static final String KEY_RESPUESTAS = "columnarespuestas";
    private static final String KEY_PREGUNTAS = "columnapreguntas";
    private static final String KEY_RESPEQ = "columnarespuestasecuaciones";
    private static final String KEY_PARENABIERTO = "columnaparentesisabierto";
    private static final String KEY_PARENCERRADO = "columnaparentesiscerrado";
    private static final String KEY_SUMA = "columnasumas";
    private static final String KEY_RESTA = "columnarespuestas";
    private static final String KEY_MULTI = "columnamulti";
    private static final String KEY_DIVI = "columnadivi";
    private static final String KEY_INICIO = "columnainicio";
    private static final String KEY_FIN = "columnafinal";



    public static synchronized DatabaseHand getInstance (Context context){


        if (sInstance == null) {
            sInstance = new DatabaseHand(context.getApplicationContext());
        }
        return sInstance;
    }

    /**
     * Constructor should be private to prevent direct instantiation.
     * make call to static method "getInstance()" instead.
     */
    private DatabaseHand(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }



//    creando las tablas

    @Override
    public void onCreate(SQLiteDatabase db){

        String CREATE_TABLE_RESPUESTAS = "CREATE TABLE " + TABLE_RESPUESTAS + "(" + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_RESPUESTAS + " STRING" + ")";
        db.execSQL(CREATE_TABLE_RESPUESTAS);

        String CREATE_TABLE_PREGUNTAS = "CREATE TABLE " + TABLE_PREGUNTAS + "(" + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_PREGUNTAS + " STRING" + ")";

        db.execSQL(CREATE_TABLE_PREGUNTAS);

        String CREATE_TABLE_EQUATIONS = "CREATE TABLE " + TABLE_EQUATIONS + "(" + KEY_ID + " INTEGER PRIMARY KEY," +
                KEY_RESPEQ + " STRING," + KEY_PARENABIERTO + " INTEGER,"+ KEY_PARENCERRADO + " INTEGER,"+ KEY_SUMA + " INTEGER,"
                + KEY_RESTA + " INTEGER,"+ KEY_MULTI + " INTEGER,"+ KEY_DIVI + " INTEGER,"+ KEY_INICIO + " INTEGER,"+ KEY_FIN+ " INTEGER)";

        db.execSQL(CREATE_TABLE_EQUATIONS);
    }

//    Upgrade database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
//Drop tabla vieja si existe

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESPUESTAS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PREGUNTAS);
        db.execSQL("DROP TABLE IF EXISTS" + TABLE_EQUATIONS);

//        Crear la tabla de nuevo

        onCreate(db);

    }


/**
 * Toda la paz(Create, Read, Update, Delete) Operations
 */

    // Agregando nueva respuesta y preguntas

void addRespuesta(RespuestaClass respuesta){
    SQLiteDatabase db = this.getWritableDatabase();

    ContentValues values = new ContentValues();
    values.put(KEY_RESPUESTAS, respuesta.getRespuesta());// Respuesta

//    INSERTANDO FILA

    db.insert(TABLE_RESPUESTAS, null, values);
    db.close(); // cerrando la base de datos

}

    void addPregunta(PreguntaClass pregunta){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PREGUNTAS, pregunta.getPregunta());// Pregunta

//    INSERTANDO FILA

        db.insert(TABLE_PREGUNTAS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addNulls(){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.put(KEY_RESPEQ, "");
        values.putNull(KEY_SUMA);
        values.putNull(KEY_RESTA);
        values.putNull(KEY_DIVI);
        values.putNull(KEY_MULTI);
        values.putNull(KEY_INICIO);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    public void addRespeqUpdated(String value, int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_RESPEQ, value);
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    void addParenAbier(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_PARENABIERTO, pos);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.putNull(KEY_RESPEQ);
        values.putNull(KEY_SUMA);
        values.putNull(KEY_RESTA);
        values.putNull(KEY_DIVI);
        values.putNull(KEY_MULTI);
        values.putNull(KEY_INICIO);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addParenCerrado(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.put(KEY_PARENCERRADO, pos);
        values.putNull(KEY_RESPEQ);
        values.putNull(KEY_SUMA);
        values.putNull(KEY_RESTA);
        values.putNull(KEY_DIVI);
        values.putNull(KEY_MULTI);
        values.putNull(KEY_INICIO);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addSuma(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.putNull(KEY_RESPEQ);
        values.put(KEY_SUMA, pos);
        values.putNull(KEY_RESTA);
        values.putNull(KEY_DIVI);
        values.putNull(KEY_MULTI);
        values.putNull(KEY_INICIO);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addResta(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.putNull(KEY_RESPEQ);
        values.putNull(KEY_SUMA);
        values.put(KEY_RESTA, pos);
        values.putNull(KEY_DIVI);
        values.putNull(KEY_MULTI);
        values.putNull(KEY_INICIO);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addMultiplicacion(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.putNull(KEY_RESPEQ);
        values.putNull(KEY_SUMA);
        values.putNull(KEY_RESTA);
        values.putNull(KEY_DIVI);
        values.put(KEY_MULTI, pos);
        values.putNull(KEY_INICIO);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addDivision(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.putNull(KEY_RESPEQ);
        values.putNull(KEY_SUMA);
        values.putNull(KEY_RESTA);
        values.put(KEY_DIVI, pos);
        values.putNull(KEY_MULTI);
        values.putNull(KEY_INICIO);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addPosInicio(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.putNull(KEY_RESPEQ);
        values.putNull(KEY_SUMA);
        values.putNull(KEY_RESTA);
        values.putNull(KEY_DIVI);
        values.putNull(KEY_MULTI);
        values.put(KEY_INICIO, pos);
        values.putNull(KEY_FIN);

//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addPosFinal(int pos){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.putNull(KEY_PARENABIERTO);// Position parentesis abierto
        values.putNull(KEY_PARENCERRADO);
        values.putNull(KEY_RESPEQ);
        values.putNull(KEY_SUMA);
        values.putNull(KEY_RESTA);
        values.putNull(KEY_DIVI);
        values.putNull(KEY_MULTI);
        values.putNull(KEY_INICIO);
        values.put(KEY_FIN, pos);


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addBlankRespeq(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_RESPEQ, "");// Position de donde finaliza expresion


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addBlankSuma(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_SUMA, "");// Position de donde finaliza expresion


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addBlankResta(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_RESTA, "");// Position de donde finaliza expresion


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addBlankMulti(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_MULTI, "");// Position de donde finaliza expresion


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addBlankDivi(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_DIVI, "");// Position de donde finaliza expresion


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addBlankParenAbierto(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PARENABIERTO, "");// Position de donde finaliza expresion


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

    void addBlankParenCerrado(){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PARENCERRADO,"");// Position de donde finaliza expresion


//    INSERTANDO FILA

        db.insert(TABLE_EQUATIONS, null, values);
        db.close(); // cerrando la base de datos

    }

//    Getting single respuesta y pregunta

    RespuestaClass getRespuesta(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_RESPUESTAS, new String[]{KEY_ID, KEY_RESPUESTAS},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        RespuestaClass respuesta = new RespuestaClass(cursor.getInt(0),
                cursor.getString(1));
        return respuesta;

    }

    PreguntaClass getPregunta(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_PREGUNTAS, new String[]{KEY_ID, KEY_PREGUNTAS},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        PreguntaClass pregunta = new PreguntaClass(cursor.getInt(0),
                cursor.getString(1));
        return pregunta;

    }


    String getRespuestaEq(int id){
        String respuestaeq = new String();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_RESPEQ},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor.moveToFirst()){
            do {

                respuestaeq = cursor.getString(cursor.getColumnIndex(KEY_RESPEQ));


            }while (cursor.moveToNext());
        }

        return respuestaeq;

    }

    Boolean getBooleanRespuestaEq(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_RESPEQ},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;

    }

    Boolean getBooleanSuma(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_SUMA},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;

    }

    Boolean getBooleanResta(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_RESTA},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;

    }

    Boolean getBooleanMulti(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_MULTI},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;

    }

    Boolean getBooleanDivi(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_DIVI},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;

    }

    Boolean getBooleanParenAbierto(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_PARENABIERTO},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;

    }

    Boolean getBooleanParenCerrado(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_PARENCERRADO},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();

        if(cursor.getCount() <= 0){
            cursor.close();
            return false;
        }
        cursor.close();
        return true;

    }

    int getParenAbier(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_PARENABIERTO},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int parenabier = cursor.getInt(1);
        return parenabier;

    }

    int getParenAbierMax(){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT MAX("+ KEY_PARENABIERTO+") FROM "+ TABLE_EQUATIONS, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int parenabier = cursor.getInt(1);
        return parenabier;

    }

    int getParenCerra(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_PARENCERRADO},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int parencerrado = cursor.getInt(1);
        return parencerrado;

    }

    int getSuma(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_SUMA},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int operacion = cursor.getInt(1);
        return operacion;

    }

    int getResta(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_RESTA},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int operacion = cursor.getInt(1);
        return operacion;

    }

    int getMultiplicacion(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_MULTI},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int operacion = cursor.getInt(1);
        return operacion;

    }

    int getDivision(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_DIVI},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int operacion = cursor.getInt(1);
        return operacion;

    }

    int getPosInicio(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_INICIO},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int operacion = cursor.getInt(1);
        return operacion;

    }

    int getPosFinal(int id){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_EQUATIONS, new String[]{KEY_ID, KEY_FIN},
                KEY_ID + "=?", new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor!= null)
            cursor.moveToFirst();
        int operacion = cursor.getInt(1);
        return operacion;

    }

//GETTING ALL RESPUESTAS Y PREGUNTAS

public ArrayList<String> getAllrespuestas(){

ArrayList<String> respuestaClassListtodas = new ArrayList<String>();
//    Query de todo
    String selectQuery = "SELECT * FROM " + TABLE_RESPUESTAS + " ORDER BY "+ KEY_ID + " DESC";
    SQLiteDatabase db = this.getWritableDatabase();
    Cursor cursor = db.rawQuery(selectQuery, null);
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

    public ArrayList<String> getAllpreguntas(){

        ArrayList<String> preguntaClassListtodas = new ArrayList<String>();
//    Query de todo
        String selectQuery = "SELECT * FROM " + TABLE_PREGUNTAS + " ORDER BY "+ KEY_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.rawQuery(selectQuery, null);
//    loop de todas las columnas y agregando a la lista preguntaClassListtodas
        if (cursor.moveToFirst()){
            do {
                PreguntaClass pregunta = new PreguntaClass();
                pregunta.setID(cursor.getInt(0));
                String preguntan = cursor.getString(1);
//    Agregando la pregunta a la lista
                preguntaClassListtodas.add(preguntan);
            }while (cursor.moveToNext());
        }
//    regresa la lista de preguntas
        return preguntaClassListtodas;
    }


//    UPDATERS updating una unica respuesta y pregunta

   public int updateRespuesta(RespuestaClass respuesta) {
       SQLiteDatabase db = this.getWritableDatabase();
       ContentValues values = new ContentValues();
       values.put(KEY_RESPUESTAS, respuesta.getRespuesta());
//       updating una fila
       return db.update(TABLE_RESPUESTAS, values, KEY_ID + " = ?",
               new String[] {String.valueOf(respuesta.getID())});

   }

    public int updatePregunta(PreguntaClass pregunta) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_PREGUNTAS, pregunta.getPregunta());
//       updating una fila
        return db.update(TABLE_PREGUNTAS, values, KEY_ID + " = ?",
                new String[] {String.valueOf(pregunta.getID())});

    }

// DELETERS Deleting single respuesta y pregunta


    public void deleteRespuesta(RespuestaClass respuesta){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_RESPUESTAS, KEY_ID + " = ?",
                new String[]{String.valueOf(respuesta.getID())});
        db.close();

    }

    public void deletePregunta(PreguntaClass pregunta){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_PREGUNTAS, KEY_ID + " = ?",
                new String[] {String.valueOf(pregunta.getID())});
        db.close();

    }

    public void blankParenAbierto(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_PARENABIERTO, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankParenCerrado(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_PARENCERRADO, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankSuma(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_SUMA, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankResta(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_RESTA, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankMultiplicacion(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_MULTI, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankDivision(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_DIVI, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankInicio(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_INICIO, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankFin(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_FIN, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    public void blankRespeq(int pos){

        ContentValues cv = new ContentValues();
        cv.put(KEY_RESPEQ, " ");
        SQLiteDatabase db = this.getWritableDatabase();
        db.update(TABLE_EQUATIONS, cv, KEY_ID + " = ?", new String[]{String.valueOf(pos)});
        db.close();

    }

    //Deleting todas respuesta y pregunta
    public void deleteTodasRespuestas(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from " + TABLE_RESPUESTAS);
        db.close();

    }

    public void deleteTodasPreguntas(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_PREGUNTAS);
        db.close();


    }

    public void deleteTodasEquations(){

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_EQUATIONS);
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

    public int getPreguntasCount(){
        String countQuery = "SELECT * FROM " + TABLE_PREGUNTAS;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        cursor.close();
        return cursor.getCount();

    }

//    BORRADOR DE PREGUNTAS Y RESPUESTAS VIEJAS
    void borraLaspreguntasviejas(){

        SQLiteDatabase db = this.getWritableDatabase();
        String eliminadorpreguntas = "delete from " + TABLE_PREGUNTAS + " where "+KEY_ID+" in (select "+ KEY_ID +
                " from "+ TABLE_PREGUNTAS+" order by " +KEY_ID+ " desc "+ " LIMIT -1 offset 30);";
        db.execSQL(eliminadorpreguntas);

        db.close();}

    void borraLasrespuestasviejas(){

        SQLiteDatabase db = this.getWritableDatabase();
        String eliminadorrespuestas = "delete from " + TABLE_RESPUESTAS + " where "+KEY_ID+" in (select "+ KEY_ID +
                " from "+ TABLE_RESPUESTAS+" order by " +KEY_ID+ " desc "+ " LIMIT -1 offset 30);";
        db.execSQL(eliminadorrespuestas);

        db.close();}

}
