package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class FilterResponse {

    @SerializedName("success")
    @Expose
    private List<FilterResource> filterResources = null;

    public List<FilterResource> getSuccess() {
        return filterResources;
    }

    public void setSuccess(List<FilterResource> filterResources) {
        this.filterResources = filterResources;
    }
}
