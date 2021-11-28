package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.ListBukuResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ListBukuInterface {

    @GET("tampil_buku")
    Call<ListBukuResponse> buku();
}
