package com.example.tojiy.myapplication.foydalimalumotlar.mosfanlar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataMosfan extends AsyncTask<Void, Void, Integer> {

    private Context c;

    private String jsonData;

    ArrayList<GetSetMosfan> setMosfans = new ArrayList<>();

    public DataMosfan(Context c, String jsonData) {
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

        ///SHU YERDAN TEKSHIRIB OLAMAN OYNALAR KO'RINISHINI
        FragmentActivity activity = (FragmentActivity) (c);
        FragmentManager manager = activity.getSupportFragmentManager();

        Mosfanlar1 mosfanlar1 = new Mosfanlar1();
        mosfanlar1.setSetMosfans(setMosfans);
        mosfanlar1.show(manager, "tag");

    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;

            setMosfans.clear();
            GetSetMosfan getSetMosfan;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);

                String name = jo.getString("name");
                String url = jo.getString("url");

                getSetMosfan = new GetSetMosfan();
                getSetMosfan.setName(key);
                getSetMosfan.setUrl(url);
                setMosfans.add(getSetMosfan);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
