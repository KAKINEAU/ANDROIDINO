package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {
    private Button Deconnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Deconnexion = findViewById(R.id.button9);
        Deconnexion =(Button) findViewById(R.id.button9);
        Deconnexion.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                opena_urevoir();
            }
        });
    }
    public void opena_urevoir(){
        Intent intent3 = new Intent(this, AUrevoir.class);
        startActivity(intent3);
    }
}