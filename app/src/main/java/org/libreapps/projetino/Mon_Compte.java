package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.libreapps.projetino.Compte.Data_Compte;
import org.libreapps.projetino.DataRecette.Recette;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Mon_Compte extends AppCompatActivity {
    private Button btthome;
    private TextView nom_Compte;
    String token;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon__compte);
        token = getIntent().getStringExtra("token");

        String Nom_utilisateur = getIntent().getStringExtra("name");
        nom_Compte = (TextView) findViewById(R.id.nom_compte);
        nom_Compte.setText(Nom_utilisateur);

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