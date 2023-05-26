package com.example.fsi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFsi_bilan1 {

    @GET("api_bilan1")
    Call<Bilan_1> getbilan1(@Query("id") Integer id);
}
