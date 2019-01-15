package com.example.tojiy.myapplication.foydalimalumotlar.tasdiqdarsliklar;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataTasdiqlangan extends AsyncTask<Void, Void, Integer> {

    private Context c;
    private String jsonData;

    private ArrayList<GetSetTasdiqlangan> getSetTasdiqlangans = new ArrayList<>();

    public DataTasdiqlangan(Context c, String jsonData) {
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

        FragmentActivity activity = (FragmentActivity) (c);
        FragmentManager fm = activity.getSupportFragmentManager();

        Tasdiqlangandarslik tasdiqlangandarslik = new Tasdiqlangandarslik();
        tasdiqlangandarslik.setGetSetTasdiqlangans(getSetTasdiqlangans);
        tasdiqlangandarslik.show(fm, "fragment_alert");

    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;

            getSetTasdiqlangans.clear();
            GetSetTasdiqlangan getSetTasdiqlangan;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);

//                String url = jo.getString("url");
                String uzb = jo.getString("uzb");
                String rus = jo.getString("rus");
                String qqr = jo.getString("qqr");

                getSetTasdiqlangan = new GetSetTasdiqlangan();
                getSetTasdiqlangan.setName(key);
                getSetTasdiqlangan.setUzb(uzb);
                getSetTasdiqlangan.setRus(rus);
                getSetTasdiqlangan.setQqr(qqr);
                getSetTasdiqlangans.add(getSetTasdiqlangan);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
