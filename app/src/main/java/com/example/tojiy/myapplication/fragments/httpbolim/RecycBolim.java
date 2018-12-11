package com.example.tojiy.myapplication.fragments.httpbolim;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;
import com.example.tojiy.myapplication.UNVERSALCLASS;
import com.example.tojiy.myapplication.foydalimalumotlar.FoydaliMalumot;

import java.util.ArrayList;

public class RecycBolim extends RecyclerView.Adapter<RecycBolim.BolimHolder> {


    private ArrayList<GetSetBol> getSetBols;
    private Context context;

    public RecycBolim(Context context, ArrayList<GetSetBol> getSetBols) {
        this.getSetBols = getSetBols;
        this.context = context;
    }

    @NonNull
    @Override
    public BolimHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_bolim, viewGroup, false);
        return new BolimHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BolimHolder bolimHolder, final int i) {

        bolimHolder.txtNomi.setText(getSetBols.get(i).getName());
        PicassBolim.downloadImage(context, getSetBols.get(i).getImg(), bolimHolder.img);
        bolimHolder.lineBolim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                UNVERSALCLASS.BUNDLE_URL = getSetBols.get(i).getUrl();

                FoydaliMalumot foydaliMalumot = new FoydaliMalumot();
                FragmentManager fragmentManager = ((AppCompatActivity) v.getContext()).getSupportFragmentManager();
                foydaliMalumot.show(fragmentManager, "");
            }
        });

    }

    @Override
    public int getItemCount() {
        return getSetBols.size();
    }

    public class BolimHolder extends RecyclerView.ViewHolder {

        private TextView txtNomi;
        private ImageView img;
        private LinearLayout lineBolim;

        public BolimHolder(@NonNull View i) {
            super(i);

            txtNomi = i.findViewById(R.id.txtBolim);
            img = i.findViewById(R.id.imgBolim);
            lineBolim = i.findViewById(R.id.lineBolim);

        }
    }
}
