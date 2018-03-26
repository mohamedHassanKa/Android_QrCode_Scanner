package com.essths.android;

import com.essths.android.model.Customer;
import com.essths.android.model.User;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by asus on 08/03/2018.
 */

public interface ICustomer {
    @GET("customer/search")
    Call<Customer> find(@Query("id") String id) ;
}
