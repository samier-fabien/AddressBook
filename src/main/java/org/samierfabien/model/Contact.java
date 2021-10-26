package org.samierfabien.model;

public class Contact extends Entity {
    private String con_nom;
    private String con_prenom;
    private String con_statut;
    private String con_tel;
    private String con_mail;

    public Contact() {}

    public Contact(String con_nom, String con_prenom, String con_statut, String con_tel, String con_mail) {
        this.con_nom = con_nom;
        this.con_prenom = con_prenom;
        this.con_statut = con_statut;
        this.con_tel = con_tel;
        this.con_mail = con_mail;
    }

    public Contact(int id, String con_nom, String con_prenom, String con_statut, String con_tel, String con_mail) {
        super(id);
        this.con_nom = con_nom;
        this.con_prenom = con_prenom;
        this.con_statut = con_statut;
        this.con_tel = con_tel;
        this.con_mail = con_mail;
    }

    public String getCon_nom() {
        return con_nom;
    }

    public void setCon_nom(String con_nom) {
        this.con_nom = con_nom;
    }

    public String getCon_prenom() {
        return con_prenom;
    }

    public void setCon_prenom(String con_prenom) {
        this.con_prenom = con_prenom;
    }

    public String getCon_statut() {
        return con_statut;
    }

    public void setCon_statut(String con_statut) {
        this.con_statut = con_statut;
    }

    public String getCon_tel() {
        return con_tel;
    }

    public void setCon_tel(String con_tel) {
        this.con_tel = con_tel;
    }

    public String getCon_mail() {
        return con_mail;
    }

    public void setCon_mail(String con_mail) {
        this.con_mail = con_mail;
    }
}
