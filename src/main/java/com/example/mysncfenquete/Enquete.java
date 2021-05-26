package com.example.mysncfenquete;

import java.util.HashMap;

public class Enquete {
    private HashMap <String, Candidat> lesCandidats;

    public Enquete () {
        this.lesCandidats = new HashMap<>();
    }
    public void ajouterCandidat (Candidat unCandidat) {
        this.lesCandidats.put(unCandidat.getNom(), unCandidat);
    }
    public Candidat getCandidat(String nom) {
        return this.lesCandidats.get(nom);
        //retourne un candidat parmis les candidats
    }
    public float moyenne(String nom) {
        return this.lesCandidats.get(nom).moyenne();
    }

    public HashMap<String, Candidat> getLesCandidats() {
        return lesCandidats;
    }

    public void setLesCanddats(HashMap<String, Candidat> lesCandidats) {
        this.lesCandidats = lesCandidats;
    }
}
