package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.FilterResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface FilterBukuInterface {

    @GET("filter_jenis/{jenis}")
    Call<FilterResponse> filterJenis(@Path("jenis") String jenis);
}
