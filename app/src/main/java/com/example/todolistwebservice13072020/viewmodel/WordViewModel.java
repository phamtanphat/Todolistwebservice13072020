package com.example.todolistwebservice13072020.viewmodel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.todolistwebservice13072020.model.Response;
import com.example.todolistwebservice13072020.model.Word;
import com.example.todolistwebservice13072020.repository.WordRepository;

import java.util.List;

import io.reactivex.MaybeObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class WordViewModel extends ViewModel {
    private MutableLiveData<Response<List<Word>>> mResponseWordFormPage;
    private MutableLiveData<Response<List<Word>>> mResponseInsertWord;
    private WordRepository mWordRepository;

    public WordViewModel() {
        mResponseWordFormPage = new MutableLiveData<>();
        mResponseInsertWord = new MutableLiveData<>();
        mWordRepository = WordRepository.getInstance();
    }

    public void callWordFromPage(Integer page , Integer numItems){
        mWordRepository.getWordFromPage(page,numItems)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Response<List<Word>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<Word>> listResponse) {
                        mResponseWordFormPage.setValue(listResponse);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public LiveData<Response<List<Word>>> getWordsFromPage(){
        return mResponseWordFormPage;
    }
    public void callInsertWord(Word word){
        mWordRepository.insertWord(word)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new MaybeObserver<Response<List<Word>>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onSuccess(Response<List<Word>> listResponse) {
                        mResponseInsertWord.setValue(listResponse);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("BBB",e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    public LiveData<Response<List<Word>>> getWordInsertSuccess(){
        return mResponseInsertWord;
    }
}
