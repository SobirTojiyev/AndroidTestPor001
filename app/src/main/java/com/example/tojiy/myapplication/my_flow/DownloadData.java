package com.example.tojiy.myapplication.my_flow;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;

public class DownloadData extends AsyncTask<Void, Void, String> {


    Context c;
    String urlAddress = "http://192.168.88.51/api/service-menu";
    RecyclerView rv;

    public DownloadData(Context c, String urlAddress, RecyclerView rv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.rv = rv;
    }

    @Override
    protected String doInBackground(Void... voids) {
        return this.donwloadData();
    }

    @Override
    protected void onPostExecute(String jsonData) {
        super.onPostExecute(jsonData);

        if (jsonData == null) {

        } else {

            Toast.makeText(c, "" + jsonData, Toast.LENGTH_SHORT).show();
            //parser
//            Dataparser2 dataparser2 = new Dataparser2(c, rv, jsonData);
//            dataparser2.execute();
        }


    }

    private String donwloadData() {


        HttpURLConnection conn = HttpConn.connection(urlAddress);
        if (conn == null) {

            return null;
        }

        try {
            InputStream is = new BufferedInputStream(conn.getInputStream());
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            String line;
            StringBuffer jsonData = new StringBuffer();
            while ((line = br.readLine()) != null) {

                jsonData.append(line + "\n");
            }
            br.close();
            is.close();
            return jsonData.toString();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}