package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetandroidtsp.DataBaseProfil.ProfilDAO;
import com.example.projetandroidtsp.Models.Profil;
import com.example.projetandroidtsp.R;

import java.util.prefs.Preferences;

public class MainActivity extends AppCompatActivity {
    Button b_1;
    Button b_2;
    TextView text_1;
    TextView text_2;
    public static Integer nb_profil=0;
    
    String joueur;
    SharedPreferences prefs;
    
    private ProfilDAO profilDAO;
    private Profil p;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    b_1 =(Button)findViewById(R.id.button1_main);
    b_2 =(Button)findViewById(R.id.button2_main);
    text_1 =(TextView) findViewById(R.id.text1_main);
    text_2 =(TextView) findViewById(R.id.text2_main);

    profilDAO=new ProfilDAO(this);
    profilDAO.open();
    prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
    joueur =prefs.getString("joueur", "");

    b_1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (joueur.equals("")) {
                Intent i = new Intent(getApplicationContext(),CreerProfilActivity.class);
                startActivity(i);
            }
            else {
                Intent i = new Intent(getApplicationContext(),ChoixProfilActivity.class);
                startActivity(i);
            }
        }
    });
    b_2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent i = new Intent(getApplicationContext(),MesparaActivity.class);
            startActivity(i);
        }
    });
    }

    @Override
    public void onResume(){
        super.onResume();
        prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        joueur =prefs.getString("joueur", "");
        if (joueur.equals("")) {
            b_2.setClickable(false);
            text_1.setText(R.string.text1_main_inconnu);
        }
        else {
            b_2.setClickable(true);
            text_1.setText(String.format(getString(R.string.text1_main), joueur, 0));
        }
    }
}