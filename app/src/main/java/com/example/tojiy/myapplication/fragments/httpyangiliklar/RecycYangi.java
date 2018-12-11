package com.example.tojiy.myapplication.fragments.httpyangiliklar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;
import com.example.tojiy.myapplication.open_list.Opener;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class RecycYangi extends RecyclerView.Adapter<RecycYangi.YangViewHolder> {

    private Context c;
    private ArrayList<GetSetYang> getSetYangs;

    public RecycYangi(Context c, ArrayList<GetSetYang> getSetYangs) {
        this.c = c;
        this.getSetYangs = getSetYangs;
    }


    @NonNull
    @Override
    public YangViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_unver, viewGroup, false);
        return new YangViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final YangViewHolder holder, int i) {
//        holder.expandableTextView.setText(getSetYangs.get(i).getName());

        holder.txt.setText(getSetYangs.get(i).getName());
        PicassoYang.downloadImage(c, getSetYangs.get(i).getUrl(), holder.img);
        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), Opener.class));



            }
        });

    }

    @Override
    public int getItemCount() {
        return getSetYangs.size();
    }


    public class YangViewHolder extends RecyclerView.ViewHolder {

        private ExpandableTextView expandableTextView;
        private TextView txt;
        private ImageView img;
        private LinearLayout linearLayout;

        public YangViewHolder(@NonNull View itemView) {
            super(itemView);

//            expandableTextView = (ExpandableTextView) itemView.findViewById(R.id.expandTextView);

            txt = itemView.findViewById(R.id.txtYangilik);
            img = itemView.findViewById(R.id.imgYangi);
            linearLayout = itemView.findViewById(R.id.linerUnver);
        }
    }
}
