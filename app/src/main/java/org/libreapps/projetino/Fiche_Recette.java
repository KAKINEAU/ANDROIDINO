package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class Fiche_Recette extends AppCompatActivity {
    String token;
    String name2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiche__recette);

        token = getIntent().getStringExtra("token");
        name2 = getIntent().getStringExtra("name");
        Log.v("result", " "+token+ name2 );

        int id = getIntent().getIntExtra("id",0);
        String name = getIntent().getStringExtra("auteur");
        String temps= getIntent().getStringExtra("temps");

        TextView auteur = (TextView) findViewById(R.id.textView39);
        TextView tempspreparation = (TextView) findViewById(R.id.textView40);

        auteur.setText(name2);
        tempspreparation.setText(temps);



    }

}