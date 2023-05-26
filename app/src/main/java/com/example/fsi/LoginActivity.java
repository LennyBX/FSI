package com.example.fsi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText username,password;
    Button btnlogin;
    Bilan_1 bilan1;
    Eleve eleve;
    private SQLiteDatabase database;
    private Context context1;
    DBHelper DB = new DBHelper(this, database, context1);
    public ArrayList<Eleve> eleves = new ArrayList<Eleve>();
    public Bilan_1 bilans1;
    public Bilan_2 bilans2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username2);
        password = (EditText) findViewById(R.id.password2);
        btnlogin = (Button)  findViewById(R.id.btnlogin);
        DB.createTable("Etudiant");
        DB.createTable2("Bilan_1");
        DB.createTable3("Bilan_2");
        processeleve();




        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getText().toString();
                String pass = password.getText().toString();


                Call<Eleve> call = ControllerApi
                        .getInstance()
                        .connexion()
                        .verifyLogin(user,pass);

                call.enqueue(new Callback<Eleve>() {
                    @Override
                    public void onResponse(Call<Eleve> call, Response<Eleve> response) {

                        eleve = response.body();


                        if( eleve != null && eleve.getID_ETU() >0){
                            processData();
                            processData2();
                            Intent i_app = new Intent(LoginActivity.this, AccueilActivity.class);
                            i_app.putExtra("compte", (Eleve) eleve);
                            startActivity(i_app);
                        }

                    }

                    @Override
                    public void onFailure(Call<Eleve> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                        System.out.println(t.toString());
                    }

                });


            }
        });

    }









    private void processeleve() {
        Call<ArrayList<Eleve>> call = ControllerApi
                .getInstance()
                .getApiRead()
                .getData();

        call.enqueue(new Callback<ArrayList<Eleve>>() {


            @Override
            public void onResponse(Call<ArrayList<Eleve>> call, Response<ArrayList<Eleve>> response) {
                eleves = response.body();
                DB.createTable("Etudiant");

                for (Eleve el : eleves
                ) {
                    DB.insertData_etu(el.getNOM_ETU(), el.getPRE_ETU(), el.getCLA_ETU(), el.getSPE_ETU(), el.getLOG_ETU(), el.getMDP_ETU(), el.getCP_ETU().toString(), el.getRUE_ETU(), el.getVIL_ETU(),
                            el.getMAI_ETU(), el.getTEL_ETU().toString());
                }
            }

            @Override
            public void onFailure(Call<ArrayList<Eleve>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();

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
                bilan1= response.body();

                DB.insertBilan_1(bilan1.getDAT_BIL_1().toString(), bilan1.getREM_NOT_BIL_1(), Float.toString(bilan1.getNOT_ORA_NOT()), Float.toString(bilan1.getNOT_ENT_NOT()), Float.toString(bilan1.getNOT_DOS_NOT()));
            }

            @Override
            public void onFailure(Call<Bilan_1> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }
        });
    }


    private void processData2() {
        Call<Bilan_2> call = ControllerApi
                .getInstance()
                .bilan2()
                .getbilan2(eleve.getID_ETU());

        call.enqueue(new Callback<Bilan_2>() {
            @Override
            public void onResponse(Call<Bilan_2> call, Response<Bilan_2> response) {
                bilans2 = response.body();

                DB.insertBilan_2(bilans2.getDAT_NOT_BIL_2().toString(), bilans2.getREM_NOT_BIL_2(), Float.toString(bilans2.getNOT_ORA_BIL_2()), Float.toString(bilans2.getNOT_ENT_NOT_BIL_2()), Float.toString(bilans2.getNOT_DOS_BIL_2()));
            }

            @Override
            public void onFailure(Call<Bilan_2> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.toString(), Toast.LENGTH_LONG).show();
                System.out.println(t.toString());
            }
        });
    }


}