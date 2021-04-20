package org.libreapps.projetino.Compte;

import org.json.JSONObject;

public class Data_Compte {
    private final int id;
    private final String name;
    public Data_Compte(JSONObject jObject) {
        this.id = jObject.optInt("id");
        this.name = jObject.optString("name");
    }

    public int getId() { return id; }
    public String getName() { return name; }
}