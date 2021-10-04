package com.example.myprais2024_sio2a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profile extends AppCompatActivity implements View.OnClickListener{
    private EditText txtNom, txtPrenom, txtEmail, txtMdp, txtAdresse, txtTel;
    private Button btAnnuler, btValider;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);


        this.txtNom = (EditText) findViewById(R.id.idNom);
        this.txtPrenom = (EditText) findViewById(R.id.idPrenom);
        this.txtEmail = (EditText) findViewById(R.id.idMail);
        this.txtMdp = (EditText) findViewById(R.id.idMdp);
        this.txtAdresse = (EditText) findViewById(R.id.idEmail);
        this.txtTel = (EditText) findViewById(R.id.idTel);

        this.btAnnuler = (Button) findViewById(R.id.idAnnuler);
        this.btValider = (Button) findViewById(R.id.idValider);

        this.btAnnuler.setOnClickListener(this);
        this.btValider.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.idAnnuler :

                break;
            case R.id.idValider :

                break;
        }
    }
}