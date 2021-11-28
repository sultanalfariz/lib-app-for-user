package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.PeminjamanResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListPeminjamanInterface {

    @GET("tampil_peminjaman_diproses_user/{id}")
    Call<PeminjamanResponse> peminjaman(@Path("id") String id);
}
