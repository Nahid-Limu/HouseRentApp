package com.example.nahid.houserent.service;

import com.example.nahid.houserent.model.LoginModel;
import com.example.nahid.houserent.model.PostModel;
import com.example.nahid.houserent.model.RegModel;
import com.example.nahid.houserent.model.UserModel;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Nahid on 30-Jul-17.
 */

public interface ApiService {

    @GET("api_ads.php")
    Call<List<UserModel>> getUserData();

    @POST("reg_api.php")
    @FormUrlEncoded
    Call<RegModel> getRegData(@Field("name") String name, @Field("pass") String pass, @Field("phn") String phn);

    @POST("login_api.php")
    @FormUrlEncoded
    Call<LoginModel> getLoginData(@Field("name") String name, @Field("pass") String pass);

    @POST("addPost_api.php")
    @FormUrlEncoded
    Call<PostModel> getPostData(@Field("type") String type, @Field("rent") String rent,@Field("details") String details, @Field("phn") String phn,@Field("address") String address, @Field("date") String date);
}