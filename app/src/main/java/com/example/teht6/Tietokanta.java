package com.example.teht6;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Tietokanta extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "kanta.db";
    private static final String TABLE_NAME = "tiedot";
    public static final String TIEDOT_COLUMN_PVM = "pvm";
    public static final String TIEDOT_COLUMN_NIMI = "nimi";
    private SQLiteDatabase tietokanta;

    public Tietokanta(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, TABLE_NAME, factory, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE " + TABLE_NAME + "( "
                + TIEDOT_COLUMN_PVM + ", "
                + TIEDOT_COLUMN_NIMI + " TEXT )" );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}
