package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Mon_Compte extends AppCompatActivity {
private Button btthome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mon__compte);
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