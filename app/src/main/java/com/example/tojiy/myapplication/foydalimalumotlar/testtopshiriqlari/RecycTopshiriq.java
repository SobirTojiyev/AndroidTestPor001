package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

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

        viewTestTop.txt.setText(getSetTestTopshiriqs.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return getSetTestTopshiriqs.size();
    }


    public class ViewTestTop extends RecyclerView.ViewHolder {

        private Spinner spinner;
        private TextView txt;
        private String son[] = new String[getSetTestTopshiriqs.size()];

        public ViewTestTop(@NonNull View itemView) {
            super(itemView);


            spinner = itemView.findViewById(R.id.spinnerID);
            txt = itemView.findViewById(R.id.txtSppiner);

            for (int i = 0; i < getSetTestTopshiriqs.size(); i++) {
                son[i] = getSetTestTopshiriqs.get(i).getName();
                Log.v("SPPINER", son[i]);
            }


            spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

//                    spinner.setAdapter();

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

//            SpinnerAdapter spinnerAdapter = new SppinerAdapter(context, android.R.layout.simple_spinner_dropdown_item, son);
//            ArrayAdapter<GetSetTestTopshiriq> adapter = new ArrayAdapter<GetSetTestTopshiriq>(context, android.R.layout.simple_list_item_1, son);
//            spinner.setAdapter(adapter);
        }
    }
}
