package com.example.asus.ublib_user.Interface;

import com.example.asus.ublib_user.Model.AddPeminjamanResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddPeminjamanInterface {

    @FormUrlEncoded
    @POST("tambah_peminjaman")
    Call<AddPeminjamanResponse> tambahPeminjaman(@Field("nama") String nama,
                                                  @Field("nim") String nim,
                                                  @Field("judul") String judul,
                                                  @Field("pengarang") String pengarang,
                                                  @Field("tgl_peminjaman") String tgl_peminjaman,
                                                  @Field("tgl_pengembalian") String tgl_pengembalian,
                                                  @Field("user_id") String user_id,
                                                  @Field("admin_id") String admin_id,
                                                  @Field("buku_id") String buku_id);
}
