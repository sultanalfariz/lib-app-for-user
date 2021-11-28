package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ValidasiResponse {

    @SerializedName("success")
    @Expose
    private List<ValidasiResource> validasiResources = null;

    public List<ValidasiResource> getSuccess() {
        return validasiResources;
    }

    public void setSuccess(List<ValidasiResource> validasiResources) {
        this.validasiResources = validasiResources;
    }
}
