package com.example.nahid.houserent.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by nahid on 13-Aug-17.
 */

public class PostModel {

    @SerializedName("post_status")
    @Expose
    private String postStatus;

    public String getPostStatus() {
        return postStatus;
    }

    public void setPostStatus(String postStatus) {
        this.postStatus = postStatus;
    }
}
