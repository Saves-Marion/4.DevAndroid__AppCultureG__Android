package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetandroidtsp.AsyncJSONData;
import com.example.projetandroidtsp.DataBaseProfil.ProfilDAO;
import com.example.projetandroidtsp.Models.Profil;
import com.example.projetandroidtsp.R;

import java.util.Random;

import static com.example.projetandroidtsp.R.color.green;

public class QSimpleQuizzActivity extends AppCompatActivity {

    Button b_1;
    Button b_2;
    Button b_3;
    Button b_4;
    TextView text_1;
    int nb;
    Integer reussi;
    Integer incr;
    Integer incrq;
    String[] questions;
    String[] reponses;
    String categorie;

    private ProfilDAO profilDAO;
    private Profil p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_simple_quizz);

        text_1 =(TextView) findViewById(R.id.q_simple);
        b_1 =(Button)findViewById(R.id.rep1_simple);
        b_2 =(Button)findViewById(R.id.rep2_simple);
        b_3 =(Button)findViewById(R.id.rep3_simple);
        b_4 =(Button)findViewById(R.id.rep4_simple);

        profilDAO=new ProfilDAO(this);
        profilDAO.open();

        Intent i = getIntent();
        incr = i.getIntExtra("incr", 0);
        incrq = i.getIntExtra("incrq", 0);
        questions = i.getStringArrayExtra("questions");
        reponses = i.getStringArrayExtra("reponses");
        reussi=i.getIntExtra("reussi", -1);
        categorie=i.getStringExtra("categorie");

        Random random = new Random();
        nb = 1+random.nextInt(4);

        if(nb==1){
            text_1.setText(questions[incrq]);
            b_1.setText(reponses[incr]);
            b_2.setText(reponses[incr+3]);
            b_3.setText(reponses[incr+1]);
            b_4.setText(reponses[incr+2]);
        }

        if(nb==2){
            text_1.setText(questions[incrq]);
            b_1.setText(reponses[incr+3]);
            b_2.setText(reponses[incr]);
            b_3.setText(reponses[incr+1]);
            b_4.setText(reponses[incr+2]);
        }

        if(nb==3){
            text_1.setText(questions[incrq]);
            b_1.setText(reponses[incr+3]);
            b_2.setText(reponses[incr+1]);
            b_3.setText(reponses[incr]);
            b_4.setText(reponses[incr+2]);
        }

        if(nb==4){
            text_1.setText(questions[incrq]);
            b_1.setText(reponses[incr+3]);
            b_2.setText(reponses[incr+1]);
            b_3.setText(reponses[incr+2]);
            b_4.setText(reponses[incr]);
        }

        Random random1 = new Random();
        final Integer nb1;
        nb1 = 1+random1.nextInt(15);

        Toast.makeText(getApplicationContext(),reussi.toString(),Toast.LENGTH_SHORT).show();

        b_1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
              if (nb==1){
                  b_1.setBackgroundColor(green);
                  reussi=reussi+1;
              }
              else  {
                  b_1.setBackgroundColor(R.color.red);
              }
              incrq++;
              incr=incr+4;
              if (incrq==9){
                  Intent i = new Intent(getApplicationContext(),VictoireActivity.class);
                  i.putExtra("reussi",reussi);
                  startActivity(i);
              }
                if (categorie=="Random" && nb1==1){
                    Intent i = new Intent(getApplicationContext(),QBoussoleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (categorie=="Random" && nb1==5){
                    Intent i = new Intent(getApplicationContext(),QShakeQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (categorie=="Random" && nb1==10){
                    Intent i = new Intent(getApplicationContext(),QDragDropQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(getApplicationContext(),QSimpleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",0);
                    startActivity(i);
                }
            }
        });
            b_3.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("ResourceAsColor")
                @Override
                public void onClick(View v) {
                    if (nb==3){
                        b_3.setBackgroundColor(green);
                        reussi++;
                    }
                    else  {
                        b_3.setBackgroundColor(R.color.red);
                    }
                    incrq++;
                    incr=incr+4;
                    if (incrq==9){
                        Intent i = new Intent(getApplicationContext(),VictoireActivity.class);
                        i.putExtra("reussi",reussi);
                        startActivity(i);
                    }

                    if (categorie=="Random" && nb1==1){
                        Intent i = new Intent(getApplicationContext(),QBoussoleQuizzActivity.class);
                        i.putExtra("incr",incr);
                        i.putExtra("incrq",incrq);
                        i.putExtra("questions",questions);
                        i.putExtra("reponses",reponses);
                        i.putExtra("categorie",categorie);
                        i.putExtra("reussi",reussi);
                        startActivity(i);
                    }
                    else if (categorie=="Random" && nb1==5){
                        Intent i = new Intent(getApplicationContext(),QShakeQuizzActivity.class);
                        i.putExtra("incr",incr);
                        i.putExtra("incrq",incrq);
                        i.putExtra("questions",questions);
                        i.putExtra("reponses",reponses);
                        i.putExtra("categorie",categorie);
                        i.putExtra("reussi",reussi);
                        startActivity(i);
                    }
                    else if (categorie=="Random" && nb1==10){
                        Intent i = new Intent(getApplicationContext(),QDragDropQuizzActivity.class);
                        i.putExtra("incr",incr);
                        i.putExtra("incrq",incrq);
                        i.putExtra("questions",questions);
                        i.putExtra("reponses",reponses);
                        i.putExtra("categorie",categorie);
                        i.putExtra("reussi",reussi);
                        startActivity(i);
                    }
                    else {
                        Intent i = new Intent(getApplicationContext(),QSimpleQuizzActivity.class);
                        i.putExtra("incr",incr);
                        i.putExtra("incrq",incrq);
                        i.putExtra("questions",questions);
                        i.putExtra("reponses",reponses);
                        i.putExtra("categorie",categorie);
                        i.putExtra("reussi",reussi);
                        startActivity(i);
                    }
                }
        });

        b_4.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (nb==4){
                    b_4.setBackgroundColor(green);
                    reussi++;
                }
                else  {
                    b_4.setBackgroundColor(R.color.red);
                }
                incrq++;
                incr=incr+4;
                if (incrq==9){
                    Intent i = new Intent(getApplicationContext(),VictoireActivity.class);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }

                if (categorie=="Random" && nb1==1){
                    Intent i = new Intent(getApplicationContext(),QBoussoleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (categorie=="Random" && nb1==5){
                    Intent i = new Intent(getApplicationContext(),QShakeQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (categorie=="Random" && nb1==10){
                    Intent i = new Intent(getApplicationContext(),QDragDropQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(getApplicationContext(),QSimpleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
            }
        });
        b_2.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("ResourceAsColor")
            @Override
            public void onClick(View v) {
                if (nb==2){
                    b_2.setBackgroundColor(green);
                    reussi++;
                }
                else  {
                    b_2.setBackgroundColor(R.color.red);
                }
                incrq++;
                incr=incr+4;
                if (incrq==9){
                    Intent i = new Intent(getApplicationContext(),VictoireActivity.class);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }

                if (categorie=="Random" && nb1==1){
                    Intent i = new Intent(getApplicationContext(),QBoussoleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (categorie=="Random" && nb1==5){
                    Intent i = new Intent(getApplicationContext(),QShakeQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (categorie=="Random" && nb1==10){
                    Intent i = new Intent(getApplicationContext(),QDragDropQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(getApplicationContext(),QSimpleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
            }
        });
    }
}