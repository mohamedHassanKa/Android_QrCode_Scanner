package com.essths.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.essths.android.config.ConfigRetrofit;
import com.essths.android.model.Customer;

import java.io.InputStream;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class profilActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        final Intent intent = getIntent();
        Bundle bd = intent.getExtras();
       final String id = (String) bd.get("key");
        Button profil = findViewById(R.id.profil);
        profil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1= new Intent(profilActivity.this,TicketInfoActivity.class);
                intent1.putExtra("key",id) ;
                startActivity(intent1);
            }
        });

        ICustomer ICustomer = ConfigRetrofit.retrofit.create(ICustomer.class);
        retrofit2.Call<Customer>call = ICustomer.find(id);
        call.enqueue(new Callback<Customer>() {
            @Override
            public void onResponse(Call<Customer> call, Response<Customer> response) {
                if (response.body()!=null){
                    new DownloadImageTask((ImageView) findViewById(R.id.imageView5))
                            .execute(response.body().getImgUrl());
                    TextView nom_prenom = findViewById(R.id.tv_name);
                    nom_prenom.setText(response.body().getName()+" "+response.body().getPrenom());
                    TextView tv_address = findViewById(R.id.tv_address);
                    tv_address.setText(response.body().getPay()+", "+response.body().getState());
                    TextView tel = findViewById(R.id.tel);
                    tel.setText("+216 "+response.body().getTel());
                    TextView email = findViewById(R.id.email);
                    email.setText(response.body().getEmail());
                    TextView birth = findViewById(R.id.birth);
                    birth.setText(response.body().getDateNaiss());
                    TextView update = findViewById(R.id.update);
                    update.setText(response.body().getUpdatedDate());


                }
                else
                {

                }

            }


            @Override
            public void onFailure(Call<Customer>call, Throwable t) {
                Toast.makeText(profilActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

    }
    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView imageView5;

        public DownloadImageTask(ImageView bmImage) {
            this.imageView5 = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            imageView5.setImageBitmap(result);
        }
    }
}
