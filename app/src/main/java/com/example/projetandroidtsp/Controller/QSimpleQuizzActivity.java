package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
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
    int categorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_simple_quizz);

        text_1 =(TextView) findViewById(R.id.q_simple);
        b_1 =(Button)findViewById(R.id.rep1_simple);
        b_2 =(Button)findViewById(R.id.rep2_simple);
        b_3 =(Button)findViewById(R.id.rep3_simple);
        b_4 =(Button)findViewById(R.id.rep4_simple);

        Intent i = getIntent();
        incr = i.getIntExtra("incr", 0);
        incrq = i.getIntExtra("incrq", 0);
        questions = i.getStringArrayExtra("questions");
        reponses = i.getStringArrayExtra("reponses");
        reussi=i.getIntExtra("reussi", -1);
        categorie=i.getIntExtra("categorie",0);

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

            b_1.setOnClickListener(new OnClickSimple(nb,1,b_1));
            b_2.setOnClickListener(new OnClickSimple(nb,2,b_2));
            b_3.setOnClickListener(new OnClickSimple(nb,3,b_3));
            b_4.setOnClickListener(new OnClickSimple(nb,4,b_4));

    }

    public class OnClickSimple implements View.OnClickListener{

        Integer nombre;
        Integer numero_bouton;
        Button b;
        public OnClickSimple(Integer nombre,Integer numero_bouton,Button b){
            this.nombre=nombre;
            this.numero_bouton=numero_bouton;
            this.b=b;
        }

        @Override
        public void onClick(View v) {
            Random random1 = new Random();
            final Integer nb1;
            nb1 = 1+random1.nextInt(15);

            if (nombre.equals(numero_bouton)){
                b.setBackgroundResource(green);
                reussi++;
            }
            else  {
                b.setBackgroundResource(R.color.red);
            }

            incrq=incrq+1;
            incr=incr+4;
            if (incrq>9){
                Intent j = new Intent(getApplicationContext(),VictoireActivity.class);
                j.putExtra("reussi",reussi);
                j.putExtra("categorie",categorie);
                startActivity(j);
                return;
            }
            else{
                if (MesparaActivity.cate1==0 && nb1==1){
                    Intent i = new Intent(getApplicationContext(),QBoussoleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (MesparaActivity.cate1==0 && nb1==5){
                    Intent i = new Intent(getApplicationContext(),QShakeQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                /*
                else if (MesparaActivity.cate1==0 && nb1==10){
                    Intent i = new Intent(getApplicationContext(),QDragDropQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }*/
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
            finish();
        }
    }
}
