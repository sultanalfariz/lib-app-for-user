package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddPeminjamanResource extends AddPeminjamanResponse{

    @SerializedName("tgl_peminjaman")
    @Expose
    private String tglPeminjaman;

    public String getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(String tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }
}
