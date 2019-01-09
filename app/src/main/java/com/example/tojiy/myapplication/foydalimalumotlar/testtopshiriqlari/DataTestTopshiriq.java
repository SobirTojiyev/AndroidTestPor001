package com.example.tojiy.myapplication.foydalimalumotlar.testtopshiriqlari;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataTestTopshiriq extends AsyncTask<Void, Void, Integer> {

    private Context c;
    private String jsonData;
    private ArrayList<GetSetTestTopshiriq> getSetTestTopshiriqs = new ArrayList<>();

    public DataTestTopshiriq(Context c, String jsonData) {
        this.c = c;
        this.jsonData = jsonData;
    }

    @Override
    protected Integer doInBackground(Void... voids) {
        return this.parserData();
    }

    @Override
    protected void onPostExecute(Integer result) {
        super.onPostExecute(result);

//         RecycTopshiriq recycTopshiriq = new RecycTopshiriq(c, getSetTestTopshiriqs);
//        rv.setAdapter(recycTopshiriq);

    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;

            getSetTestTopshiriqs.clear();
            GetSetTestTopshiriq getSetTestTopshiriq;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);

                String url = jo.getString("url");
                String name = jo.getString("name");

                getSetTestTopshiriq = new GetSetTestTopshiriq();
                getSetTestTopshiriq.setName(name);
                getSetTestTopshiriq.setId(key);
                getSetTestTopshiriq.setUrl(url);
                getSetTestTopshiriqs.add(getSetTestTopshiriq);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
