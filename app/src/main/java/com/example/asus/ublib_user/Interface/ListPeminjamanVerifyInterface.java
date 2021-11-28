package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.PeminjamanVerifyResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ListPeminjamanVerifyInterface {

    @GET("tampil_peminjaman_berjalan_user/{id}")
    Call<PeminjamanVerifyResponse> peminjamanVerify(@Path("id") String id);
}
