package com.example.mysncfenquete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page1 extends AppCompatActivity implements View.OnClickListener {

    private Button btSuivant1;
    private String rer, nom;
    private TextView tvBienvenue;
    private RadioGroup rgPonctualite, rgProprete;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page1);
        this.tvBienvenue = (TextView) findViewById(R.id.idVenue);
        this.btSuivant1 = (Button) findViewById(R.id.idSuivant1);
        this.btSuivant1.setOnClickListener(this);
        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.nom = this.getIntent().getStringExtra("nom").toString();
        this.tvBienvenue.setText("Bienvenue M./Mm " +this.nom);
        this.rgPonctualite = (RadioGroup) findViewById(R.id.idPonctualite);
        this.rgProprete = (RadioGroup) findViewById(R.id.idProprete);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant1) {
            //calcule de la note a attribuer au candidat pour chaque question
            this.score = 0;
            switch (this.rgPonctualite.getCheckedRadioButtonId()) {
                case R.id.idPonctualite1 : this.score = 16 ; break;
                case R.id.idPonctualite2 : this.score = 12 ; break;
                case R.id.idPonctualite3 : this.score = 8 ; break;
            }
            SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("Ponctualite", this.score);

            this.score = 0;
            switch (this.rgProprete.getCheckedRadioButtonId()) {
                case R.id.idProprete1 : this.score = 16 ; break;
                case R.id.idProprete2 : this.score = 12 ; break;
                case R.id.idProprete3 : this.score = 8 ; break;
            }
            SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("Proprete", this.score);

            Intent unIntent = new Intent(this, Page2.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("nom", this.nom);
            this.startActivity(unIntent);
        }
    }
}