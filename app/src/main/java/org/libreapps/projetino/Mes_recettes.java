package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
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

/*
        LinearLayout layout = (LinearLayout) findViewById(R.id.linearLayout);
        //ArrayList<ImageButton> buttons = new ArrayList<>;
        ImageButton btn[] = new ImageButton[10];
        for(int i = 0; i < 10; i++){

            btn[i] = new ImageButton(this);
            //optional: add your buttons to any layout if you want to see them in your screen
            layout.addView(btn[i]);
        }*/


        ImageButton recette_1 = findViewById(R.id.imageButton8);
        recette_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mes_recettes.this,Fiche_Recette.class);
                intent.putExtra("token", token);
                if(listRecettes.size()!=0){
                    intent.putExtra("name",listRecettes.get(2).getAuteur());
                    intent.putExtra("temps",listRecettes.get(2).getTemps());
                    intent.putExtra("commentaire",listRecettes.get(2).getCommentaire());
                    intent.putExtra("ingredients",listRecettes.get(2).getIngregients());
                    intent.putExtra("ingredients",listRecettes.get(2).getIngregients());
                }
                startActivity(intent);
            }
        });

        ImageButton recette_2 = findViewById(R.id.imageButton9);
        recette_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mes_recettes.this,Fiche_Recette.class);
                intent.putExtra("token", token);
                if(listRecettes.size()!=0){
                    intent.putExtra("name",listRecettes.get(1).getAuteur());
                    intent.putExtra("temps",listRecettes.get(1).getTemps());
                    intent.putExtra("commentaire",listRecettes.get(1).getCommentaire());
                    intent.putExtra("ingredients",listRecettes.get(1).getIngregients());
                }
                startActivity(intent);
            }
        });

        ImageButton recette_3 = findViewById(R.id.imageButton10);
        recette_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mes_recettes.this,Fiche_Recette.class);
                intent.putExtra("token", token);
                if(listRecettes.size()!=0){
                    intent.putExtra("name",listRecettes.get(3).getAuteur());
                    intent.putExtra("temps",listRecettes.get(3).getTemps());
                    intent.putExtra("commentaire",listRecettes.get(3).getCommentaire());
                    intent.putExtra("ingredients",listRecettes.get(3).getIngregients());
                }
                startActivity(intent);
            }
        });

        ImageButton recette_4 = findViewById(R.id.imageButton11);
        recette_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mes_recettes.this,Fiche_Recette.class);
                intent.putExtra("token", token);
                if(listRecettes.size()!=0){
                    intent.putExtra("name",listRecettes.get(4).getAuteur());
                    intent.putExtra("temps",listRecettes.get(4).getTemps());
                    intent.putExtra("commentaire",listRecettes.get(4).getCommentaire());
                    intent.putExtra("ingredients",listRecettes.get(4).getIngregients());
                }
                startActivity(intent);
            }
        });

        ImageButton recette_5 = findViewById(R.id.imageButton12);
        recette_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Mes_recettes.this,Fiche_Recette.class);
                intent.putExtra("token", token);
                if(listRecettes.size()!=0){
                    intent.putExtra("name",listRecettes.get(5).getAuteur());
                    intent.putExtra("temps",listRecettes.get(5).getTemps());
                    intent.putExtra("commentaire",listRecettes.get(5).getCommentaire());
                    intent.putExtra("ingredients",listRecettes.get(5).getIngregients());
                }
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
                Log.v("TAG","[Auteur] : " + products.get(i).getAuteur()+" "+products.get(i).getId()+" "+products.get(i).getTemps()+" "+products.get(i).getCommentaire()+" "+products.get(i).getIngregients());
            }
            return products;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }
}