package com.essths.android.config;

/**
 * Created by asus on 04/03/2018.
 */

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ConfigRetrofit {
    public static Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.43.78:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
