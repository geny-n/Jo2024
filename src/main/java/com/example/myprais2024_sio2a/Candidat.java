package com.example.myprais2024_sio2a;

public class Candidat {
    private int idcandidat;
    private String nom, prenom, email, mdp, adresse,tel;

    public Candidat(int idcandidat, String nom, String prenom, String email, String mdp, String adresse, String tel) {
        this.idcandidat = idcandidat;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.tel = tel;
    }

    public Candidat(String nom, String prenom, String email, String mdp, String adresse, String tel) {
        this.idcandidat = 0;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.adresse = adresse;
        this.tel = tel;
    }

    //constructeur : construire un candidat avec que  email et mdp
    public Candidat(String email, String mdp) {
        this.idcandidat = 0;
        this.nom = "";
        this.prenom = "";
        this.email = email;
        this.mdp = mdp;
        this.adresse = "";
        this.tel = "";
    }

    public int getIdcandidat() {
        return idcandidat;
    }

    public void setIdcandidat(int idcandidat) {
        this.idcandidat = idcandidat;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
