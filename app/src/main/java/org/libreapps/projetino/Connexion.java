package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Connexion extends AppCompatActivity {
    private Button Inscrip;
    private Button Connexion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);
        Inscrip = findViewById(R.id.button3);
        Inscrip =(Button) findViewById(R.id.button3);
        Inscrip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openactivity_connexion();
            }
        });
        Connexion = findViewById(R.id.button2);
        Connexion = (Button) findViewById(R.id.button2);
        Connexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openMenu();
            }
        });
    }
    public void openactivity_connexion(){
        Intent intent1 = new Intent(this, inscription.class);
        startActivity(intent1);
    }
    public void openMenu(){
        Intent intent2 = new Intent(this, Menu.class);
        startActivity(intent2);
    }
}