package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.renderscript.AllocationAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.projetandroidtsp.DataBaseProfil.ProfilDAO;
import com.example.projetandroidtsp.Models.Categories;
import com.example.projetandroidtsp.Models.Profil;
import com.example.projetandroidtsp.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ChoixProfilActivity extends AppCompatActivity {
    private ListView liste_categorie;
    private Button modifier;
    private Button retour;
    private WebView internet;

    private ProfilDAO profilDAO;
    private Profil p;

    CategoriesAdapter cateadaptater;
    ArrayList<Categories> ctgrs=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choix_profil);

        liste_categorie=(ListView)findViewById(R.id.list_choix_profil);
        retour=(Button)findViewById(R.id.button1_choix_profil);
        modifier=(Button)findViewById(R.id.button2_choix_profil);

        //internet=(WebView)findViewById(R.id.internet);
        //internet.loadUrl("https://fr.wikipedia.org/wiki/Culture_g%C3%A9n%C3%A9rale");

        profilDAO=new ProfilDAO(this);
        profilDAO.open();

        ctgrs = new ArrayList<Categories>();
        long id=0;
        p=profilDAO.selectionner(id);
        ctgrs.add(new Categories("Science", R.drawable.science, p.getNb_reussi_science()));
        ctgrs.add(new Categories("Animaux", R.drawable.science,p.getNb_reussi_animaux()));
        ctgrs.add(new Categories("Vehicules", R.drawable.science,p.getNb_reussi_vehicules()));
        ctgrs.add(new Categories("Histoire_géo", R.drawable.science,p.getNb_reussi_histoire_geo()));
        ctgrs.add(new Categories("Sport", R.drawable.science,p.getNb_reussi_sports()));
        ctgrs.add(new Categories("Culture Générale", R.drawable.science,p.getNb_reussi_culture_g()));
        ctgrs.add(new Categories("Random", R.drawable.science,p.getNb_reussi_random()));
        ctgrs.add(new Categories("Divertissement", R.drawable.science,p.getNb_reussi_divertissement()));
        cateadaptater = new CategoriesAdapter(getApplicationContext(), ctgrs);
        liste_categorie.setAdapter(cateadaptater);

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        modifier.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder monDialogue = new AlertDialog.Builder(ChoixProfilActivity.this);
                monDialogue.setTitle("Gestionnaire profil");
                monDialogue.setMessage("Que voulez-vous faire?");

                //Bouton du dialogue
                monDialogue.setPositiveButton("Créer", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(),CreerProfilActivity.class);
                        startActivity(i);
                    }
                });
                monDialogue.setNegativeButton("Modifier", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(getApplicationContext(),ModifierProfilActivity.class);
                        startActivity(i);
                    }
                });
                monDialogue.setNeutralButton("Changer de Profil", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        AlertDialog.Builder alertDialog = new AlertDialog.Builder(ChoixProfilActivity.this);
                        alertDialog.setTitle("Choisir le profil");
                        String[] items=new String[MainActivity.nb_profil];
                        for(int i=0;i<MainActivity.nb_profil;i++){
                            items[i]=profilDAO.selectionner(i).getNom();
                        }
                        alertDialog.setItems(items, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            }
                        });
                        AlertDialog alert = alertDialog.create();
                        alert.setCanceledOnTouchOutside(true);
                        alert.show();
                    }
                });
                monDialogue.show();
            }
        });
    }

    public class CategoriesAdapter extends ArrayAdapter<Categories> {
        public CategoriesAdapter(Context context, ArrayList<Categories> categories) {
            super(context, 0, categories);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = getLayoutInflater().inflate(R.layout.row_layout, parent, false);
        }

        Categories categories=getItem(position);

        CategoriesViewHolder viewHolder=(CategoriesViewHolder) convertView.getTag();
        if(viewHolder == null){
            viewHolder = new CategoriesViewHolder();
            viewHolder.cate = (TextView) convertView.findViewById(R.id.categorie);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.imagecate);
            viewHolder.point = (TextView) convertView.findViewById(R.id.point);
            convertView.setTag(viewHolder);
    }
        viewHolder.cate.setText(categories.getAppelation());
        //viewHolder.img.setImageDrawable(Drawable);
        viewHolder.point.setText(categories.getNb_succes().toString());
        return convertView;
    }

    private class CategoriesViewHolder{
            public TextView cate;
            public ImageView img;
            public TextView point;
    }
}
}