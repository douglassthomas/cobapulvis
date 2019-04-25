package com.example.tes20april;

import com.google.gson.annotations.SerializedName;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

class DokterReqRes{

    @SerializedName("id")public String id;
    @SerializedName("loginstatus") public String loginstatus;
    @SerializedName("specialistId") public String specialistId;
    @SerializedName("phoneNumber") public String phoneNumber;
    @SerializedName("name") public String name;
    @SerializedName("profileUrl") public String profileUrl;

    public DokterReqRes(String idDokter) {
        this.id = idDokter;
    }
}



public interface Api {

    String BASE_URL = "http://kentang.binusian.id:3000/";
//    String BASE_URL = "https://storiette-api.azurewebsites.net/";

    @POST("doctorLogin") //doctorLogin
    Call<DokterReqRes> goLogin(@Body DokterReqRes login);


}
