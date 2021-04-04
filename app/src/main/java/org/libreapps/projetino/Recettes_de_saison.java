package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Recettes_de_saison extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recettes_de_saison);





            //transition page de recette
        ImageButton image = findViewById(R.id.imageButton3);
        image.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Recettes_de_saison.this, ajouter_Recette.class);
                    startActivity(intent);
                }
            });
        //transition page de recette
        ImageButton image3 = findViewById(R.id.imageButton);
        image3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recettes_de_saison.this, ajouter_Recette.class);
                startActivity(intent);
            }
        });
        //transition page de recette
        ImageButton image2 = findViewById(R.id.imageButton2);
        image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recettes_de_saison.this, ajouter_Recette.class);
                startActivity(intent);
            }
        });

    }
}