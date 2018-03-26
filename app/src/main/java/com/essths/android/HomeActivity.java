package com.essths.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    LinearLayout l1,l2;
    Button btnsub,btnticket;
    Animation uptodown,downtoup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        btnsub = (Button)findViewById(R.id.buttonsubscriber);
        btnticket = findViewById(R.id.buttonticket);
        l1 = (LinearLayout) findViewById(R.id.l1);
        l2 = (LinearLayout) findViewById(R.id.l2);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        l1.setAnimation(uptodown);
        l2.setAnimation(downtoup);
        btnticket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,QrticketScanActivity.class);
                startActivity(intent);
            }
        });
        btnsub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,QrCustomerScan.class);
                startActivity(intent);
            }
        });

    }
}
