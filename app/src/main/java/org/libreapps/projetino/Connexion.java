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

public class
Connexion extends AppCompatActivity {
    private Button Inscrip,Connexion_Button;
    private EditText userEmail,userPassword;
    String token;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        userEmail = (EditText)findViewById(R.id.connexion_email);
        userPassword = (EditText)findViewById(R.id.mot_de_passe);
        Connexion_Button = (Button)findViewById(R.id.button2);

        userEmail.setText("victor.li@esme.fr"); //TODO Dev
        userPassword.setText( "0618502438Li"); //TODO Dev


        Connexion_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                try {
                    JSONObject jAuth = new JSONObject();
                    jAuth.put("email", userEmail.getText().toString());
                    jAuth.put("password", userPassword.getText().toString());
                    jAuth.put("app", "MNA");
                    Log.v("LoginActivity", userEmail.getText().toString()+" "+userPassword.getText().toString());
                    ConnectionRest connectionRest = new ConnectionRest();
                    connectionRest.setJsonObj(jAuth);
                    connectionRest.setAction("auth");
                    connectionRest.execute("POST");
                    token = connectionRest.get();
                    if(token.charAt(0)=='{') {
                        Log.v("LoginActivity", token);
                    }else{
                        Log.v("token", token);
                        Log.v("connexion", "menu"+token);
                        openactivity_Menu();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                } catch (InterruptedException  e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }

            }
        });

        Inscrip = (Button) findViewById(R.id.button3);
        Inscrip = findViewById(R.id.button3);
        Inscrip.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openactivity_connexion();
            }
        });
    }
    public void openactivity_connexion(){
        Intent intent1 = new Intent(Connexion.this, inscription.class);
        intent1.putExtra("token", token);
        startActivity(intent1);
    }
    public void openactivity_Menu(){
        Intent intent = new Intent (Connexion.this, Menu.class);
        intent.putExtra("token", token);
        startActivity(intent);
    }
}