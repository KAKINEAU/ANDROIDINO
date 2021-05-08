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

public class Decouvrir extends AppCompatActivity {
    String token;
    ConnectionRest connectionRest;
    private ArrayList<Recette> listRecettes = new ArrayList<Recette>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        token = getIntent().getStringExtra("token");
        setContentView(R.layout.activity_decouvrir);
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

        ImageButton Boutonimage = findViewById(R.id.imageButton4);

        Boutonimage.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("resId",R.drawable.pommesdeterreaufoursauceciboulette_280x200);
                intent.putExtra("name",listRecettes.get(2).getAuteur());
                intent.putExtra("temps",listRecettes.get(2).getTemps());
                intent.putExtra("commentaire",listRecettes.get(2).getCommentaire());
                intent.putExtra("ingredients",listRecettes.get(2).getIngregients());
                intent.putExtra("ingredients",listRecettes.get(2).getIngregients());
                startActivity(intent);
            }
        });
        ImageButton Boutonimage2 = findViewById(R.id.imageButton5);

        Boutonimage2.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("resId",R.drawable.oeuf_au_plat);
                intent.putExtra("name",listRecettes.get(1).getAuteur());
                intent.putExtra("temps",listRecettes.get(1).getTemps());
                intent.putExtra("commentaire",listRecettes.get(1).getCommentaire());
                intent.putExtra("ingredients",listRecettes.get(1).getIngregients());
                intent.putExtra("ingredients",listRecettes.get(1).getIngregients());
                startActivity(intent);
            }
        });
        ImageButton Boutonimage3 = findViewById(R.id.imageButton6);

        Boutonimage3.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("resId",R.drawable._1162_w600);
                intent.putExtra("name",listRecettes.get(3).getAuteur());
                intent.putExtra("temps",listRecettes.get(3).getTemps());
                intent.putExtra("commentaire",listRecettes.get(3).getCommentaire());
                intent.putExtra("ingredients",listRecettes.get(3).getIngregients());
                intent.putExtra("ingredients",listRecettes.get(3).getIngregients());
                startActivity(intent);
            }
        });
        ImageButton Boutonimage4 = findViewById(R.id.imageButton16);

        Boutonimage4.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("resId",R.drawable.i6417_chevre_chaud_sur_toast);
                intent.putExtra("name",listRecettes.get(4).getAuteur());
                intent.putExtra("temps",listRecettes.get(4).getTemps());
                intent.putExtra("commentaire",listRecettes.get(4).getCommentaire());
                intent.putExtra("ingredients",listRecettes.get(4).getIngregients());
                intent.putExtra("ingredients",listRecettes.get(4).getIngregients());
                startActivity(intent);
            }
        });
        ImageButton Boutonimage5 = findViewById(R.id.imageButton17);

        Boutonimage5.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("resId",R.drawable.i12947_omelette_simple);
                intent.putExtra("name",listRecettes.get(5).getAuteur());
                intent.putExtra("temps",listRecettes.get(5).getTemps());
                intent.putExtra("commentaire",listRecettes.get(5).getCommentaire());
                intent.putExtra("ingredients",listRecettes.get(5).getIngregients());
                intent.putExtra("ingredients",listRecettes.get(5).getIngregients());
                startActivity(intent);
            }
        });
        /*
        ImageButton Boutonimage6 = findViewById(R.id.imageButton18);

        Boutonimage6.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("name",listRecettes.get(5).getAuteur());
                intent.putExtra("temps",listRecettes.get(5).getTemps());
                startActivity(intent);
            }
        });
        ImageButton Boutonimage7 = findViewById(R.id.imageButton19);

        Boutonimage7.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("name",listRecettes.get(6).getAuteur());
                intent.putExtra("temps",listRecettes.get(6).getTemps());
                startActivity(intent);
            }
        });
        ImageButton Boutonimage8 = findViewById(R.id.imageButton20);

        Boutonimage8.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("name",listRecettes.get(7).getAuteur());
                intent.putExtra("temps",listRecettes.get(7).getTemps());
                startActivity(intent);
            }
        });
        ImageButton Boutonimage9 = findViewById(R.id.imageButton21);

        Boutonimage9.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Decouvrir.this, Fiche_Recette.class);
                intent.putExtra("token", token);
                intent.putExtra("name",listRecettes.get(8).getAuteur());
                intent.putExtra("temps",listRecettes.get(8).getTemps());
                startActivity(intent);
            }
        });
        */

    }
    public ArrayList<Recette> parse(final String json) {
        try {
            final ArrayList<Recette> products = new ArrayList<>();
            final JSONArray jProductArray = new JSONArray(json);
            for (int i = 0; i < jProductArray.length(); i++) {
                products.add(new Recette(jProductArray.optJSONObject(i)));
                Log.v("TAG","[Auteur] : " + products.get(i).getAuteur()+" "+products.get(i).getId());
            }
            return products;
        } catch (JSONException e) {
            Log.v("TAG","[JSONException] e : " + e.getMessage());
        }
        return null;
    }

}