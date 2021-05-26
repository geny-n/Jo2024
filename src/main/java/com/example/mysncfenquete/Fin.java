 package com.example.mysncfenquete;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Fin extends AppCompatActivity implements View.OnClickListener {
    private TextView tvResultat;
    private ImageView imgSmiley;
    private Button btRetour;
    private String rer, nom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fin);
        this.tvResultat = (TextView) findViewById(R.id.idResultat);
        this.imgSmiley = (android.widget.ImageView) findViewById(R.id.idSmiley);
        this.btRetour = (Button) findViewById(R.id.idRetour);
        this.btRetour.setOnClickListener(this);

        this.rer = this.getIntent().getStringExtra("rer").toString();
        this.nom = this.getIntent().getStringExtra("nom").toString();

        //calcul de la moyenne
        float moyenne = SNCF.getEnquete(this.rer).getCandidat(this.nom).moyenne();
        this.tvResultat.setText("M./Mm " + this.nom + ", votre moyenne est de : " +moyenne);
        if (moyenne < 12) {
            this.imgSmiley.setImageResource(R.drawable.smiley_3);
        } else if (moyenne < 14) {
            this.imgSmiley.setImageResource(R.drawable.smiley_2);
        } else {
            this.imgSmiley.setImageResource(R.drawable.smiley_1);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.idRetour) {
            Intent unIntent = new Intent(this, MainActivity.class);
            unIntent.putExtra("rer", this.rer);
            unIntent.putExtra("nom", this.nom);
            this.startActivity(unIntent);
        }
    }
}