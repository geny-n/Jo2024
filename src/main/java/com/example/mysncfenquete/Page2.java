package com.example.mysncfenquete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Page2 extends AppCompatActivity implements View.OnClickListener{
    private Button btSuivant2;
    private String rer, nom;
    private TextView tvBienvenue1;
    private RadioGroup rgInformation, rgService;
    private int score;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page2);
        this.btSuivant2 = (Button) findViewById(R.id.idSuivant2);
        this.tvBienvenue1 = (TextView) findViewById(R.id.idBienvenue1);
        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.nom = this.getIntent().getStringExtra("nom").toString();
        this.btSuivant2.setOnClickListener(this);
        this.tvBienvenue1.setText("Bienvenue M./Mm " +this.nom);

        this.rgInformation = (RadioGroup) findViewById(R.id.idInformation);
        this.rgService = (RadioGroup) findViewById(R.id.idService);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idSuivant2) {

            //calcule de la note pour les deux questions
            this.score = 0;
            switch (this.rgInformation.getCheckedRadioButtonId()) {
                case R.id.idInformation1 : this.score = 16 ; break;
                case R.id.idInformation2 : this.score = 12 ; break;
                case R.id.idInformation3 : this.score = 8 ; break;
            }
            SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("Information", this.score);

            this.score = 0;
            switch (this.rgService.getCheckedRadioButtonId()) {
                case R.id.idService1 : this.score = 16 ; break;
                case R.id.idService2 : this.score = 12 ; break;
                case R.id.idService3 : this.score = 8 ; break;
            }
            SNCF.getEnquete(this.rer).getCandidat(this.nom).ajouterReponse("Service", this.score);

            Intent unIntent = new Intent(this, Fin.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("nom", this.nom);
            this.startActivity(unIntent);
        }
    }
}