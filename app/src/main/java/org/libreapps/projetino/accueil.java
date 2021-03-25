package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class accueil extends AppCompatActivity {
    private Button Suivant;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        Suivant = findViewById(R.id.button);
        Suivant =(Button) findViewById(R.id.button);
        Suivant.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openPage_Connection();
            }
        });
    }

    public void openPage_Connection(){
        Intent intent = new Intent(this, Connexion.class);
        startActivity(intent);
    }
}