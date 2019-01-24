package com.example.tojiy.myapplication.foydalimalumotlar.savoljavob;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.tojiy.myapplication.R;
import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;

public class RecycSavolJavob extends RecyclerView.Adapter<RecycSavolJavob.ViewSavolJavob> {

    private Context c;
    private ArrayList<GetSetSavolJavob> getSetSavolJavobs;

    public RecycSavolJavob(Context c, ArrayList<GetSetSavolJavob> getSetSavolJavobs) {
        this.c = c;
        this.getSetSavolJavobs = getSetSavolJavobs;
    }

    @NonNull
    @Override
    public ViewSavolJavob onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext().getApplicationContext()).inflate(R.layout.model_savoljavob, viewGroup, false);
        return new ViewSavolJavob(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewSavolJavob vie, int i) {


        expandableTextView.setText("Javoblar varaqasi bu test topshiriqlari kitobidagi" +
                " har bir topshiriqning bajarilishi" +
                " natijasida tanlagan javobning bittasini belgilashga" +
                " mo‘ljallangan va abituriyentning bilimini baholash " +
                "uchun asos hisoblanadigan yagona hujjat.");
    }

    @Override
    public int getItemCount() {
        return getSetSavolJavobs.size();
    }

    private ExpandableTextView expandableTextView;
    private TextView textView;
    private ImageButton imageButton;


    public class ViewSavolJavob extends RecyclerView.ViewHolder {

        public ViewSavolJavob(@NonNull View itemView) {
            super(itemView);
            expandableTextView = itemView.findViewById(R.id.expandable_text_view);


        }
    }

}





