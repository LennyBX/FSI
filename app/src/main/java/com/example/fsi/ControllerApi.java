package com.example.fsi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ControllerApi {

    private static String url = "https://olen-ort.fr/P2023/SIO/BONDOUX/phpmaster/src/view/";

    private static ControllerApi apicontroller;

    private static Retrofit retrofit;

    Gson gson = new GsonBuilder()
            .setLenient()
            .create();

    ControllerApi(){
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    public static synchronized ControllerApi getInstance(){
        if (apicontroller == null){
            apicontroller = new ControllerApi();
        }
        return apicontroller;
    }

    public ApiFsi getApiRead(){
        return retrofit.create(ApiFsi.class);
    }


    public ApiConnexion connexion(){
        return retrofit.create(ApiConnexion.class);
    }

    public ApiFsi_bilan1 bilan1(){
        return retrofit.create(ApiFsi_bilan1.class);
    }

    public ApiFsi_bilan2 bilan2(){
        return retrofit.create(ApiFsi_bilan2.class);
    }

}
