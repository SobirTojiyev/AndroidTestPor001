package com.example.tojiy.myapplication.foydalimalumotlar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tojiy.myapplication.R;

import java.util.ArrayList;

public class RecycOnlineTest extends RecyclerView.Adapter<RecycOnlineTest.OnLineViewHolder> {

    private Context context;
    private ArrayList<GetSetOnline> getSetOnlines;

    public RecycOnlineTest(Context context, ArrayList<GetSetOnline> getSetOnlines) {
        this.context = context;
        this.getSetOnlines = getSetOnlines;
    }

    @NonNull
    @Override
    public OnLineViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_repetitsiontest, viewGroup, false);
        return new OnLineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final OnLineViewHolder cin, int i) {
//
        cin.txtTitle.setText(getSetOnlines.get(i).getNomi1());
        cin.txtIzoh.setText(getSetOnlines.get(i).getNomi5());
        cin.edtJavVar.setHint("" + getSetOnlines.get(i).getNomi2());
        cin.edtPicCod.setHint("" + getSetOnlines.get(i).getNomi3());
        PicassoOnLineTest.downloadImage(context, getSetOnlines.get(i).getImg(), cin.imageView);
        cin.btnFoydali.setText(getSetOnlines.get(i).getNomi4());
        cin.btnFoydali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                cin.linearLayout.setVisibility(View.INVISIBLE);
//                Toast.makeText(context, "", Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return getSetOnlines.size();
    }

    public class OnLineViewHolder extends RecyclerView.ViewHolder {

        private EditText edtJavVar, edtPicCod;
        private TextView txtIzoh, txtTitle;
        private Button btnFoydali;
        private ImageView imageView;
        private LinearLayout linearLayout;

        public OnLineViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout = itemView.findViewById(R.id.linerRepitetsion);
            txtIzoh = itemView.findViewById(R.id.txtFoyydaliIzox);
            txtTitle = itemView.findViewById(R.id.txtFoydaliTitile);

            imageView = itemView.findViewById(R.id.imgFoydaliTasdiqlash);

            edtJavVar = itemView.findViewById(R.id.edtFoydaliJavobVaraqa);
            edtPicCod = itemView.findViewById(R.id.edtFoydaliTasdiqKod);

            btnFoydali = itemView.findViewById(R.id.btnFoydaliTasdiq);
        }
    }
}
