package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Mon_Compte extends AppCompatActivity {
    private Button btthome;
    private TextView nom_Compte;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon__compte);

        token = getIntent().getStringExtra("token");
        String nom_utilisateur = getIntent().getStringExtra("name");
        nom_Compte = (TextView) findViewById(R.id.nom_compte);
        nom_Compte.setText(nom_utilisateur);

        //transition page de déconnexion
        btthome = findViewById(R.id.button4);
        btthome.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mon_Compte.this, Menu.class);
                startActivity(intent);
            }
        });

    }
}