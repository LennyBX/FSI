package com.example.fsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AccueilActivity extends AppCompatActivity {

    Button btninfos;
    Button btnotes;
    Button btndeco;
    TextView pseudo;
    Eleve eleve;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_accueil);

        btninfos = (Button)  findViewById(R.id.btninfos);
        btnotes = (Button)  findViewById(R.id.btnotes);
        btndeco = (Button)  findViewById(R.id.btndeco);

        pseudo = findViewById(R.id.pseudo);
        if(getIntent().hasExtra("compte")){

            eleve = (Eleve) getIntent().getSerializableExtra("compte");
            pseudo.setText(eleve.getLOG_ETU());

        }




        btninfos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_app = new Intent(AccueilActivity.this, InfoActivity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });

        btnotes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_app = new Intent(AccueilActivity.this, NoteActivity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });


        btndeco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}