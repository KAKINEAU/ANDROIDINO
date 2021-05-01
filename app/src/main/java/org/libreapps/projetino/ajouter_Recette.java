package org.libreapps.projetino;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class ajouter_Recette extends AppCompatActivity {
    private EditText Temps,Auteur,Commentaires,Ingredients;
    private Button Enregistrer;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter__recette);
        token = getIntent().getStringExtra("token");

        Temps = (EditText) findViewById(R.id.editTextTextPersonName3);
        Auteur = (EditText) findViewById(R.id.editTextTextPersonName4);
        Commentaires = (EditText) findViewById(R.id.editTextTextPersonName7);
        Ingredients = (EditText) findViewById(R.id.editTextTextPersonName6);

        Enregistrer = (Button) findViewById(R.id.button10);

        Enregistrer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Log.v("CréerRecette", ""+token);
                    ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject Recette = new JSONObject();

                    Recette.put("temps", Temps.getText().toString());
                    Recette.put("auteur", Auteur.getText().toString());
                    Recette.put("commentaire",Commentaires.getText().toString());
                    Recette.put("ingredients",Ingredients.getText().toString());

                    //TODO il faudrat peut-être créer une liste pour enregistrer tous les ingrédient et ensuite intégrer les ingrédients dans la bdd
                    //TODO Pour la cuisson on fera directement un long texte ou alors la même chose que pour les ingrédients

                    connectionRest.setJsonObj(Recette);
                    connectionRest.setToken(token);
                    connectionRest.setAction("recette");
                    connectionRest.execute("POST");
                    String result = connectionRest.get();
                    Log.v("result", " "+result);
                    Intent intent = new Intent(ajouter_Recette.this, Mes_recettes.class);
                    intent.putExtra("token", token);
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}