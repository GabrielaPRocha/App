package com.example.mybancodedados;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MeuBancoDados extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION =1;
    public static final String DATABASE_NAME ="empresa.db";

    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE entry("+
                    "id INTEGER PRIMARY KEY," +
                    "titulo TEXT,"+
                    "subtitulo TEXT)";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS entry";

    public MeuBancoDados(@Nullable Context context) {
        super(context, DATABASE_NAME,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //criação da tablea
        db.execSQL(SQL_CREATE_ENTRIES);
        //comando para criar a tabla no banco
        onCreate(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onUpgrade(db,1,2);
    }
}
