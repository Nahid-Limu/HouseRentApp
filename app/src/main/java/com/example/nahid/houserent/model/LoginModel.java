package com.example.nahid.houserent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nahid on 13-Aug-17.
 */

public class LoginModel {



    @SerializedName("login_status")
    @Expose
    private String loginStatus;

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus;
    }
}
