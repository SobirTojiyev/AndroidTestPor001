package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.tojiy.myapplication.R;

public class TestTopshiriq1 extends DialogFragment {

    private RecyclerView recyclerView;
    private Button button;

    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = ii.inflate(R.layout.fragment_foydali_malumot, container, false);

        recyclerView = view.findViewById(R.id.recycFoydali);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));

        button = view.findViewById(R.id.btnFoydali);
        button.setVisibility(View.VISIBLE);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        ConHttpTestTop conHttpTestTop = new ConHttpTestTop(getActivity(), recyclerView);
        conHttpTestTop.execute("bufo7245yuklash", "bir");
        return view;
    }
}
