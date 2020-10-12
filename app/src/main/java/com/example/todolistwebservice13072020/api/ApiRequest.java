package com.example.todolistwebservice13072020.api;

import com.example.todolistwebservice13072020.model.Response;
import com.example.todolistwebservice13072020.model.Word;

import java.util.List;

import io.reactivex.Maybe;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiRequest {

    @GET("apituvung/word.php")
    Maybe<Response<List<Word>>> getWordFromPage(
            @Query("page") Integer page ,
            @Query("numItems") Integer numItems
    );
}
