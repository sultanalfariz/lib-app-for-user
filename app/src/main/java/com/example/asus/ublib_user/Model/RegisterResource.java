package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResource extends RegisterResponse {

    @SerializedName("nim")
    @Expose
    private String nim;

    public String getNim() {
        return nim;
    }

    public void setNim(String nim) {
        this.nim = nim;
    }

}
