package com.example.tojiy.myapplication.foydalimalumotlar;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tojiy.myapplication.R;
import com.example.tojiy.myapplication.UNVERSALCLASS;
import com.example.tojiy.myapplication.foydalimalumotlar.javoblarvaraqasi.JavoblarTN;
import com.example.tojiy.myapplication.foydalimalumotlar.mosfanlar.ConnMosfan;
import com.example.tojiy.myapplication.foydalimalumotlar.otishballari.ConnOtishbalar;
import com.example.tojiy.myapplication.foydalimalumotlar.savoljavob.ConnSavolJavob;
import com.example.tojiy.myapplication.foydalimalumotlar.savoljavob.SavolJavob;
import com.example.tojiy.myapplication.foydalimalumotlar.tasdiqdarsliklar.ConnTasdiqlangandarslik;
import com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari.ConHttpTestTop;
import com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari.TestTopshiriq1;
import com.example.tojiy.myapplication.webview.WebViewClass;

import java.util.ArrayList;


public class RecycFoydali extends RecyclerView.Adapter<RecycFoydali.FoydaliHolder> {

    private Context context;
    private ArrayList<GetSetFoydali> getSetFoydalis;
    FrameLayout frameLayout;

    public RecycFoydali(Context context, ArrayList<GetSetFoydali> getSetFoydalis, FrameLayout frameLayout) {
        this.context = context;
        this.getSetFoydalis = getSetFoydalis;
        this.frameLayout = frameLayout;
    }

    @NonNull
    @Override
    public FoydaliHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.model_foydali, viewGroup, false);
        return new FoydaliHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FoydaliHolder f, final int i) {
        f.textView.setText(getSetFoydalis.get(i).getName());
        f.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "" + getSetFoydalis.get(i).getUrl(), Toast.LENGTH_SHORT).show();
                UNVERSALCLASS.EXSEPTION_URL = getSetFoydalis.get(i).getUrl();

                if (getSetFoydalis.get(i).getUrl().trim().contains("video")) {
                    v.getContext().startActivity(new Intent(v.getContext(), JavoblarTN.class));
                }
                if (getSetFoydalis.get(i).getUrl().trim().contains("pdf")) {
                    v.getContext().startActivity(new Intent(v.getContext(), WebViewClass.class));
                }
                if (getSetFoydalis.get(i).getUrl().trim().contains("123")) {

                    ConHttpTestTop conHttpTestTop = new ConHttpTestTop(context);
                    conHttpTestTop.execute("bufo7245yuklash", "kalit");
                }
                if (getSetFoydalis.get(i).getUrl().trim().contains("tasdiqlangan")) {

                    ConnTasdiqlangandarslik connTasdiqlangandarslik = new ConnTasdiqlangandarslik(context);
                    connTasdiqlangandarslik.execute("asdsdfgxzcvAEF", "kalit");
                }
                if (getSetFoydalis.get(i).getUrl().trim().contains("talimyonalish")) {

                    ConnMosfan connMosfan = new ConnMosfan(context);
                    connMosfan.execute("amosfansdsdfgxzcvAEF", "kalit");
                }
                if (getSetFoydalis.get(i).getUrl().trim().contains("otishballari")) {

                    ConnOtishbalar connOtishbalar = new ConnOtishbalar(context);
                    connOtishbalar.execute("aotishballnsdsdfgxzcvAEF", "kalit");
                }

                if (getSetFoydalis.get(i).getUrl().trim().contains("savoljavob")) {

                    v.getContext().startActivity(new Intent(v.getContext(), SavolJavob.class));
                }

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
