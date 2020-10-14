package com.example.todolistwebservice13072020.api;

import com.example.todolistwebservice13072020.model.Response;
import com.example.todolistwebservice13072020.model.Word;

import java.util.List;

import io.reactivex.Maybe;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("apituvung/word.php")
    Maybe<Response<List<Word>>> getWordFromPage(
            @Query("page") Integer page ,
            @Query("numItems") Integer numItems
    );

    @POST("apituvung/insert.php")
    @FormUrlEncoded
    Maybe<Response<List<Word>>> insertWord(@Field("en") String en , @Field("vn") String vn , @Field("ismemorized") Integer ismemorized);

    @POST("apituvung/update.php")
    @FormUrlEncoded
    Maybe<Response<List<Word>>> upDateWord(@Field("id") String id ,  @Field("ismemorized") Integer ismemorized);


    @POST("apituvung/delete.php")
    @FormUrlEncoded
    Maybe<Response<List<Word>>> deleteWord(@Field("id") String id );

}
