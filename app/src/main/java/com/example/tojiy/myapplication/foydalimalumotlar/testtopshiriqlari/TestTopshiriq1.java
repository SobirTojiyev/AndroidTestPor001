package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;

import java.util.ArrayList;


public class TestTopshiriq1 extends DialogFragment {

    private Button button;
    private Spinner sppin1, sppin2;
    private Context context;
    private TextView txt1, txt2;

    ArrayList<GetSetTestTopshiriq> getSetTestTopshiriqs;

    public ArrayList<GetSetTestTopshiriq> getGetSetTestTopshiriqs() {
        return getSetTestTopshiriqs;
    }

    public void setGetSetTestTopshiriqs(ArrayList<GetSetTestTopshiriq> getSetTestTopshiriqs) {
        this.getSetTestTopshiriqs = getSetTestTopshiriqs;
    }


    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi = ii.inflate(R.layout.activity_test_topshiriq1, container, false);


        String[] spin1 = new String[getGetSetTestTopshiriqs().size()],

                spin2 = new String[getGetSetTestTopshiriqs().size()];

        for (int i = 0; i < getGetSetTestTopshiriqs().size(); i++) {

            spin1[i] = getGetSetTestTopshiriqs().get(i).getName();
            spin2[i] = getGetSetTestTopshiriqs().get(i).getUrl();
//            Log.v("GOLD", getGetSetTestTopshiriqs().get(i).getId());
        }


        sppin1 = vi.findViewById(R.id.spinTestTopshiriq1);
        sppin2 = vi.findViewById(R.id.spinTestTopshiriq2);
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, spin1);
        sppin1.setAdapter(adapter1);
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(getActivity().getApplicationContext(), android.R.layout.simple_spinner_item, spin2);
        sppin2.setAdapter(adapter2);
        txt1 = vi.findViewById(R.id.txtTestTopshiriq1);
        txt2 = vi.findViewById(R.id.txtTestTopshiriq2);
        button = vi.findViewById(R.id.btnTestTopshiriq);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity().getApplicationContext(), TesttopshiriqPDF.class));
                dismiss();
            }
        });

        return vi;
    }


}