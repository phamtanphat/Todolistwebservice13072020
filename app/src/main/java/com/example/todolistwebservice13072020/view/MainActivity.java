package com.example.todolistwebservice13072020.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import com.example.todolistwebservice13072020.R;
import com.example.todolistwebservice13072020.model.Response;
import com.example.todolistwebservice13072020.model.Word;
import com.example.todolistwebservice13072020.viewmodel.WordViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WordViewModel mWordViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWordViewModel = new WordViewModel();

        mWordViewModel.getWordsFromPage().observe(this, new Observer<Response<List<Word>>>() {
            @Override
            public void onChanged(Response<List<Word>> listResponse) {
                Log.d("BBB",listResponse.getData().size() + "");
            }
        });

        mWordViewModel.callWordFromPage(1 , 5);
    }
}