package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.projetandroidtsp.Models.Profil;
import com.example.projetandroidtsp.DataBaseProfil.ProfilDAO;
import com.example.projetandroidtsp.R;

public class CreerProfilActivity extends AppCompatActivity {

    private EditText edit_1;
    private EditText edit_2;
    private EditText edit_3;
    private Boolean a;
    private Boolean b;
    private Boolean c;
    private Button b_1;

    private ProfilDAO profilDAO;
    private Profil p;
    String nom="";
    String prenom="";
    Integer age=0;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creer_profil);

        edit_1 =(EditText) findViewById(R.id.rep_nom_creer_profil);
        edit_2 =(EditText) findViewById(R.id.rep_prenom_creer_profil);
        edit_3 =(EditText) findViewById(R.id.rep_age_creer_profil);
        b_1 =(Button)findViewById(R.id.button_creer_profil);
        b_1.setClickable(false);
        a=false;
        b=false;
        c=false;

        p= new Profil(0,"","",0,0,0,0,0,0,0,0,0,0);
        profilDAO=new ProfilDAO(this);
        profilDAO.open();

        edit_1.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    a=true;
                } else {
                    a=false;
                }
                if(a & b & c) b_1.setClickable(true);
            }
        });
        edit_2.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    b=true;
                } else {
                    b=false;
                }
                if(a & b & c) b_1.setClickable(true);
            }
        });
        edit_3.addTextChangedListener(new TextWatcher() {

            @Override
            public void afterTextChanged(Editable s) {}

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.length() != 0) {
                    c=true;
                } else {
                    c=false;
                }
                if(a & b & c) b_1.setClickable(true);
            }
        });

        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom=edit_1.getText().toString();
                prenom=edit_2.getText().toString();
                age=Integer.getInteger(edit_3.getText().toString());
                if(age!=null && age>500){
                    Toast.makeText(getApplicationContext(),"Vous êtes trop vieux pour jouer attention",Toast.LENGTH_LONG).show();
                }
                p.setId(MainActivity.nb_profil);
                p.setNom(nom);
                p.setPrenom(prenom);
                p.setAge(age);
                profilDAO.ajouter(p);
                prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
                prefs.edit().putString("joueur", prenom).commit();
                MainActivity.nb_profil=MainActivity.nb_profil+1;
                prefs.edit().putInt("nb_profil",MainActivity.nb_profil).commit();
                MainActivity.n_joueur=MainActivity.nb_profil;
                prefs.edit().putInt("n_joueur",MainActivity.n_joueur).commit();
                finish();
            }
        });
    }
}