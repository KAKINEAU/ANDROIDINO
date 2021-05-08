package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.libreapps.projetino.Compte.Data_Compte;
import org.libreapps.projetino.DataRecette.Recette;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Menu extends AppCompatActivity {
    String token;

    ConnectionRest connectionRest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        token = getIntent().getStringExtra("token");
        Log.v("token", "menu  "+token);
        String nomcompte = getIntent().getStringExtra("Nomcompte");

        //transition page de déconnexion
        Button Deconnexion = findViewById(R.id.button9);
        Deconnexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.v("token", "menu"+token);
                Intent intent = new Intent(Menu.this, AUrevoir.class);
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });

        //transition page de mes recettes
        Button Mes_recettes = findViewById(R.id.button6);
        Mes_recettes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Log.v("token", " "+token);
                Intent intent = new Intent(Menu.this, Mes_recettes.class);
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });

        //transition page de mon compte
        Button compte = findViewById(R.id.buttoncompte);
        compte.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Mon_Compte.class);
                intent.putExtra("token", token);

                intent.putExtra("Nom_utilisateur",nomcompte);
                startActivity(intent);
            }
        });

        //transition page recettes de saison
        Button recettes_de_saison = findViewById(R.id.button5);
        recettes_de_saison.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Recettes_de_saison.class);
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });

        //transition page découvrir
        Button découvrir = findViewById(R.id.button8);
        découvrir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Decouvrir.class);
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });

        //transition page mes ingrédients
        Button ingrédients = findViewById(R.id.button7);
        ingrédients.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Mes_ingredients.class);
                startActivity(intent);
            }
        });
    }

}