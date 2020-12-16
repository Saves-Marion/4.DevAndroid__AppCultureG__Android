package com.example.projetandroidtsp.DataBaseProfil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHandler extends SQLiteOpenHelper {
    public static final String PROFIL_TABLE_NAME = "Profil";
    public static final String PROFIL_KEY="id";
    public static final String PROFIL_NOM="nom";
    public static final String PROFIL_PRENOM="prenom";
    public static final String PROFIL_AGE="age";
    public static final String PROFIL_NB_JOUE_TOTAL="nb_joue_total";
    public static final String PROFIL_NB_REUSSI_SCIENCE="nb_reussi_science";
    public static final String PROFIL_NB_REUSSI_ANIMAUX="nb_reussi_animaux";
    public static final String PROFIL_NB_REUSSI_VEHICULES="nb_reussi_vehicules";
    public static final String PROFIL_NB_REUSSI_HISTOIRE_GEO="nb_reussi_histoire_geo";
    public static final String PROFIL_NB_REUSSI_SPORTS="nb_reussi_sports";
    public static final String PROFIL_NB_REUSSI_RANDOM="nb_reussi_random";
    public static final String PROFIL_NB_REUSSI_CULTURE_G="nb_reussi_culture_g";
    public static final String PROFIL_NB_REUSSI_DIVERTISSEMENT="nb_reussi_divertissement";
    public static final int DATABASE_VERSION = 4;

    public static final String PROFIL_TABLE_CREATE =
            "CREATE TABLE " + PROFIL_TABLE_NAME + " (" +
                    PROFIL_KEY + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                    PROFIL_NOM + " TEXT," +
                    PROFIL_PRENOM + " TEXT," +
                    PROFIL_AGE + " REAL," +
                    PROFIL_NB_JOUE_TOTAL + " REAL," +
                    PROFIL_NB_REUSSI_SCIENCE + " REAL," +
                    PROFIL_NB_REUSSI_ANIMAUX + " REAL," +
                    PROFIL_NB_REUSSI_VEHICULES + " REAL," +
                    PROFIL_NB_REUSSI_HISTOIRE_GEO + " REAL," +
                    PROFIL_NB_REUSSI_SPORTS + " REAL," +
                    PROFIL_NB_REUSSI_RANDOM + " REAL," +
                    PROFIL_NB_REUSSI_CULTURE_G + " REAL," +
                    PROFIL_NB_REUSSI_DIVERTISSEMENT + " REAL);";

    public DatabaseHandler(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(PROFIL_TABLE_CREATE);
    }

    public static final String PROFIL_TABLE_DROP = "DROP TABLE IF EXISTS " + PROFIL_TABLE_NAME + ";";

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(PROFIL_TABLE_DROP);
        onCreate(db);
    }

}
