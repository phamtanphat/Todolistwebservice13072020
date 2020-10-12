package com.example.todolistwebservice13072020.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInit {
    private static RetrofitInit mInstance = null;
    private static Retrofit mRetrofit;

    private RetrofitInit(){
        mRetrofit = createRetrofit();
    }
    public static ApiRequest getInstance(){
        if (mInstance == null){
            mInstance = new RetrofitInit();
        }
        return mRetrofit.create(ApiRequest.class);
    }
    public Retrofit createRetrofit(){
        // OkHttpClient
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(30, TimeUnit.SECONDS)
                .connectTimeout(30,TimeUnit.SECONDS)
                .writeTimeout(30 , TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();

        // Khởi tạo gson
        Gson gson = new GsonBuilder().setLenient().create();
        // 1 : Khởi tạo retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://phat0206.000webhostapp.com/")
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit;
    }
}
