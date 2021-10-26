package org.samierfabien.model;

public class Provider extends Entity {
    private String pro_nom;
    private String pro_ville;
    private String pro_postal;
    private String pro_adresse;

    public Provider() {}

    public Provider(String pro_nom, String pro_ville, String pro_postal, String pro_adresse) {
        this.pro_nom = pro_nom;
        this.pro_ville = pro_ville;
        this.pro_postal = pro_postal;
        this.pro_adresse = pro_adresse;
    }

    public Provider(int id, String pro_nom, String pro_ville, String pro_postal, String pro_adresse) {
        super(id);
        this.pro_nom = pro_nom;
        this.pro_ville = pro_ville;
        this.pro_postal = pro_postal;
        this.pro_adresse = pro_adresse;
    }

    public String getPro_nom() {
        return pro_nom;
    }

    public void setPro_nom(String pro_nom) {
        this.pro_nom = pro_nom;
    }

    public String getPro_ville() {
        return pro_ville;
    }

    public void setPro_ville(String pro_ville) {
        this.pro_ville = pro_ville;
    }

    public String getPro_postal() {
        return pro_postal;
    }

    public void setPro_postal(String pro_postal) {
        this.pro_postal = pro_postal;
    }

    public String getPro_adresse() {
        return pro_adresse;
    }

    public void setPro_adresse(String pro_adresse) {
        this.pro_adresse = pro_adresse;
    }
}
