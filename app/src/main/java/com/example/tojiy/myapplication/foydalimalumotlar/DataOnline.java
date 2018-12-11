package com.example.tojiy.myapplication.foydalimalumotlar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataOnline extends AsyncTask<Void, Void, Integer> {

    private Context c;
    private RecyclerView rv;
    private Button button;
    private String jsonData;

    ArrayList<GetSetOnline> getSetOnlines = new ArrayList<>();

    public DataOnline(Context c, RecyclerView rv, String jsonData, Button button) {
        this.c = c;
        this.rv = rv;
        this.jsonData = jsonData;
        this.button = button;

    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parserData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

        ///SHU YERDAN TEKSHIRIB OLAMAN OYNALAR KO'RINISHINI
        button.setVisibility(View.GONE);
        RecycOnlineTest recycOnlineTest = new RecycOnlineTest(c, getSetOnlines);
        rv.setAdapter(recycOnlineTest);

    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;

            getSetOnlines.clear();
            GetSetOnline getSetOnline;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);

//                String url = jo.getString("url");
                String name2 = jo.getString("name2");
                String name3 = jo.getString("name3");
                String name4 = jo.getString("name4");
                String name5 = jo.getString("name5");
                String img = jo.getString("img");

                getSetOnline = new GetSetOnline();
                getSetOnline.setNomi1(key);
                getSetOnline.setNomi2(name2);
                getSetOnline.setNomi3(name3);
                getSetOnline.setNomi4(name4);
                getSetOnline.setNomi5(name5);
//                getSetOnline.setUrlPost(url);
                getSetOnline.setImg(img);
                getSetOnlines.add(getSetOnline);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
