package com.example.todolistwebservice13072020.repository;

import com.example.todolistwebservice13072020.api.ApiRequest;
import com.example.todolistwebservice13072020.api.RetrofitInit;
import com.example.todolistwebservice13072020.model.Word;

import java.util.List;

import io.reactivex.Maybe;
import retrofit2.Response;

public class WordRepository {
    private static WordRepository mInstance = null;
    private ApiRequest mApiRequest;

    private WordRepository(){
        mApiRequest = RetrofitInit.getInstance();
    }

    public static WordRepository getInstance(){
        if (mInstance == null){
            mInstance = new WordRepository();
        }
        return mInstance;
    }
    public Maybe<Response<List<Word>>> getWordFormPage(Integer page , Integer numItems){
        return  mApiRequest.getWordFormPage(page , numItems);
    }
}
