package com.example.myprais2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText txtEmail, txtMdp;
    private Button btConnexion;

    private static Candidat unCandidatConnecte;

    public static void setUnCandidatConnecte(Candidat unCandidat) {
        unCandidatConnecte = unCandidat;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.btConnexion = (Button) findViewById(R.id.idConnexion);
        this.txtEmail = (EditText) findViewById(R.id.idEmail);
        this.txtMdp = (EditText) findViewById(R.id.idPassword);

        this.btConnexion.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idConnexion) {
    //on verifie la connexion

            //recupere email et mdp
            String email = this.txtEmail.getText().toString();
            String mdp = this.txtMdp.getText().toString();

            //instancier la classe Candidat
                //3eme constructeur
            Candidat unCandidat = new Candidat(email, mdp);

            //on recherche le candidat dans la bdd via json
            Connexion uneConnexion = new Connexion();
            uneConnexion.execute(unCandidat);
            //test de connexion
            if (unCandidatConnecte == null) {
                Toast.makeText(this, "veuillez verifier vos identifians !  ",
                        Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Bienvenue" +unCandidatConnecte.getNom(),
                        Toast.LENGTH_LONG).show();
            }

            //on passe à la page Menu
            Intent unIntent = new Intent(this, Menu.class);
            this.startActivity(unIntent);
        }
    }
}

/***** Nouvelle classe : tache asynchrone****/

class Connexion extends AsyncTask<Candidat, Void, Candidat> {

    @Override
    protected Candidat doInBackground(Candidat... candidats) { //connecter au server http et au json
        Candidat candidatEntree = candidats[0];//candidat en entree
        Candidat candidatBDD = null; //candidat resultat
        String url = "http://192.168.1.2/Android/verifConnexion.php"; //url definir une chaine de caractere

        url += "?email="+candidatEntree.getEmail()+"&mdp="+candidatEntree.getMdp(); //chaine de connexion


        String resultatJson="";
        try {
            URL uneURL = new URL(url); //url sur l ojet de l url
            HttpURLConnection uneConnexion = (HttpURLConnection) uneURL.openConnection(); //ouvrir une connexion

            //je fixe une methode d'envoi GET
            uneConnexion.setRequestMethod("GET");
            //onfixe les temps de connexion
            uneConnexion.setConnectTimeout(20000);
            uneConnexion.setReadTimeout(15000);
            //on ouvre l'envoie et la reception des donnees
            uneConnexion.setDoInput(true);
            uneConnexion.setDoOutput(true);
            //on se connecte à la page php
            uneConnexion.connect();

            //lecture de la chaine json : page php consideree comme un fichier
            InputStreamReader isr = new InputStreamReader(uneConnexion.getInputStream(), "UTF-8");

            //lecture java
            //instanciation d'un buffer de lecture sur le fichier
            BufferedReader br = new BufferedReader(isr);
            //instanciation d'une chaine de caractere dynamique
            StringBuilder sb = new StringBuilder();
            String ligne = "";

            /* do {
                ligne = br.readLine();
                sb.append(ligne);
            } while (ligne != null);*/


            while ((ligne = br.readLine()) != null) {//tant qu'il y a une ligne a lire
                sb.append(ligne); //on cumule chaque ligne lue
            }
            resultatJson = sb.toString();
            Log.e ("Json lu : ", resultatJson);
            br.close();
            isr.close();


        }
        catch(Exception exp) {
            Log.e("Erreur 1 :" , "Impossible de se connecter a : " +url);
            exp.printStackTrace();
        }

        if (! resultatJson.equals("")) {
            try {
                JSONArray tabJson = new JSONArray(resultatJson);
                //il y a un seul objet dans le tableau json : un candidat connecte
                JSONObject unObjet = tabJson.getJSONObject(0);
                candidatBDD = new Candidat(
                        unObjet.getInt("idcandidat"),
                        unObjet.getString("nom"), unObjet.getString("prenom"),
                        candidatEntree.getEmail(), candidatEntree.getMdp(),
                        unObjet.getString("adresse"), unObjet.getString("tel")
                );
            } catch (JSONException exp) {
                Log.e("Erreur 2 : ", "impossible de passer le JSON");
            }
        }

        return candidatBDD;
    }

    //on implemente la methode de retour de resultat

    @Override
    protected void onPostExecute(Candidat candidat) {
        MainActivity.setUnCandidatConnecte(candidat);
    }
}





























