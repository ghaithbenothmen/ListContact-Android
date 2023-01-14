package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
EditText nom,prenom;
Button ajout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        ajout=findViewById(R.id.btnAjout);

        ajout.setOnClickListener((v)-> {
                Intent i= new Intent(getApplicationContext(),ContactActivity.class);
                i.putExtra("nom",nom.getText().toString());
                i.putExtra("prenom",prenom.getText().toString());
                startActivity(i);

        });
    }
}