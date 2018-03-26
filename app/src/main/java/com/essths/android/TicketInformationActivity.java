package com.essths.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.essths.android.config.ConfigRetrofit;
import com.essths.android.model.ticket;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TicketInformationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket_information);
        final Intent intent = getIntent();
        Bundle bd = intent.getExtras();
        final String id = (String) bd.get("key");
        Toast.makeText(TicketInformationActivity.this,id+"",Toast.LENGTH_SHORT).show();
        ImageView image = (ImageView) findViewById(R.id.image);
        TextView textView9  =findViewById(R.id.textView9);
        textView9.setText(id);
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(id, BarcodeFormat.QR_CODE,300,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            image.setImageBitmap(bitmap);
        }
        catch (WriterException e){
            e.printStackTrace();
        }
        Iticket Iticket = ConfigRetrofit.retrofit.create(Iticket.class);
        retrofit2.Call<ticket>call = Iticket.find(id);


        call.enqueue(new Callback<ticket>() {
            @Override
            public void onResponse(Call<ticket> call, Response<ticket> response) {
                if (response.body()!=null){
                    TextView title  =findViewById(R.id.textView13);
                    TextView description  =findViewById(R.id.textView16);
                    TextView date  =findViewById(R.id.datee);
                    TextView place  =findViewById(R.id.placee);
                    TextView price  =findViewById(R.id.pricee);
                    title.setText(response.body().getSujet());
                    description.setText(response.body().getDescription());
                    date.setText(response.body().getDate());
                    place.setText(response.body().getPlace());
                    price.setText(response.body().getPrice());

                }
                else
                {
                    Intent intent = new Intent(TicketInformationActivity.this,errorActivity.class);
                    startActivity(intent);
                }

            }


            @Override
            public void onFailure(Call<ticket>call, Throwable t) {
                Toast.makeText(TicketInformationActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
