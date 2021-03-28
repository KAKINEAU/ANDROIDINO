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

public class inscription extends AppCompatActivity {
    private EditText user_email, nom_complet,user_password,user_name;
    private Button reg_create;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        user_email = (EditText) findViewById(R.id.email_address);
        nom_complet = (EditText) findViewById(R.id.nomcomplet);
        user_name = (EditText) findViewById(R.id.reg_user_name);
        user_password = (EditText) findViewById(R.id.reg_user_password);

        reg_create.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject jsonAuthentification = new JSONObject();
                    jsonAuthentification.put("name", nom_complet.getText());
                    jsonAuthentification.put("nom complet",nom_complet.getText());
                    jsonAuthentification.put("email",user_email.getText());
                    jsonAuthentification.put("pasword",user_password.getText());
                    jsonAuthentification.put("licence","MNA-1A-5U-227");
                    connectionRest.setJsonObj(jsonAuthentification);
                    connectionRest.execute("CREATE_USER");

                    String token = connectionRest.get();
                    if(token.charAt(0)=='{'){
                        Log.v("LoginActivity",token);
                    }else{
                        Intent intent = new Intent(inscription.this,accueil.class);
                        intent.putExtra("token",token);
                        startActivity(intent);
                    }
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