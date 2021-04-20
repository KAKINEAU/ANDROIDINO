package org.libreapps.projetino.DataRecette;

import org.json.JSONObject;

public class Recette {
    private final String temps;
    private final String auteur;

    public Recette(JSONObject jObject) {
        this.temps = jObject.optString("temps");
        this.auteur = jObject.optString("auteur");

    }

    public String getTemps(){ return temps;}
    public String getAuteur(){ return auteur;}
}
