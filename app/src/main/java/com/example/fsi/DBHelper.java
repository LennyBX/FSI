package com.example.fsi;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DBHelper extends SQLiteOpenHelper {

    private SQLiteDatabase database;
    private Context context;
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "fsi_sqlite.db";
    android.database.sqlite.SQLiteDatabase db = null;




    //table etudiant connectÃ©
    public static final String TABLE_UTI = "Etudiant",
            COLUMN_ID = "ID_ETU",
            COLUMN_NOM_ETU = "NOM_ETU",
            COLUMN_PRE_ETU = "PRE_ETU",
            COLUMN_CLA_ETU = "CLA_ETU",
            COLUMN_SPE_ETU = "SPE_ETU",
            COLUMN_LOG_ETU = "LOG_ETU",
            COLUMN_MDP_ETU = "MDP_ETU",
            COLUMN_CP_ETU = "CP_ETU",
            COLUMN_RUE_ETU = "RUE_ETU",
            COLUMN_VIL_ETU = "VIL_ETU",
            COLUMN_MAI_ETU = "MAI_ETU",
            COLUMN_TEL_ETU = "TEL_ETU";

    private static final String CREATE_TABLE_UTILISATEUR = "CREATE  TABLE " + TABLE_UTI +
            " (" + COLUMN_ID + " INTEGER PRIMARY KEY, " +
            COLUMN_NOM_ETU + " TEXT, " +
            COLUMN_PRE_ETU + " TEXT, " +
            COLUMN_CLA_ETU + " TEXT, " +
            COLUMN_SPE_ETU + " TEXT, " +
            COLUMN_LOG_ETU + " TEXT, " +
            COLUMN_MDP_ETU + " TEXT, " +
            COLUMN_CP_ETU + " TEXT, " +
            COLUMN_RUE_ETU + " TEXT," +
            COLUMN_VIL_ETU + " TEXT," +
            COLUMN_MAI_ETU + " TEXT," +
            COLUMN_TEL_ETU + " TEXT)";

    //table note1
    public static final String TABLE_Bilan_1 = "Bilan_1",
            COLUMN_ID_NOT_1 = "ID_NOT_1",
            COLUMN_DAT_BIL = "DAT_BIL_1",
            COLUMN_REMARQUE = "REM_NOT_BIL_1",
            COLUMN_NOT_ORAL_BIL = "NOT_ORA_NOT",
            COLUMN_NOT_ENT_BIL = "NOT_ENT_NOT",
            COLUMN_NOT_DOS_BIL = "NOT_DOS_NOT";





    private static final String CREATE_TABLE_Bilan_1 = "CREATE TABLE " + TABLE_Bilan_1 +
            " (" + COLUMN_ID_NOT_1 + " INTEGER PRIMARY KEY, " +
            COLUMN_DAT_BIL + " DATE, " +
            COLUMN_REMARQUE + " TEXT, " +
            COLUMN_NOT_ORAL_BIL + " FLOAT, " +
            COLUMN_NOT_ENT_BIL + " FLOAT, " +
            COLUMN_NOT_DOS_BIL + " FLOAT); ";


    //table note2
    public static final String TABLE_Bilan_2 = "Bilan_2",
            COLUMN_ID_NOT_2 = "ID_NOT_2",
            COLUMN_DAT_NOT_BIL_2 = "DAT_NOT_BIL_2",
            COLUMN_REM_NOT_BIL_2 = "REM_NOT_BIL_2",
            COLUMN_NOT_ORA_BIL_2L = "NOT_ORA_BIL_2",
            COLUMN_NOT_ENT_NOT_BIL_2 = "NOT_ENT_NOT_BIL_2",
            COLUMN_NOT_DOS_BIL_2 = "NOT_DOS_BIL_2";

    private static final String CREATE_TABLE_Bilan_2 = "CREATE TABLE " + TABLE_Bilan_2 +
            " (" + COLUMN_ID_NOT_2 + " INTEGER PRIMARY KEY, " +
            COLUMN_DAT_NOT_BIL_2 + " TEXT, " +
            COLUMN_REM_NOT_BIL_2 + " TEXT, " +
            COLUMN_NOT_ORA_BIL_2L + " TEXT, " +
            COLUMN_NOT_ENT_NOT_BIL_2 + " TEXT," +
            COLUMN_NOT_DOS_BIL_2 + " TEXT); ";


    public DBHelper(@Nullable Context context, SQLiteDatabase database, Context context1) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.database = database;
        this.context = context1;
    }


    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @RequiresApi(api = Build.VERSION_CODES.P)
    public DBHelper(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(android.database.sqlite.SQLiteDatabase db) {

        db.execSQL("DROP TABLE IF EXISTS Etudiant");
        db.execSQL("DROP TABLE IF EXISTS bilan_1");
        db.execSQL("DROP TABLE IF EXISTS bilan_2");

    }

    public boolean createTable(String nomTable) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DROP TABLE IF EXISTS " + nomTable);
        MyDB.execSQL(CREATE_TABLE_UTILISATEUR);
        return true;
    }

    public boolean createTable2(String nomTable) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DROP TABLE IF EXISTS " + nomTable);
        MyDB.execSQL(CREATE_TABLE_Bilan_1);
        return true;
    }

    public boolean createTable3(String nomTable) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        MyDB.execSQL("DROP TABLE IF EXISTS " + nomTable);
        MyDB.execSQL(CREATE_TABLE_Bilan_2);
        return true;
    }

    public boolean insertBilan_1(String dat_bil, String not_ent_bil, String not_oral_bil, String remarque, String not_dos_bil) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DAT_BIL_1", dat_bil);
        contentValues.put("REM_NOT_BIL_1", remarque);
        contentValues.put("NOT_ORA_NOT", not_oral_bil);
        contentValues.put("NOT_ENT_NOT", not_ent_bil);
        contentValues.put("NOT_DOS_NOT", not_dos_bil);
        long result = MyDB.insert("Bilan_1", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertBilan_2(String dat_bil2, String not_ent_bil2, String not_oral_bil2, String remarque2, String not_dos_bil2) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("DAT_NOT_BIL_2", dat_bil2);
        contentValues.put("REM_NOT_BIL_2", remarque2);
        contentValues.put("NOT_ORA_BIL_2", not_oral_bil2);
        contentValues.put("NOT_ENT_NOT_BIL_2", not_ent_bil2);
        contentValues.put("NOT_DOS_BIL_2", not_dos_bil2);
        long result = MyDB.insert("Bilan_2", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean insertData_etu(String nom_etu, String pre_etu, String tel_etu, String mail_etu, String log_etu, String mdp_etu,
                              String spe_etu, String classe_etu,  String cp_etu, String rue_etu, String ville_etu) {
        SQLiteDatabase MyDB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("NOM_ETU", nom_etu);
        contentValues.put("PRE_ETU", pre_etu);
        contentValues.put("CLA_ETU", classe_etu);
        contentValues.put("SPE_ETU", spe_etu);
        contentValues.put("LOG_ETU", log_etu);
        contentValues.put("MDP_ETU", mdp_etu);
        contentValues.put("CP_ETU", cp_etu);
        contentValues.put("RUE_ETU", rue_etu);
        contentValues.put("VIL_ETU", ville_etu);
        contentValues.put("MAI_ETU", mail_etu);
        contentValues.put("TEL_ETU", tel_etu);
        long result = MyDB.insert("Etudiant", null, contentValues);
        if (result == -1)
            return false;
        else
            return true;
    }




    @Override
    public void onUpgrade(android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_UTI);
        onCreate(db);
    }

}
