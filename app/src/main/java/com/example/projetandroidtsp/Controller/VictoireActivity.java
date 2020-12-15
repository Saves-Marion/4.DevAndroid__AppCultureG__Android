package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetandroidtsp.DataBaseProfil.ProfilDAO;
import com.example.projetandroidtsp.Models.Profil;
import com.example.projetandroidtsp.R;

import java.util.Random;

public class VictoireActivity extends AppCompatActivity {
    private Button retour;
    private TextView text;
    private Integer reussi;
    private String categorie;
    private ProfilDAO profilDAO;
    private Profil p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoire);

        text=(TextView)findViewById(R.id.victoire);
        retour=(Button)findViewById(R.id.bouton_victoire);

        profilDAO=new ProfilDAO(this);
        profilDAO.open();
        long id=0;
        p=profilDAO.selectionner(id);

        Intent i = getIntent();
        reussi=i.getIntExtra("reussi", 0);
        text.setText(String.format(getString(R.string.text_victoire), Integer.toString(reussi)));
        categorie=i.getStringExtra("categorie");
        switch (categorie) {
            case "Science": {
                reussi=reussi+p.getNb_reussi_science();
                p.setNb_reussi_science(reussi);
                break;
            }
            case "Animaux":{
                reussi=reussi+p.getNb_reussi_animaux();
                p.setNb_reussi_animaux(reussi);
                break;
            }
            case "Vehicules":{
                reussi=reussi+p.getNb_reussi_vehicules();
                p.setNb_reussi_vehicules(reussi);
                break;
            }
            case "Histoire_geo": {
                reussi=reussi+p.getNb_reussi_histoire_geo();
                p.setNb_reussi_histoire_geo(reussi);
                break;
            }
            case "Sports":{
                reussi=reussi+p.getNb_reussi_sports();
                p.setNb_reussi_sports(reussi);
                break;
            }
            case "Culture Général":{
                reussi=reussi+p.getNb_reussi_culture_g();
                p.setNb_reussi_culture_g(reussi);
                break;
            }
            case "Divertissement": {
                reussi=reussi+p.getNb_reussi_divertissement();
                p.setNb_reussi_divertissement(reussi);
                break;
            }
            default:{
                reussi=reussi+p.getNb_reussi_random();
                p.setNb_reussi_random(reussi);
                break;
            }
        }

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}