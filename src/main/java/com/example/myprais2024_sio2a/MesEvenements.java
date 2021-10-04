package com.example.myprais2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MesEvenements extends AppCompatActivity implements View.OnClickListener {
    private ListView ListMesEvents;
    private Button btRetour2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mes_evenements);

        this.ListMesEvents = (ListView) findViewById(R.id.idListMesEvents);
        this.btRetour2 = (Button) findViewById(R.id.idRetour2);

        this.btRetour2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idRetour2) {
            //on verifie la connexion
            //on passe à la page Mennu
            Intent unIntent = new Intent(this, Menu.class);
            this.startActivity(unIntent);
        }
    }
}