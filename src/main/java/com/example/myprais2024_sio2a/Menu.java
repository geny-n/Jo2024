package com.example.myprais2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener{
    private Button btEvenements, btMesEvenements, btProfile, btDeconnexion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        this.btEvenements = (Button) findViewById(R.id.idEvenements);
        this.btMesEvenements = (Button) findViewById(R.id.idMesEvenements);
        this.btDeconnexion = (Button) findViewById(R.id.idDeconnexion);
        this.btProfile =(Button) findViewById(R.id.idProfile);

        this.btMesEvenements.setOnClickListener(this);
        this.btEvenements.setOnClickListener(this);
        this.btDeconnexion.setOnClickListener(this);
        this.btProfile.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent unIntent = null;
        switch(v.getId()) {
            case R.id.idEvenements :
                unIntent = new Intent(this, Evenements.class);
                break;
            case R.id.idMesEvenements :
                unIntent = new Intent(this, MesEvenements.class);
                break;
            case R.id.idProfile :
                unIntent = new Intent(this, Profile.class);
                break;
            case R.id.idDeconnexion :
                unIntent = new Intent(this, MainActivity.class);
                break;
        }
        this.startActivity(unIntent);
    }
}