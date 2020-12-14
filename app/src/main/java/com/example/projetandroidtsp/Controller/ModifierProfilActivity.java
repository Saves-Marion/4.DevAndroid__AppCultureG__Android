package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.projetandroidtsp.DataBaseProfil.ProfilDAO;
import com.example.projetandroidtsp.Models.Profil;
import com.example.projetandroidtsp.R;

public class ModifierProfilActivity extends AppCompatActivity {
    private EditText edit_1;
    private EditText edit_2;
    private EditText edit_3;
    private Boolean a;
    private Boolean b;
    private Boolean c;
    private Button b_1;

    private ProfilDAO profilDAO;
    private Profil p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modifier_profil);

        edit_1 =(EditText) findViewById(R.id.rep_nom_modifier_profil);
        edit_2 =(EditText) findViewById(R.id.rep_prenom_modifier_profil);
        edit_3 =(EditText) findViewById(R.id.rep_age_modifier_profil);
        b_1 =(Button)findViewById(R.id.button_modifier_profil);
        b_1.setClickable(false);
        a=false;
        b=false;
        c=false;

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
                p=profilDAO.selectionner(0);
                String nom=edit_1.getText().toString();
                String prenom=edit_2.getText().toString();
                Integer age=Integer.getInteger(edit_3.getText().toString());
                p.setNom(nom);
                p.setPrenom(prenom);
                p.setAge(age);
                profilDAO.modifier(p);
                finish();
            }
        });
    }
}