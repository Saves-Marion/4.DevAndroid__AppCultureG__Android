package com.example.projetandroidtsp.Controller;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.projetandroidtsp.R;

public class VictoireActivity extends AppCompatActivity {
    private Button retour;
    private TextView text;
    public static final String BUNDLE_EXTRA = "BUNDLE_EXTRA";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victoire);

        text=(TextView)findViewById(R.id.victoire);
        retour=(Button)findViewById(R.id.bouton_victoire);

        Intent i = getIntent();
        Integer reussi=i.getIntExtra("reussi", 0);
        text.setText(String.format(getString(R.string.text_victoire), reussi));

        retour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.putExtra(BUNDLE_EXTRA, 0);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}