package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.json.JSONArray;
import org.json.JSONException;
import org.libreapps.projetino.DataRecette.Recette;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class Recettes_de_saison extends AppCompatActivity {
    String token;
    ConnectionRest connectionRest;
    private ArrayList<Recette> listRecettes = new ArrayList<Recette>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recettes_de_saison);
        token = getIntent().getStringExtra("token");
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

            //transition page de recette
        ImageButton image = findViewById(R.id.imageButton3);
        image.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(Recettes_de_saison.this, Fiche_Recette.class);
                    intent.putExtra("resId",R.drawable.i6417_chevre_chaud_sur_toast);
                    intent.putExtra("name",listRecettes.get(4).getAuteur());
                    intent.putExtra("temps",listRecettes.get(4).getTemps());
                    intent.putExtra("commentaire",listRecettes.get(4).getCommentaire());
                    intent.putExtra("ingredients",listRecettes.get(4).getIngregients());
                    startActivity(intent);
                }
            });

        //transition page de recette
        ImageButton image2 = findViewById(R.id.imageButton2);
        image2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Recettes_de_saison.this, Fiche_Recette.class);
                intent.putExtra("resId",R.drawable.i12947_omelette_simple);
                intent.putExtra("name",listRecettes.get(5).getAuteur());
                intent.putExtra("temps",listRecettes.get(5).getTemps());
                intent.putExtra("commentaire",listRecettes.get(5).getCommentaire());
                intent.putExtra("ingredients",listRecettes.get(5).getIngregients());
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