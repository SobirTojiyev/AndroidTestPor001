package com.example.tojiy.myapplication.foydalimalumotlar.otishballari;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

import com.example.tojiy.myapplication.R;

import java.util.ArrayList;

public class Otishbalar extends DialogFragment {

    private Button btn2017, btn2018;
    private Spinner spinnHudud, spinnTalimmuass, spinnShakli, spinnTili;

    private ArrayList<GetSetOtishbalar> getSetOtishbalars;

    public ArrayList<GetSetOtishbalar> getGetSetOtishbalars() {
        return getSetOtishbalars;
    }

    public void setGetSetOtishbalars(ArrayList<GetSetOtishbalar> getSetOtishbalars) {
        this.getSetOtishbalars = getSetOtishbalars;
    }

    @Override
    public View onCreateView(LayoutInflater ii, ViewGroup container,
                             Bundle savedInstanceState) {
        View vi = ii.inflate(R.layout.activity_otishbalar, container, false);

        btn2017 = vi.findViewById(R.id.btn2017);
        btn2018 = vi.findViewById(R.id.btn2018);

        spinnHudud = vi.findViewById(R.id.spinnHududTanlash);
        spinnTalimmuass = vi.findViewById(R.id.spinnTalimuassasa);
        spinnShakli = vi.findViewById(R.id.spinnTalimshakl);
        spinnTili = vi.findViewById(R.id.spinnTalimtili);


        return vi;
    }

    //    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_otishbalar);
//    }
}
