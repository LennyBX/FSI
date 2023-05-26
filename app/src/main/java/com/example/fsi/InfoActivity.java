package com.example.fsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InfoActivity extends AppCompatActivity {

    Button button3;
    Eleve eleve;
    TextView nom, prenom,classe,spe,tel,mail, adresse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        nom = findViewById(R.id.nom);
        prenom = findViewById(R.id.prenom);
        classe = findViewById(R.id.classe);
        spe = findViewById(R.id.spe);
        tel = findViewById(R.id.tel);
        mail = findViewById(R.id.mail);
        adresse = findViewById(R.id.adresse);


        if(getIntent().hasExtra("compte")){

            eleve = (Eleve) getIntent().getSerializableExtra("compte");
            nom.setText(eleve.getNOM_ETU());
            prenom.setText(eleve.getPRE_ETU());
            classe.setText(eleve.getCLA_ETU());
            spe.setText(eleve.getSPE_ETU());
            tel.setText(String.valueOf(eleve.getTEL_ETU()));
            mail.setText(eleve.getMAI_ETU());
            adresse.setText(eleve.getVIL_ETU());


        }

        button3 = (Button)  findViewById(R.id.button3);



        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i_app = new Intent(InfoActivity.this, AccueilActivity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });
    }
}