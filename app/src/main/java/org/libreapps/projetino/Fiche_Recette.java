package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Fiche_Recette extends AppCompatActivity {
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche__recette);

        token = getIntent().getStringExtra("token");
        Log.v("result", " "+token);

        int id = getIntent().getIntExtra("id",0);
        String name = getIntent().getStringExtra("auteur");
        String temps= getIntent().getStringExtra("temps");

        TextView auteur = (TextView) findViewById(R.id.textView39);
        TextView tempspreparation = (TextView) findViewById(R.id.textView40);
        if(id!=0){
            auteur.setText(name);
            tempspreparation.setText(temps);
        }



    }

}