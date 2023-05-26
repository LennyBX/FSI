package com.example.fsi;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiFsi_bilan2 {

    @GET("api_bilan2")
    Call<Bilan_2> getbilan2(@Query("id") Integer id);
}
