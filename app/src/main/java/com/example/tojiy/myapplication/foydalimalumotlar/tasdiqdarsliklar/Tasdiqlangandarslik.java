package com.example.tojiy.myapplication.foydalimalumotlar.tasdiqdarsliklar;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tojiy.myapplication.R;

import java.util.ArrayList;

public class Tasdiqlangandarslik extends DialogFragment {


    private Button btn;
    private Spinner spinn1, spinn2;
    private TextView txt1, txt2;

    private ArrayList<GetSetTasdiqlangan> getSetTasdiqlangans;

    public ArrayList<GetSetTasdiqlangan> getGetSetTasdiqlangans() {
        return getSetTasdiqlangans;
    }

    public void setGetSetTasdiqlangans(ArrayList<GetSetTasdiqlangan> getSetTasdiqlangans) {
        this.getSetTasdiqlangans = getSetTasdiqlangans;
    }

    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = ii.inflate(R.layout.activity_tasdilangandarslik, container, false);
        spinn1 = view.findViewById(R.id.spinTasdiqlangan1);
        spinn2 = view.findViewById(R.id.spinTasdiqlangan2);
        txt1 = view.findViewById(R.id.txtTasdiqlangan1);
        txt2 = view.findViewById(R.id.txtTasdiqlangan2);
        btn = view.findViewById(R.id.btnTasdiqlangan);

//        Toast.makeText(getActivity().getApplicationContext(), getSetTasdiqlangans.get(0).getName(), Toast.LENGTH_SHORT).show();
//        String[] spin1 = new String[getGetSetTasdiqlangans().size()];
//        String[] spin2 = new String[getGetSetTasdiqlangans().size()];
//        for (int i = 0; i < getGetSetTasdiqlangans().size(); i++) {
//            spin1[i] = "" + getGetSetTasdiqlangans().get(i).getName();
//            spin1[i] = "" + getGetSetTasdiqlangans().get(i).getUzb();
//        }
//        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, spin1);
//        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, spin2);
//        spinn1.setAdapter(adapter1);
//        spinn1.setAdapter(adapter2);

        return view;
    }

}