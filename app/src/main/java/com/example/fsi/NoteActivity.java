package com.example.fsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NoteActivity extends AppCompatActivity {


    Button button3;

    Button btnbilan1;

    Button btnbilan2;
    Eleve eleve;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);

        button3 = (Button)  findViewById(R.id.button3);
        btnbilan1 = (Button)  findViewById(R.id.btnbilan1);
        btnbilan2 = (Button)  findViewById(R.id.btnbilan2);

        if(getIntent().hasExtra("compte")){

            eleve = (Eleve) getIntent().getSerializableExtra("compte");

        }

        btnbilan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_app = new Intent(NoteActivity.this, Bilan1Activity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i_app = new Intent(NoteActivity.this, AccueilActivity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });

        btnbilan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent i_app = new Intent(NoteActivity.this, Bilan2Activity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });






    }
}