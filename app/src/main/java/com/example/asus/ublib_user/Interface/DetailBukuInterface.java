package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.DetailResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface DetailBukuInterface {

    @GET("detail_buku/{id}")
    Call<DetailResponse> detail(@Path("id") String id);
}
