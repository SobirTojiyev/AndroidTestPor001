package com.example.tojiy.myapplication.foydalimalumotlar.savoljavob;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.example.tojiy.myapplication.foydalimalumotlar.RecycOnlineTest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataSavolJavob extends AsyncTask<Void, Void, Integer> {

    private Context c;
    private RecyclerView rv;
    private String jsonData;

    ArrayList<GetSetSavolJavob> getSetSavolJavobArrayList = new ArrayList<>();

    public DataSavolJavob(Context c, RecyclerView rv, String jsonData) {
        this.c = c;
        this.rv = rv;
        this.jsonData = jsonData;

    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parserData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        ///SHU YERDAN TEKSHIRIB OLAMAN OYNALAR KO'RINISHINI
        RecycSavolJavob recycSavolJavob = new RecycSavolJavob(c, getSetSavolJavobArrayList);
        rv.setAdapter(recycSavolJavob);

    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;

            getSetSavolJavobArrayList.clear();
            GetSetSavolJavob setSavolJavob;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);

                setSavolJavob = new GetSetSavolJavob();

//                String name = jo.getString("name");
                setSavolJavob.setTxt(key);
                getSetSavolJavobArrayList.add(setSavolJavob);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
