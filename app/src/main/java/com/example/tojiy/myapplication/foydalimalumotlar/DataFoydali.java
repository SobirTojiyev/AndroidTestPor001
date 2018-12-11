package com.example.tojiy.myapplication.foydalimalumotlar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import com.example.tojiy.myapplication.UNVERSALCLASS;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataFoydali extends AsyncTask<Void, Void, Integer> {

    private Context c;
    private RecyclerView rv;
    private String jsonData;

    ArrayList<GetSetFoydali> getSetFoydalis = new ArrayList<>();

    public DataFoydali(Context c, RecyclerView rv, String jsonData) {
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
            RecycFoydali recycFoydali = new RecycFoydali(c, getSetFoydalis);
            rv.setAdapter(recycFoydali);

    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;
            getSetFoydalis.clear();
            GetSetFoydali getSetFoydali;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);
                String url = jo.getString("url");
                getSetFoydali = new GetSetFoydali();
                getSetFoydali.setName(key);
                getSetFoydali.setUrl(url);
                getSetFoydalis.add(getSetFoydali);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
