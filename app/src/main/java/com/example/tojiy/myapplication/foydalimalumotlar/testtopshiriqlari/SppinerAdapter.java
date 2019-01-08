package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class SppinerAdapter extends ArrayAdapter {

    private Context context;
    private int textViewResurceId;
    private String[] objects;
    private static boolean flag = false;

    public SppinerAdapter(Context context, int textViewResurceId, String[] objects) {
        super(context, textViewResurceId, objects);
        this.context = context;
        this.textViewResurceId = textViewResurceId;
        this.objects = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null)
            convertView = View.inflate(context, textViewResurceId, null);
        if (flag != false) {
            TextView tv = (TextView) convertView;
            tv.setText(objects[position]);
        }
        return convertView;
    }




}


