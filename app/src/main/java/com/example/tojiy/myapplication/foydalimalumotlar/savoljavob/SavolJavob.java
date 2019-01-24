package com.example.tojiy.myapplication.foydalimalumotlar.savoljavob;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.tojiy.myapplication.R;

public class SavolJavob extends AppCompatActivity {

    private RecyclerView recycSavolJavob;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_savol_javob);

        recycSavolJavob = findViewById(R.id.recycSavolJavob);
        recycSavolJavob.setLayoutManager(new LinearLayoutManager(this));
        recycSavolJavob.setHasFixedSize(true);


        ConnSavolJavob connSavolJavob = new ConnSavolJavob(SavolJavob.this, recycSavolJavob);
        connSavolJavob.execute("busavoljavoboii123yuklash", "kalit");

    }
}
