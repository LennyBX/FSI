package com.example.fsi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiConnexion {

    @FormUrlEncoded
    @POST("connexionapi.php")
    Call<Eleve> verifyLogin(@Field("login") String login,@Field("mdp") String mdp);
}
