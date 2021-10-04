package com.example.myprais2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class Evenements extends AppCompatActivity implements View.OnClickListener{

    private ListView ListEvents;
    private Button btRetour1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evenements);

        this.ListEvents = (ListView) findViewById(R.id.idListEvents);
        this.btRetour1 = (Button) findViewById(R.id.idRetour1);

        this.btRetour1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.idRetour1) {
            //on verifie la connexion
            //on passe à la page Menu
            Intent unIntent = new Intent(this, Menu.class);
            this.startActivity(unIntent);
        }
    }
}