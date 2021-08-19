package com.example.me_net;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DB extends SQLiteOpenHelper {

    public void DB(Context context, String nombre, CursorFactory factory, int version) {
        nombre = "me-netDB"
         ;
        version = 1;
    }


    //columnas

    public static final String TABLE_NAME = "usuarios";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_Nombre = "Nombre";
    public static final String COLUMN_Correo= "correo";
    public static final String COLUMN_Password = "contraseñæ";

    public DB(@Nullable Context context, @Nullable String name, @Nullable CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //metodo del db


    public void Database(Context context) { }


    @Override
    public void onCreate(SQLiteDatabase db) {
       db.execSQL("create table " + TABLE_NAME + " ( " + COLUMN_ID + " INT PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_Nombre + " VARCHAR, " + COLUMN_Correo + " VARCHAR(250) , "
                + COLUMN_Password + " VARCHAR(25));");
    }

    public void onUpgrade (SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
