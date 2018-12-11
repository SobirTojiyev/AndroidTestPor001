package com.example.tojiy.myapplication.fragments.httpyangiliklar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DatYang extends AsyncTask<Void, Void, Integer> {

    private Context c;
    private RecyclerView rv;
    private String jsonData;

    ArrayList<GetSetYang> getSetYangs = new ArrayList<>();

    public DatYang(Context c, RecyclerView rv, String jsonData) {
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

//        RecycAdapter1 recycAdapter1 = new RecycAdapter1(c, setGet1s);
//        rv.setAdapter(recycAdapter1);

        RecycYangi recycYangi = new RecycYangi(c, getSetYangs);
        rv.setAdapter(recycYangi);
    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;

//             ja.getJSONObject(1);
//            JSONArray j1 = jo.getJSONArray("url");
//            JSONObject j2 = j1.getJSONObject(0);

            getSetYangs.clear();
            GetSetYang getSetYang;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);

//                String id = jo.getString("id");
//                jo = ja.getJSONObject();
//                jo2 = ja.getJSONObject(2);
//                Log.v("key", key);
                String url = jo.getString("url");

                getSetYang = new GetSetYang();
//                setGet1.setId(key);

                getSetYang.setName(key);
                getSetYang.setUrl(url);
                getSetYangs.add(getSetYang);
            }


            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}