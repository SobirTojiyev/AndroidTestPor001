package com.example.tojiy.myapplication.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.tojiy.myapplication.R;

public class Search123 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search123);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
//        overridePendingTransition(R.anim.godown, R.anim.goup);
    }
}
