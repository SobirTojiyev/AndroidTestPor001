package com.example.tojiy.myapplication.foydalimalumotlar.otishballari;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataOtishbalar extends AsyncTask<Void, Void, Integer> {

    private Context c;

    private String jsonData;

    ArrayList<GetSetOtishbalar> getSetOnlines = new ArrayList<>();

    public DataOtishbalar(Context c, String jsonData) {
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

        Otishbalar otishbalar = new Otishbalar();

        otishbalar.show(manager, "tag");
    }

    private int parserData() {

        try {
            JSONObject ja = new JSONObject(jsonData);
            JSONObject jo = null;

            getSetOnlines.clear();
            GetSetOtishbalar setOtishbalar;


            Iterator<String> iterator = ja.keys();
            while (iterator.hasNext()) {
                String key = iterator.next();
                jo = ja.getJSONObject(key);

                String hudud = jo.getString("hudud");
                String shakli = jo.getString("shakli");
                String tili = jo.getString("tili");
//                String muassasasi = jo.getString("muassasasi");

                setOtishbalar = new GetSetOtishbalar();

                setOtishbalar.setTalimMuassasa(key);
                setOtishbalar.setOtmHudud(hudud);
                setOtishbalar.setTalimShakli(shakli);
                setOtishbalar.setTalimTili(tili);
                getSetOnlines.add(setOtishbalar);
            }

            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
