package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Menu extends AppCompatActivity {
    private Button Deconnexion;
    private Button Mes_recettes;
    private Button compte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_menu);

        //transition page de déconnexion
        Deconnexion = findViewById(R.id.button9);
        Deconnexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, AUrevoir.class);
                startActivity(intent);
            }
        });

        //transition page de mes recettes
        Mes_recettes = findViewById(R.id.button6);
        Mes_recettes.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Mes_recettes.class);
                startActivity(intent);
            }
        });

        //transition page de mon compte
        compte = findViewById(R.id.buttoncompte);
        compte.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Menu.this, Mon_Compte.class);
                startActivity(intent);
            }
        });




    }

}