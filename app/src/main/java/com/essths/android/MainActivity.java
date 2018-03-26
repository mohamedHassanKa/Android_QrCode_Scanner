package com.essths.android;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.essths.android.config.ConfigRetrofit;
import com.essths.android.model.User;

import java.util.List;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    AnimationDrawable animationDrawable;
    RelativeLayout relativeLayout;
    private EditText l;
    private EditText psw;

    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        animationDrawable = (AnimationDrawable) relativeLayout.getBackground();
        animationDrawable.setEnterFadeDuration(5000);
        animationDrawable.setExitFadeDuration(2000);
        btn= (Button) findViewById(R.id.login);
        l = (EditText) findViewById(R.id.email);
        psw = (EditText) findViewById(R.id.pass);



        Button log = findViewById(R.id.login) ;
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= l.getText().toString();
                String pass = psw.getText().toString();

                if (!email.equals("") && !pass.equals("") ) {

                    IUser IUser = ConfigRetrofit.retrofit.create(IUser.class);
                    retrofit2.Call<User>call = IUser.login(email,pass);

                    call.enqueue(new Callback<User>() {

                        @Override
                        public void onResponse(retrofit2.Call<User> call, Response<User> response) {
                            if (response.body()!=null){
                                Toast.makeText(MainActivity.this, "Login effectué", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                                intent.putExtra("key",response.body()) ;
                                startActivity(intent);
                            }
                            else {
                                l.setError("Email Invalid");
                                psw.setError("pass Invalid");
                            }

                        }

                        @Override
                        public void onFailure(retrofit2.Call<User> call, Throwable t) {

                        }
                    });
                }

            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationDrawable != null && !animationDrawable.isRunning())
            animationDrawable.start();
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationDrawable != null && animationDrawable.isRunning())
            animationDrawable.stop();
    }
}