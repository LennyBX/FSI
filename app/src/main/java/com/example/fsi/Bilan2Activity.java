package com.example.fsi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Bilan2Activity extends AppCompatActivity {

    Eleve eleve;
    Bilan_2 bilan2;
    Button button3;
    TextView or, ds,en,rm,dt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bilan2);

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

                Intent i_app = new Intent(Bilan2Activity.this, NoteActivity.class);
                i_app.putExtra("compte", (Eleve) eleve);
                startActivity(i_app);
            }
        });
    }

    private void processData() {
        Call<Bilan_2> call = ControllerApi
                .getInstance()
                .bilan2()
                .getbilan2(eleve.getID_ETU());

        call.enqueue(new Callback<Bilan_2>() {
            @Override
            public void onResponse(Call<Bilan_2> call, Response<Bilan_2> response) {
                bilan2 = response.body();

                or.setText(String.valueOf(bilan2.getNOT_ORA_BIL_2()));
                ds.setText(String.valueOf(bilan2.getNOT_DOS_BIL_2()));
                en.setText(String.valueOf(bilan2.getNOT_ENT_NOT_BIL_2()));
                rm.setText(bilan2.getREM_NOT_BIL_2());
                dt.setText(String.valueOf(bilan2.getDAT_NOT_BIL_2()));


            }

            @Override
            public void onFailure(Call<Bilan_2> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }


        });
    }




}