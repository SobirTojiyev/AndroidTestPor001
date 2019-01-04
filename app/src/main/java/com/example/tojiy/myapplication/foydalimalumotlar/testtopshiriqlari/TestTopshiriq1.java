package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tojiy.myapplication.R;

public class TestTopshiriq1 extends AppCompatActivity {

    private RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_topshiriq1);


        rv = findViewById(R.id.recyTestTopshiriq);
        rv.setLayoutManager(new LinearLayoutManager(this));

        ConHttpTestTop conHttpTestTop = new ConHttpTestTop(this.getApplication(), rv);
        conHttpTestTop.execute("bufo7245yuklash", "bir");
    }
}
