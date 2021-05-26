package com.example.mysncfenquete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class Inscription extends AppCompatActivity implements View.OnClickListener {
    private Button btParticiper;
    private EditText txtNom, txtPrenom;
    private Spinner spAge, spFrequence;
    private TextView tvTitre;
    private String rer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);
        this.btParticiper = (Button) findViewById(R.id.idParticiper);
        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.spAge = (Spinner) findViewById(R.id.idAge);
        this.spFrequence = (Spinner) findViewById(R.id.idFrequence);
        this.tvTitre = (TextView) findViewById(R.id.idTitre);
        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.tvTitre.setText("Bienvenue dans l'enquete du " +rer);
        this.btParticiper.setOnClickListener(this);

        //remplissage du spinner age
        ArrayList<String> lesAges = new ArrayList<String>();
        lesAges.add("moins 18 ans");
        lesAges.add("18 ans - 35 ans");
        lesAges.add("plus de 65 ans");

        //instanciation d'un adaptateur d'affichage
        ArrayAdapter unAdaptaterAge = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, lesAges);
        this.spAge.setAdapter(unAdaptaterAge);


        //remplissage du spinner frequence
        ArrayList<String> lesFrequences = new ArrayList<String>();
        lesFrequences.add("Quotidienne");
        lesFrequences.add("Hebdomadaire");
        lesFrequences.add("Mensuelle");
        lesFrequences.add("Annuelle");

        //instanciation d'un adaptateur d'affichage
        ArrayAdapter unAdaptaterFrequence = new ArrayAdapter(this,
                android.R.layout.simple_spinner_item, lesFrequences);
        this.spFrequence.setAdapter(unAdaptaterFrequence);

        //rendre le boutton ecoutable
        this.btParticiper.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idParticiper) {
            String nom = this.txtNom.getText().toString();
            String prenom = this.txtPrenom.getText().toString();
            String age = this.spAge.getSelectedItem().toString();
            String frequence = this.spFrequence.getSelectedItem().toString();

            //instanciation d'un candidat
            Candidat unCandidat = new Candidat(nom, prenom, age, frequence);
            SNCF.getEnquete(this.rer).ajouterCandidat(unCandidat);


            //demarrage de l'Enquete
            Intent unIntent = new Intent(this, Page1.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("nom", nom);
            unIntent.putExtra("prenom", prenom);
            this.startActivity(unIntent);
        }
    }
}