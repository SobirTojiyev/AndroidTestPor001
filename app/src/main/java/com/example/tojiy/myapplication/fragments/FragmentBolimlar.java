package com.example.tojiy.myapplication.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.tojiy.myapplication.R;
import com.example.tojiy.myapplication.fragments.httpbolim.ConnBolim;
import com.example.tojiy.myapplication.fragments.httpyangiliklar.ConnecYang;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBolimlar extends Fragment {

    private RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_fragment_bolimlar, container, false);

        recyclerView = view.findViewById(R.id.recycBolim);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        recyclerView.setHasFixedSize(true);
        ConnBolim connBolim = new ConnBolim(getActivity().getApplicationContext(), recyclerView);
        connBolim.execute("buarss123ai123yuklash", "bir");
        return view;
    }

}
