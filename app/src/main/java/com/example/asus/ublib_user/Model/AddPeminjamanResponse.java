package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AddPeminjamanResponse {

    @SerializedName("success")
    @Expose
    private AddPeminjamanResource addPeminjamanResource;

    public AddPeminjamanResource getSuccess() {
        return addPeminjamanResource;
    }

    public void setSuccess(AddPeminjamanResource addPeminjamanResource) {
        this.addPeminjamanResource = addPeminjamanResource;
    }
}
