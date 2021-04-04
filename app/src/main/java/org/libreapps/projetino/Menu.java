package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_menu);

        //transition page de déconnexion
        Button Deconnexion = findViewById(R.id.button9);
        Deconnexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, AUrevoir.class);
                startActivity(intent);
            }
        });

        //transition page de mes recettes
        Button Mes_recettes = findViewById(R.id.button6);
        Mes_recettes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Mes_recettes.class);
                startActivity(intent);
            }
        });

        //transition page de mon compte
        Button compte = findViewById(R.id.buttoncompte);
        compte.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Mon_Compte.class);
                startActivity(intent);
            }
        });

        //transition page recettes de saison
        Button recettes_de_saison = findViewById(R.id.button5);
        recettes_de_saison.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Recettes_de_saison.class);
                startActivity(intent);
            }
        });

        //transition page découvrir
        Button découvrir = findViewById(R.id.button8);
        découvrir.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Decouvrir.class);
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