package com.example.tes20april;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    TextView dokterLogin;
    SharedPreferences mSetting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dokterLogin = findViewById(R.id.dokterLogin);
        mSetting = this.getSharedPreferences("dokterid", Context.MODE_PRIVATE);


        if(!mSetting.getString("dokterid", "invalid").equals("invalid")){
            Intent i = new Intent(getApplicationContext(), HomeContainer.class);
            startActivity(i);
            finish();
        }

    }

    public void goLogin(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(Api.BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        Api api = retrofit.create(Api.class);

        Log.d("tes", "goLogin: "+dokterLogin.getText().toString());
        String idDokter = dokterLogin.getText().toString();


        Call<DokterReqRes> call = api.goLogin(new DokterReqRes(idDokter));
        call.enqueue(new Callback<DokterReqRes>() {
            @Override
            public void onResponse(Call<DokterReqRes> call, Response<DokterReqRes> response) {
                DokterReqRes res = response.body();

                Toast.makeText(getApplicationContext(), "ahoy", Toast.LENGTH_SHORT);

                if(res.loginstatus.equals("success")){
                    mSetting.edit().putString("dokterid", res.id).apply();


                    Intent i = new Intent(getApplicationContext(), HomeContainer.class);
                    startActivity(i);
                    finish();
                }
            }

            @Override
            public void onFailure(Call<DokterReqRes> call, Throwable t) {

            }
        });


    }
}
