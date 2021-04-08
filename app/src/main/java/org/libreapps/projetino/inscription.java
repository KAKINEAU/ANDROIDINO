package org.libreapps.projetino;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class inscription extends AppCompatActivity {
    private EditText user_email, nom_complet,user_password,verif_password;
    private Button reg_creat;
    String token;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        token = getIntent().getStringExtra("token");

        user_email = (EditText) findViewById(R.id.email_address);
        nom_complet = (EditText) findViewById(R.id.nomcomplet);
        user_password = (EditText) findViewById(R.id.reg_user_password);
        verif_password = (EditText) findViewById(R.id.VerifMotDePasse);

        reg_creat = (Button) findViewById(R.id.reg_create);

        reg_creat.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                try {
                    ConnectionRest connectionRest = new ConnectionRest();
                    JSONObject jsonAuthentification = new JSONObject();
                    jsonAuthentification.put("name", nom_complet.getText());
                    jsonAuthentification.put("email",user_email.getText());
                    jsonAuthentification.put("password",user_password.getText());
                    //jsonAuthentification.put("pasword2",verif_password.getText());
                    jsonAuthentification.put("licence","MNA-1A-5U-227");
                    connectionRest.setJsonObj(jsonAuthentification);
                    connectionRest.execute("CREATE_USER");

                    String token = connectionRest.get();
                    if(token.charAt(0)=='{'){
                        Log.v("LoginActivity",token);
                    }else{
                        Intent intent = new Intent(inscription.this, Menu.class);
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

            //rendre le text clickable début
        TextView textView = findViewById(R.id.textcompte);
        String text ="Vous avez un compte ?  Connectez-vous";
        SpannableString ss= new SpannableString(text);

        ClickableSpan clickableSpan1 = new ClickableSpan() {
            @Override
            public void onClick( View widget) {
               // Toast.makeText(inscription.this, "", Toast.LENGTH_SHORT).show();
                    Intent intent1 = new Intent(inscription.this, Connexion.class);

                    startActivity(intent1);
                }
        };
        ss.setSpan(clickableSpan1,22,37, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        textView.setText(ss);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
            //rendre le text clickable FIN
    }
}