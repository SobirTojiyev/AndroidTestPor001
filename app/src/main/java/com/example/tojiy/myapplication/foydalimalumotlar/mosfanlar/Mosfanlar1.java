package com.example.tojiy.myapplication.foydalimalumotlar.mosfanlar;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;

public class Mosfanlar1 extends DialogFragment {


    private Spinner spinner;
    private TextView txtMasofa;


    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View vim = ii.inflate(R.layout.activity_mosfanlar1, container, false);
        txtMasofa = vim.findViewById(R.id.txtMasofa);
        spinner = vim.findViewById(R.id.spinnMasofa);


        return vim;
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mosfanlar1);
//    }
    }
