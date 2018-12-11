package com.example.tojiy.myapplication.fragments.httpbolim;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DatBolim extends AsyncTask<Void, Void, Integer> {

    private Context c;
    private RecyclerView rv;
    private String jsonData;
    private ArrayList<GetSetBol> getSetBols = new ArrayList<>();

    public DatBolim(Context c, RecyclerView rv, String jsonData) {
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

        RecycBolim recycBolim = new RecycBolim(c, getSetBols);
        rv.setAdapter(recycBolim);
    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;
            getSetBols.clear();
            GetSetBol getSetBol;

            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);
                String name = jo.getString("name");
                String url = jo.getString("url");

                getSetBol = new GetSetBol();
                getSetBol.setName(key);
                getSetBol.setUrl(url);
                getSetBol.setImg(name);
                getSetBols.add(getSetBol);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
