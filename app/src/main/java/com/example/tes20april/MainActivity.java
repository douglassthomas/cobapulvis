package com.example.tes20april;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dokterLogin = findViewById(R.id.dokterLogin);
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
                    LocalStorage.setId(res.id);


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
