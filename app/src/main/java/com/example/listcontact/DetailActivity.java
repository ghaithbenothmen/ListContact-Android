package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.HashMap;

public class DetailActivity extends AppCompatActivity {

    EditText nom,prenom;
    Button mod,sup;
    int position;
    Params p=new Params();
    HashMap<String,String> m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        nom=findViewById(R.id.nom);
        prenom=findViewById(R.id.prenom);
        mod=findViewById(R.id.btnMod);
        sup=findViewById(R.id.btnSup);

        Bundle extras=getIntent().getExtras();

        if(extras!=null){

            position=extras.getInt("position");

        }

        m= p.values.get(position);

        nom.setText(m.get("nom"));
        prenom.setText(m.get("prenom"));

        mod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              m.put("nom",nom.getText().toString());
              m.put("prenom",prenom.getText().toString());
              Intent i =new Intent(getApplicationContext(),ContactActivity.class);
              startActivity(i);
              finish();
            }
        });

        sup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p.values.remove(position);
                Intent i =new Intent(getApplicationContext(),ContactActivity.class);
                startActivity(i);
                finish();
            }
        });
    }
}