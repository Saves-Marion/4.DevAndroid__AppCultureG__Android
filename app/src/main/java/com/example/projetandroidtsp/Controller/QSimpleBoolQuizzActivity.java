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
import com.example.projetandroidtsp.R;

import java.util.Random;

import static com.example.projetandroidtsp.R.color.green;

public class QSimpleBoolQuizzActivity extends AppCompatActivity {

    Button b_1;
    Button b_2;
    TextView text_1;
    int nb;
    Integer reussi;
    Integer incr;
    Integer incrq;
    String[] questions;
    String[] reponses;
    String categorie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q_simple_bool_quizz);

        text_1 =(TextView) findViewById(R.id.q_simple_b);
        b_1 =(Button)findViewById(R.id.rep1_simple_b);
        b_2 =(Button)findViewById(R.id.rep2_simple_b);

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
            b_2.setText(reponses[incr+1]);
        }

        if(nb==2){
            text_1.setText(questions[incrq]);
            b_1.setText(reponses[incr+1]);
            b_2.setText(reponses[incr]);
        }

        b_1.setOnClickListener(new OnClickSimple(nb,1,b_1));
        b_2.setOnClickListener(new OnClickSimple(nb,2,b_2));
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
            if (nombre==numero_bouton){
                b.setBackgroundResource(green);
                reussi++;
            }
            else  {
                b.setBackgroundResource(R.color.red);
            }
            Random random1 = new Random();
            final Integer nb1;
            nb1 = 1+random1.nextInt(15);
            incrq=incrq+1;
            incr=incr+2;
            if (incrq>9){
                Intent j = new Intent(getApplicationContext(),VictoireActivity.class);
                j.putExtra("reussi",reussi);
                j.putExtra("categorie",categorie);
                startActivity(j);
                return;
            }
            else{
                if (MesparaActivity.cate1==0  && nb1==1){
                    Intent i = new Intent(getApplicationContext(),QBoussoleQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else if (MesparaActivity.cate1==0  && nb1==5){
                    Intent i = new Intent(getApplicationContext(),QShakeQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                else {
                    Intent i = new Intent(getApplicationContext(),QSimpleBoolQuizzActivity.class);
                    i.putExtra("incr",incr);
                    i.putExtra("incrq",incrq);
                    i.putExtra("questions",questions);
                    i.putExtra("reponses",reponses);
                    i.putExtra("categorie",categorie);
                    i.putExtra("reussi",reussi);
                    startActivity(i);
                }
                finish();
            }
        }
    }
}
