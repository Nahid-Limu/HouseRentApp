package com.example.nahid.houserent.model;

/**
 * Created by Nahid on 29-Jul-17.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserModel {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("rent")
    @Expose
    private String rent;
    @SerializedName("details")
    @Expose
    private String details;
    @SerializedName("phone")
    @Expose
    private String phone;
    @SerializedName("date")
    @Expose
    private String date;

    /**
     * No args constructor for use in serialization
     *
     */
    public UserModel() {
    }

    /**
     *
     * @param id
     * @param phone
     * @param details
     * @param rent
     * @param date
     * @param type
     */
    public UserModel(String id, String type, String rent, String details, String phone, String date) {
        super();
        this.id = id;
        this.type = type;
        this.rent = rent;
        this.details = details;
        this.phone = phone;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}