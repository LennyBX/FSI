package com.example.fsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bilan1Activity extends AppCompatActivity {

    Button button3;
    Bilan_1 bilan1;
    Eleve eleve;
    TextView  or, ds,en,rm,dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilan1);

        button3 = (Button)  findViewById(R.id.button3);

        or = findViewById(R.id.or);
        ds = findViewById(R.id.ds);
        en = findViewById(R.id.en);
        rm = findViewById(R.id.rm);
        dt = findViewById(R.id.dt);


        if(getIntent().hasExtra("compte")){

            eleve = (Eleve) getIntent().getSerializableExtra("compte");

        }
        processData();


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i_app = new Intent(Bilan1Activity.this, NoteActivity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });
    }

    private void processData() {
        Call<Bilan_1> call = ControllerApi
                .getInstance()
                .bilan1()
                .getbilan1(eleve.getID_ETU());

        call.enqueue(new Callback<Bilan_1>() {
            @Override
            public void onResponse(Call<Bilan_1> call, Response<Bilan_1> response) {
                bilan1 = response.body();

                or.setText(String.valueOf(bilan1.getNOT_ORA_NOT()));
                ds.setText(String.valueOf(bilan1.getNOT_DOS_NOT()));
                en.setText(String.valueOf(bilan1.getNOT_ENT_NOT()));
                rm.setText(bilan1.getREM_NOT_BIL_1());
                dt.setText(String.valueOf(bilan1.getDAT_BIL_1()));


            }

            @Override
            public void onFailure(Call<Bilan_1> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }


        });
    }


}