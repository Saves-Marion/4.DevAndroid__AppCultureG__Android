package com.example.projetandroidtsp.DataBaseProfil;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

import com.example.projetandroidtsp.Models.Profil;

public class ProfilDAO extends DAOBase{
    public static final String TABLE_NAME="profil";
    public static final String KEY="id";
    public static final String NOM="nom";
    public static final String PRENOM="prenom";
    public static final String AGE="age";
    public static final String PROFIL_NB_JOUE_TOTAL="nb_joue_total";
    public static final String PROFIL_NB_REUSSI_SCIENCE="nb_reussi_science";
    public static final String PROFIL_NB_REUSSI_ANIMAUX="nb_reussi_animaux";
    public static final String PROFIL_NB_REUSSI_VEHICULES="nb_reussi_vehicules";
    public static final String PROFIL_NB_REUSSI_HISTOIRE_GEO="nb_reussi_histoire_geo";
    public static final String PROFIL_NB_REUSSI_SPORTS="nb_reussi_sports";
    public static final String PROFIL_NB_REUSSI_RANDOM="nb_reussi_random";
    public static final String PROFIL_NB_REUSSI_CULTURE_G="nb_reussi_culture_g";
    public static final String PROFIL_NB_REUSSI_DIVERTISSEMENT="nb_reussi_divertissement";

    public static final String TABLE_CREATE="CREATE TABLE "+TABLE_NAME+" ( "+
            KEY+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            NOM+" TEXT, "+
            PRENOM+" TEXT, "+
            AGE+" REAL, "+
            PROFIL_NB_JOUE_TOTAL+" REAL, "+
            PROFIL_NB_REUSSI_SCIENCE+" REAL, "+
            PROFIL_NB_REUSSI_ANIMAUX+" REAL, " +
            PROFIL_NB_REUSSI_VEHICULES+" REAL, " +
            PROFIL_NB_REUSSI_HISTOIRE_GEO+" REAL, "+
            PROFIL_NB_REUSSI_SPORTS+" REAL, "+
            PROFIL_NB_REUSSI_RANDOM+" REAL, "+
            PROFIL_NB_REUSSI_CULTURE_G+" REAL, "+
            PROFIL_NB_REUSSI_DIVERTISSEMENT+" REAL ); ";
    public static final String TABLE_DROP="DROP TABLE IF EXISTS "+TABLE_NAME+" ; ";

    public ProfilDAO(Context pContext) {
        super(pContext);
    }

    /**
     * @param p le profil à ajouter à la base
     */
    public void ajouter(Profil p) {
        // CODE
        ContentValues value = new ContentValues();
        value.put(ProfilDAO.NOM, p.getNom());
        value.put(ProfilDAO.PRENOM, p.getPrenom());
        value.put(ProfilDAO.AGE, p.getAge());
        value.put(ProfilDAO.PROFIL_NB_JOUE_TOTAL, p.getNb_joue_total());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_SCIENCE, p.getNb_reussi_science());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_ANIMAUX, p.getNb_reussi_animaux());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_VEHICULES, p.getNb_reussi_vehicules());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_HISTOIRE_GEO, p.getNb_reussi_histoire_geo());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_SPORTS, p.getNb_reussi_sports());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_RANDOM, p.getNb_reussi_random());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_CULTURE_G, p.getNb_reussi_culture_g());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_DIVERTISSEMENT, p.getNb_reussi_divertissement());
        mDb.insert(ProfilDAO.TABLE_NAME, null, value);
    }

    /**
     * @param id l'identifiant du profil à supprimer
     */
    public void supprimer(long id) {
        // CODE
        mDb.delete(TABLE_NAME, KEY + " = ?", new String[] {String.valueOf(id)});
    }

    /**
     * @param p le profil modifié
     */
    public void modifier(Profil p) {
        // CODE
        ContentValues value = new ContentValues();
        value.put(ProfilDAO.NOM, p.getNom());
        value.put(ProfilDAO.PRENOM, p.getPrenom());
        value.put(ProfilDAO.AGE, p.getAge());
        value.put(ProfilDAO.PROFIL_NB_JOUE_TOTAL, p.getNb_joue_total());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_SCIENCE, p.getNb_reussi_science());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_ANIMAUX, p.getNb_reussi_animaux());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_VEHICULES, p.getNb_reussi_vehicules());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_HISTOIRE_GEO, p.getNb_reussi_histoire_geo());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_SPORTS, p.getNb_reussi_sports());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_RANDOM, p.getNb_reussi_random());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_CULTURE_G, p.getNb_reussi_culture_g());
        value.put(ProfilDAO.PROFIL_NB_REUSSI_DIVERTISSEMENT, p.getNb_reussi_divertissement());
        mDb.update(TABLE_NAME, value, KEY  + " = ?", new String[] {String.valueOf(p.getId())});

    }

    /**
     * @param id l'identifiant du profil à récupérer
     */
    public Profil selectionner(long id) {
        // CODE
        Profil p = new Profil(0,"","",0,0,0,0,0,0,0,0,0,0);
        Cursor c = mDb.rawQuery("select " + "*" + " from " + TABLE_NAME+" where id =?", new String[]{"id"});
        if (c.getCount()>0) {
            c.moveToFirst();
            p.setId(id);
            p.setNom(c.getString(1));
            p.setPrenom(c.getString(2));
            p.setAge(c.getInt(3));
            p.setNb_joue_total(c.getInt(4));
            p.setNb_reussi_science(c.getInt(5));
            p.setNb_reussi_animaux(c.getInt(6));
            p.setNb_reussi_vehicules(c.getInt(7));
            p.setNb_reussi_histoire_geo(c.getInt(8));
            p.setNb_reussi_sports(c.getInt(9));
            p.setNb_reussi_random(c.getInt(10));
            p.setNb_reussi_culture_g(c.getInt(11));
            p.setNb_reussi_divertissement(c.getInt(12));
            c.close();
        }
        return p;
    }
}
