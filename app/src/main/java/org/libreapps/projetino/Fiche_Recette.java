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
        Log.v("result", " "+token );

        String name = getIntent().getStringExtra("name");
        String temps = getIntent().getStringExtra("temps");

        TextView auteur = (TextView) findViewById(R.id.textView39);
        TextView tempspreparation = (TextView) findViewById(R.id.textView40);

        auteur.setText(name);
        tempspreparation.setText(temps);

//TODO on pourra ajouter des choses comme des commentaires ainsi que les différentes étapes de la cuisson

    }

}