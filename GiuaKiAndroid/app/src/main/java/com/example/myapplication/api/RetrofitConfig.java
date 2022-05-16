package com.example.myapplication.api;

import com.example.myapplication.model.Account;
import com.example.myapplication.model.Infor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RetrofitConfig {
    Gson gson = new GsonBuilder().setLenient().create();
    RetrofitConfig retrofit = new Retrofit.Builder()
            .baseUrl("http://192.168.43.112/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(RetrofitConfig.class);

    @FormUrlEncoded
    @POST("android/register.php")
    Call<String> register(@Field("username") String username, @Field("password") String password);

    @POST("android/login.php")
    Call<ArrayList<Account>> login();

    @POST("android/get_infor.php")
    Call<ArrayList<Infor>> getinfor();

    @FormUrlEncoded
    @POST("android/delete_infor.php")
    Call<String> detelte_infor(@Field("id") int id);

    @FormUrlEncoded
    @POST("android/insert_infor.php")
    Call<String> insert_infor(@Field("name") String name,
                              @Field("email") String email,
                              @Field("contact") String contact,
                              @Field("address") String address);

    @FormUrlEncoded
    @POST("android/edit_infor.php")
    Call<String> edit(        @Field("name") String name,
                              @Field("email") String email,
                              @Field("contact") String contact,
                              @Field("address") String address,
                              @Field("id") int id);
}