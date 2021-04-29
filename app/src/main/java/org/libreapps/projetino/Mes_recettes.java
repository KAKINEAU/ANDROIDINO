package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.libreapps.projetino.DataRecette.Recette;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Mes_recettes extends AppCompatActivity {
    String token;
    ConnectionRest connectionRest;
    private ArrayList<Recette> listRecettes = new ArrayList<Recette>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        token = getIntent().getStringExtra("token");
        setContentView(R.layout.activity_mes_recettes);
        Log.v("token", " " + token);

        try{
            connectionRest = new ConnectionRest();
            connectionRest.setToken(token);
            connectionRest.setAction("recette");
            connectionRest.execute("GET");
            String listJsonObjs = connectionRest.get();
            if(listJsonObjs != null) {
                listRecettes = parse(listJsonObjs);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }




        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Mes_recettes.this, ajouter_Recette.class);
                intent.putExtra("token", token);
                startActivity(intent);
            }
        });

        ImageButton recette_N = findViewById(R.id.imageButton8);

                recette_N.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Mes_recettes.this,Fiche_Recette.class);
                        intent.putExtra("token", token);
                        intent.putExtra("name",listRecettes.get(1).getAuteur());
                        intent.putExtra("temps",listRecettes.get(1).getTemps());
                        startActivity(intent);
                    }
                });
    }

    public ArrayList<Recette> parse(final String json) {
        try {
            final ArrayList<Recette> products = new ArrayList<>();
            final JSONArray jProductArray = new JSONArray(json);
            for (int i = 0; i < jProductArray.length(); i++) {
                products.add(new Recette(jProductArray.optJSONObject(i)));
                Log.v("TAG","[Auteur] : " + products.get(i).getAuteur()+" "+products.get(i).getId());

                /*ImageButton recette_N = findViewById(R.id.imageButton8);

                recette_N.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent = new Intent(Mes_recettes.this,Fiche_Recette.class);
                        intent.putExtra("token", token);
                        //intent.putExtra("name",products.get(1).getAuteur());
                        //intent.putExtra("temps",products.get(1).getTemps());
                        startActivity(intent);
                    }
                });*/

            }//vsrdvsrvbsrt
            return products;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }
}