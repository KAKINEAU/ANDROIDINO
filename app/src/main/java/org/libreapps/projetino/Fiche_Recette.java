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
        String commentaire = getIntent().getStringExtra("commentaire");
        String ingredients = getIntent().getStringExtra("ingredients");

        TextView auteur = (TextView) findViewById(R.id.textView40);
        TextView tempspreparation = (TextView) findViewById(R.id.textView39);
        TextView ingredient = (TextView) findViewById(R.id.textView18);
        TextView commentaires = (TextView) findViewById(R.id.textView21);

        auteur.setText(name);
        tempspreparation.setText(temps);
        ingredient.setText(ingredients);
        commentaires.setText(commentaire);

        //TODO ajouter l'affichage des commentaire ainsi que des ingrédients

    }

}