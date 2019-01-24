package com.example.tojiy.myapplication.foydalimalumotlar.otishballari;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Iterator;

public class DataOtishbalar extends AsyncTask<Void, Void, Integer> {

    private Context c;

    private JSONObject jsonData;
    public String[][][] tillar=new String[20][5][3];

    ArrayList<GetSetOtishbalar> getSetOnlines = new ArrayList<>();

    public DataOtishbalar(Context c, String jsonData) {
        this.c = c;
        try {
            this.jsonData = new JSONObject(jsonData);
        } catch (JSONException e) {
            e.printStackTrace();
        }

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

    public String[] fanlar() {
        String[] a = new String[this.jsonData.length()];
        Iterator<String> iterator = this.jsonData.keys();
        int $i = 0;
        while (iterator.hasNext())
            a[$i++] = iterator.next();
        return a;
    }

    public String[] getTil(int $key) {
        String[] a = new String[tillar[$key].length];
        for (int i = 0; i < tillar[$key].length; i++) {
            a[i] = tillar[$key][i][0];
        }
        return a;
    }

    private int parserData() {

        try {
            JSONObject ja = jsonData;
            JSONObject jo = null;

            getSetOnlines.clear();
            GetSetOtishbalar setOtishbalar;


            Iterator<String> iterator = ja.keys();
            int i = 0;
            while (iterator.hasNext()) {
                int j = 0;
                String key = iterator.next();
                jo = ja.getJSONObject(key);

                Iterator<String> iterator1 = jo.keys();

                while (iterator1.hasNext()) {
                    String til = iterator1.next();
                    String val = jo.getString(til);
                    tillar[i][j][0] = til;
                    tillar[i][j++][1] = val;
                }
                i ++;
//                String hudud = jo.getString("hudud");
//                String shakli = jo.getString("shakli");
//                String tili = jo.getString("tili");
////                String muassasasi = jo.getString("muassasasi");
//
//                setOtishbalar = new GetSetOtishbalar();
//
//                setOtishbalar.setTalimMuassasa(key);
//                setOtishbalar.setOtmHudud(hudud);
//                setOtishbalar.setTalimShakli(shakli);
//                setOtishbalar.setTalimTili(tili);
//                getSetOnlines.add(setOtishbalar);
            }
            String[] d = getTil(3);

//            for (int k = 0; k < d.length; k++)
//                Log.v("GOLD", d[k]);
            return 1;

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
