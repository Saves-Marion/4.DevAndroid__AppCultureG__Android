package com.example.projetandroidtsp.DataBaseProfil;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public abstract class DAOBase extends SQLiteOpenHelper {
        protected final static int VERSION = 5;
        protected final static String NOM = "database.db";

        protected SQLiteDatabase mDb = null;
        protected DatabaseHandler mHandler = null;

        public DAOBase(Context pContext) {
            super(pContext, NOM, null, VERSION);
            this.mHandler = new DatabaseHandler(pContext, NOM, null, VERSION);
        }

        public SQLiteDatabase open() {
            Log.i("JFL", "Opening database");
            mDb = mHandler.getWritableDatabase();
            return mDb;
        }

        public void close() {
            mDb.close();
        }

        public SQLiteDatabase getDb() {
            return mDb;
        }
}

