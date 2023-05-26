package com.example.fsi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFsi {


    @GET("api_etudiant")
    Call<ArrayList<Eleve>> getData();


}
