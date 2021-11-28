package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.HistoryResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface HistoryInterface {

    @GET("tampil_history_peminjaman/{id}")
    Call<HistoryResponse> history(@Path("id") String id);
}
