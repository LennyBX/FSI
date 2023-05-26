package com.example.fsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Api extends AppCompatActivity {

    private RecyclerView rcapi;
    private Rvapi rvapi;
    private ApiFsi apifsi;
    private ArrayList<Eleve> etudiants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api);


        rcapi = (RecyclerView)  findViewById(R.id.rcapi);

        etudiants = new ArrayList<>();

        processData();

    }


    private void processData() {
        Call<ArrayList<Eleve>> call = ControllerApi
                .getInstance()
                .getApiRead()
                .getData();

        call.enqueue(new Callback<ArrayList<Eleve>>() {
            @Override
            public void onResponse(Call<ArrayList<Eleve>> call, Response<ArrayList<Eleve>> response) {
                etudiants = response.body();

                rcapi.setHasFixedSize(true);
                LinearLayoutManager manager = new LinearLayoutManager(Api.this);
                rcapi.setLayoutManager(manager);
                rvapi = new Rvapi(Api.this, etudiants);
                rcapi.setAdapter(rvapi);
                rvapi.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Eleve>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }

        });
    }



}