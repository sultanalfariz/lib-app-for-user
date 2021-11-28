package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.RegisterResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RegisterInterface {

    @FormUrlEncoded
    @POST("register_user")
    Call<RegisterResponse> register(@Field("nim") String nim,
                                    @Field("nama") String nama,
                                    @Field("fakultas") String fakultas,
                                    @Field("prodi") String prodi,
                                    @Field("password") String password);

}
