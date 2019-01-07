package com.example.tojiy.myapplication.foydalimalumotlar;


import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.tojiy.myapplication.R;


public class FoydaliMalumot extends DialogFragment {

    private RecyclerView recyclerView;
    private Button button;
    FrameLayout frameLayout;

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
        frameLayout = view.findViewById(R.id.fragmentFoydali);

        ConHttpFoydali conHttpFoydali = new ConHttpFoydali(getActivity().getApplicationContext(), recyclerView, button,frameLayout);
        conHttpFoydali.execute("bufoydaiioii123yuklash", "bir");
        return view;
    }

}
