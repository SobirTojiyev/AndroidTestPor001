package com.example.tojiy.myapplication.foydalimalumotlar.otishballari;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tojiy.myapplication.R;

public class Otishbalar extends DialogFragment {


    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi = ii.inflate(R.layout.activity_otishbalar, container, false);

        return vi;
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_otishbalar);
//    }
}
