package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PeminjamanResource {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("judul")
    @Expose
    private String judul;
    @SerializedName("pengarang")
    @Expose
    private String pengarang;
    @SerializedName("status_peminjaman")
    @Expose
    private String statusPeminjaman;
    @SerializedName("jenis")
    @Expose
    private String jenis;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("tgl_peminjaman")
    @Expose
    private String tglPeminjaman;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("user_id")
    @Expose
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getStatusPeminjaman() {
        return statusPeminjaman;
    }

    public void setStatusPeminjaman(String statusPeminjaman) {
        this.statusPeminjaman = statusPeminjaman;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTglPeminjaman() {
        return tglPeminjaman;
    }

    public void setTglPeminjaman(String tglPeminjaman) {
        this.tglPeminjaman = tglPeminjaman;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
