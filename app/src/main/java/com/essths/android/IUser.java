package com.essths.android;

import com.essths.android.model.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by asus on 04/03/2018.
 */

public interface IUser {
    @GET("user/all")
    Call<List<User>> all() ;
    @GET("user/log")
    Call<User> login(@Query("email") String email, @Query("pass") String pass) ;
    @GET("user/find")
    Call<User> find(@Query("id") String id) ;
}
