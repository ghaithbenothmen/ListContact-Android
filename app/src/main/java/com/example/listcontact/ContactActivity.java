package com.example.listcontact;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class ContactActivity extends AppCompatActivity {

    ListView ls;
    String nom,prenom;
    HashMap<String,String> map;
    Params p=new Params();
    Button ajout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        ls=findViewById(R.id.lst);
        ajout=findViewById(R.id.btnAjout);

            Bundle extras=getIntent().getExtras();
            if(extras!=null){


                nom=extras.getString("nom");
                prenom=extras.getString("prenom");
                map=new HashMap<String,String>();
                map.put("nom",nom);
                map.put("prenom",prenom);
                p.values.add(map);

            }

        SimpleAdapter adapter=new SimpleAdapter(ContactActivity.this,p.values,R.layout.item,
                new String[]{"nom","prenom"},new int[]{R.id.nom,R.id.prenom});
            ls.setAdapter(adapter);
            ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    Intent i=new Intent(getApplicationContext(),DetailActivity.class);
                    i.putExtra("position",position);
                    startActivity(i);

                }


            });

        ajout.setOnClickListener((v)-> {
            Intent i= new Intent(getApplicationContext(),MainActivity.class);
            startActivity(i);
        });
    }
}