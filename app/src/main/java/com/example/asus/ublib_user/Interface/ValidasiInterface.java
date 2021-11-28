package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.ValidasiResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ValidasiInterface {

    @GET("detail_peminjaman/{id}")
    Call<ValidasiResponse> detailVal(@Path("id") String id);
}
