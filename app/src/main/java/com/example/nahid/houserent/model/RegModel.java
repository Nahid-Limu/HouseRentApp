package com.example.nahid.houserent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nahid on 13-Aug-17.
 */

public class RegModel {


    @SerializedName("reg_status")
    @Expose
    private String regStatus;

    public String getRegStatus() {
        return regStatus;
    }

    public void setRegStatus(String regStatus) {
        this.regStatus = regStatus;
    }
}
