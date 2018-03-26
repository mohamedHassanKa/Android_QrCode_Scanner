package com.essths.android;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.essths.android.config.ConfigRetrofit;
import com.essths.android.model.Customer;
import com.essths.android.model.ticket;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QrticketScanActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qrticket_scan);
        final Activity activity = this;
        IntentIntegrator integrator = new IntentIntegrator(activity);
        integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
        integrator.setPrompt("Scan");
        integrator.setCameraId(0);
        integrator.setBeepEnabled(false);
        integrator.setBarcodeImageEnabled(false);
        integrator.initiateScan();
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null){
            if(result.getContents()==null){
                Toast.makeText(this, "You cancelled the scanning", Toast.LENGTH_LONG).show();
            }
            else {

                Iticket Iticket = ConfigRetrofit.retrofit.create(Iticket.class);
                retrofit2.Call<ticket>call = Iticket.find(result.getContents());


                call.enqueue(new Callback<ticket>() {
                    @Override
                    public void onResponse(Call<ticket> call, Response<ticket> response) {
                        if (response.body()!=null){
                            Intent intent = new Intent(QrticketScanActivity.this,TicketInformationActivity.class);
                            intent.putExtra("key",response.body().getId()) ;
                            startActivity(intent);
                        }
                        else
                        {
                            Intent intent = new Intent(QrticketScanActivity.this,errorActivity.class);
                            startActivity(intent);
                        }

                    }


                    @Override
                    public void onFailure(Call<ticket>call, Throwable t) {
                        Toast.makeText(QrticketScanActivity.this,t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
