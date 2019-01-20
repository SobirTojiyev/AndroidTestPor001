package com.example.tojiy.myapplication.foydalimalumotlar.mosfanlar;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;

import java.util.ArrayList;

public class Mosfanlar1 extends DialogFragment {


    private Spinner spinner;
    private TextView txtMasofa;

    private ArrayList<GetSetMosfan> setMosfans;

    public ArrayList<GetSetMosfan> getSetMosfans() {
        return setMosfans;
    }

    public void setSetMosfans(ArrayList<GetSetMosfan> setMosfans) {
        this.setMosfans = setMosfans;
    }

    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View vim = ii.inflate(R.layout.activity_mosfanlar1, container, false);
        txtMasofa = vim.findViewById(R.id.txtMasofa);
        spinner = vim.findViewById(R.id.spinnMasofa);
        String[] spin1 = new String[getSetMosfans().size()];
        for (int i = 0; i < getSetMosfans().size(); i++) {

            spin1[i] = getSetMosfans().get(0).getName();

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity().getApplicationContext(), android.R.layout.simple_list_item_1, spin1);
        spinner.setAdapter(adapter);
        return vim;
    }
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_mosfanlar1);
//    }
}
