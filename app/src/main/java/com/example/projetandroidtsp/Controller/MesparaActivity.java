package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.projetandroidtsp.AsyncJSONData;
import com.example.projetandroidtsp.AsyncJSONDataBool;
import com.example.projetandroidtsp.Models.Profil;
import com.example.projetandroidtsp.DataBaseProfil.ProfilDAO;
import com.example.projetandroidtsp.R;

import java.util.Random;

public class MesparaActivity extends AppCompatActivity {

    private Spinner categorie;
    private Button go;
    public static String[] questions={"","","","","","","","","",""};
    public static String[] reponses= {"a", "d","b", "c", "e", "d", "f", "g", "h", "i", "j","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d","b","c","d"};
    private Integer incr;
    private Integer incrq;
    private RadioButton radiomult;
    private RadioButton radiobool;
    private RadioButton radioeasy;
    private RadioButton radiomedium;
    private RadioButton radiohard;
    private String ty;
    private String dif;
    private String cate;
    Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mespara);

        radiomult=(RadioButton)findViewById(R.id.multiple);
        radiobool=(RadioButton)findViewById(R.id.bool);
        radioeasy=(RadioButton)findViewById(R.id.easy);
        radiomedium=(RadioButton)findViewById(R.id.medium);
        radiohard=(RadioButton)findViewById(R.id.hard);

        categorie = (Spinner) findViewById(R.id.categories);
        go=(Button)findViewById(R.id.go);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categorie, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        categorie.setAdapter(adapter);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cate=categorie.getSelectedItem().toString();
                switch (cate) {
                    case "Science": {
                        Random random1 = new Random();
                        int nb1;
                        nb1 = 17 + random1.nextInt(3);
                        cate = "&category=" + Integer.toString(nb1);
                        break;
                    }
                    case "Animaux":
                        cate = "&category=" + "27";
                        break;
                    case "Vehicules":
                        cate = "&category=" + "28";
                        break;
                    case "Histoire_geo": {
                        Random random1 = new Random();
                        int nb1;
                        nb1 = 22 + random1.nextInt(2);
                        cate = "&category=" + Integer.toString(nb1);
                        break;
                    }
                    case "Sports":
                        cate = "&category=" + "21";
                        break;
                    case "Culture Général":
                        cate = "&category=" + "9";
                        break;
                    case "Divertissement": {
                        Random random1 = new Random();
                        int nb1;
                        nb1 = 10 + random1.nextInt(6);
                        cate = "&category=" + Integer.toString(nb1);
                        break;
                    }
                    default:
                        cate = "";
                        break;
                }

                if(radiomult.isChecked()) ty="multiple";
                else ty="boolean";

                if(radioeasy.isChecked()) dif="easy";
                else if(radiomedium.isChecked()) dif="medium";
                else dif="hard";

                if(ty=="multiple"){
                    AsyncJSONData task = new AsyncJSONData(MesparaActivity.this);
                    task.execute("https://opentdb.com/api.php?amount=10"+cate+"&difficulty="+dif+"&type="+ty);
                    i = new Intent(getApplicationContext(),QSimpleQuizzActivity.class);
                }
                else{
                    AsyncJSONDataBool task = new AsyncJSONDataBool(MesparaActivity.this);
                    task.execute("https://opentdb.com/api.php?amount=10"+cate+"&difficulty="+dif+"&type="+ty);
                    i = new Intent(getApplicationContext(),QSimpleBoolQuizzActivity.class);
                }

                incr=0;
                incrq=0;
                i.putExtra("incr",incr);
                i.putExtra("incrq",incrq);
                i.putExtra("questions",questions);
                i.putExtra("reponses",reponses);
                i.putExtra("categorie",categorie.getSelectedItem().toString());
                i.putExtra("reussi",0);
                startActivity(i);
            }
        });


    }
}