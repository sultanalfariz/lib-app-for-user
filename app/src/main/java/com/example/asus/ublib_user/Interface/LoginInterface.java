package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginInterface {

    @FormUrlEncoded
    @POST("login_user")
    Call<LoginResponse> login(@Field("nim") String nim,
                              @Field("password") String password);

}
