package com.example.asus.ublib_user.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class HistoryResponse {

    @SerializedName("success")
    @Expose
    private List<HistoryResource> historyResources = null;

    public List<HistoryResource> getSuccess() {
        return historyResources;
    }

    public void setSuccess(List<HistoryResource> historyResources) {
        this.historyResources = historyResources;
    }
}
