package com.essths.android;

/**
 * Created by asus on 12/03/2018.
 */

import com.essths.android.model.ticket;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by asus on 04/03/2018.
 */

public interface Iticket {
    @GET("tickets/searching")
    Call<List<ticket>> all(@Query("id") String id) ;
    @GET("tickets/find")
    Call<ticket> find(@Query("id") String id) ;
}