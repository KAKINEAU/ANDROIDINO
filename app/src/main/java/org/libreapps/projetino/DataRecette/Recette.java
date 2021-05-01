package org.libreapps.projetino.DataRecette;

import org.json.JSONObject;

import java.util.ArrayList;

public class Recette {
    private final int id;
    private final String temps;
    private final String auteur;
    private final String commentaire;
    private final String ingregients;

    public Recette(JSONObject jObject) {
        this.temps = jObject.optString("temps");
        this.auteur = jObject.optString("auteur");
        this.id = jObject.optInt("id");
        this.commentaire = jObject.optString("commentaire");
        this.ingregients = jObject.optString("ingredients");
    }

    public String getTemps(){ return temps;}
    public String getAuteur(){ return auteur;}
    public int getId(){ return id; }
    public String getCommentaire(){ return commentaire; }
    public String getIngregients() { return ingregients; }
}
