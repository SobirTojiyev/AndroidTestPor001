package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;

import java.util.ArrayList;

public class RecycTopshiriq extends RecyclerView.Adapter<RecycTopshiriq.ViewTestTop> {

    private ArrayList<GetSetTestTopshiriq> getSetTestTopshiriqs;
    private Context context;

    public RecycTopshiriq(Context context, ArrayList<GetSetTestTopshiriq> getSetTestTopshiriqs) {

        this.context = context;
        this.getSetTestTopshiriqs = getSetTestTopshiriqs;
    }

    @NonNull
    @Override
    public ViewTestTop onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_test_topshiriq, viewGroup, false);

        return new ViewTestTop(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewTestTop viewTestTop, int i) {

    }

    @Override
    public int getItemCount() {
        return getSetTestTopshiriqs.size();
    }

    public class ViewTestTop extends RecyclerView.ViewHolder {

        private Spinner spinner;
        private TextView txt;

        public ViewTestTop(@NonNull View itemView) {
            super(itemView);
        }
    }
}
