package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.content.Context;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;

public class TestTopshiriq1 extends DialogFragment {

    private Button button;
    private Spinner sppin1, sppin2;
    private Context context;
    private TextView txt1, txt2;


    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi = ii.inflate(R.layout.activity_test_topshiriq1, container, false);

        ConHttpTestTop conHttpTestTop = new ConHttpTestTop(context);
        conHttpTestTop.execute("bufo7245yuklash", "kalit");

        sppin1 = vi.findViewById(R.id.spinTestTopshiriq1);
        sppin2 = vi.findViewById(R.id.spinTestTopshiriq2);

        txt1 = vi.findViewById(R.id.txtTestTopshiriq1);
        txt2 = vi.findViewById(R.id.txtTestTopshiriq2);



        return vi;
    }
}