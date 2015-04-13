package com.example.artofnumbers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabaseCorruptException;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;

/**
 * Created by Peto-1 on 4/5/2015.
 */
public class DBscroll extends SQLiteOpenHelper {

public static final String TABLE_RESPUESTAS = "respuestas";
public static final String COLUMN_ID = "_id";
public static final String COLUMN_RESPUESTA = "respuesta";

private static final String DATABASE_NAME = "cerebro";
private static final int DATABASE_VERSION = 1;

//    creando base de datos

    private static final String DATABASE_CREATE = "create table" + TABLE_RESPUESTAS +" ("+COLUMN_ID+
            " integer primary key autoincrement, " + COLUMN_RESPUESTA + " text not null);";

public DBscroll (Context context) {

    super(context, DATABASE_NAME, null, DATABASE_VERSION);

}

    @Override

    public void onCreate (SQLiteDatabase database) {

        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(DBscroll.class.getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_RESPUESTAS);
        onCreate(db);
    }
}










