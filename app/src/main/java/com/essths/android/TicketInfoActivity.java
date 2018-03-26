package com.essths.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.essths.android.config.ConfigRetrofit;
import com.essths.android.model.ticket;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_info);
        final Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        final String id = (String) bd.get("key");
        Iticket Iticket = ConfigRetrofit.retrofit.create(Iticket.class);
        retrofit2.Call<List<ticket>>call = Iticket.all(id);
        call.enqueue(new Callback<List<ticket>>() {
            @Override
            public void onResponse(Call<List<ticket>> call, Response<List<ticket>> response) {
                List<ticket> TicketList= new ArrayList<>() ;

                for (ticket ticket:response.body()){
                    TicketList.add(new ticket(ticket.getSujet(),ticket.getDate(),ticket.getPlace()));
                }
                ListView list = findViewById(R.id.list) ;
                customList adapter = new customList(TicketInfoActivity.this, R.layout.mylist, TicketList);
                list.setAdapter(adapter);


            }


            @Override
            public void onFailure(Call<List<ticket>> call, Throwable t) {
                Toast.makeText(TicketInfoActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
