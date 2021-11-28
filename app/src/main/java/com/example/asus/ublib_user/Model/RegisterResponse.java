package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RegisterResponse {

    @SerializedName("success")
    @Expose
    private RegisterResource registerResource;

    public RegisterResource getSuccess() {
        return registerResource;
    }

    public void setSuccess(RegisterResource registerResource) {
        this.registerResource = registerResource;
    }

}
