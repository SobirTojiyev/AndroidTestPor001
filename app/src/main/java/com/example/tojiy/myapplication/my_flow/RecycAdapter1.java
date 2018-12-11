package com.example.tojiy.myapplication.my_flow;

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

public class RecycAdapter1 extends RecyclerView.Adapter<RecycAdapter1.ViewNavigationClass> {

    private Context ctx;
    private ArrayList<SetGet1> setGet1s;

    public RecycAdapter1(Context ctx, ArrayList<SetGet1> setGet1s) {
        this.ctx = ctx;
        this.setGet1s = setGet1s;
    }


    @NonNull
    @Override
    public ViewNavigationClass onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model1, viewGroup, false);
        return new ViewNavigationClass(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewNavigationClass viewNavigationClass, final int i) {


        viewNavigationClass.txt.setText(setGet1s.get(i).getName());
        viewNavigationClass.txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ctx, "" + setGet1s.get(i).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return setGet1s.size();
    }

    public class ViewNavigationClass extends RecyclerView.ViewHolder {

        private TextView txt;

        public ViewNavigationClass(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.txt_first);
        }
    }

}
