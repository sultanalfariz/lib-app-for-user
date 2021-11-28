package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HistoryResource {

    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("pengarang")
    @Expose
    private String pengarang;
    @SerializedName("tgl_pengembalian")
    @Expose
    private String tglPengembalian;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getPengarang() {
        return pengarang;
    }

    public void setPengarang(String pengarang) {
        this.pengarang = pengarang;
    }

    public String getTglPengembalian() {
        return tglPengembalian;
    }

    public void setTglPengembalian(String tglPengembalian) {
        this.tglPengembalian = tglPengembalian;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
