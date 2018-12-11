package com.example.tojiy.myapplication.foydalimalumotlar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tojiy.myapplication.R;

import java.util.ArrayList;

public class RecycFoydali extends RecyclerView.Adapter<RecycFoydali.FoydaliHolder> {

    private Context context;
    private ArrayList<GetSetFoydali> getSetFoydalis;

    public RecycFoydali(Context context, ArrayList<GetSetFoydali> getSetFoydalis) {
        this.context = context;
        this.getSetFoydalis = getSetFoydalis;
    }

    @NonNull
    @Override
    public FoydaliHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_foydali, viewGroup, false);
        return new FoydaliHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoydaliHolder f,final int i) {
        f.textView.setText(getSetFoydalis.get(i).getName());
        f.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "" + getSetFoydalis.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return getSetFoydalis.size();
    }

    public class FoydaliHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public FoydaliHolder(@NonNull View itemView) {
            super(itemView);

            textView = itemView.findViewById(R.id.txtFoydali);
        }
    }
}
