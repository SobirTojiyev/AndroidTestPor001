package com.example.tojiy.myapplication.foydalimalumotlar.mosfanlar;

import android.content.Context;
import android.os.AsyncTask;

import com.example.tojiy.myapplication.UNVERSALCLASS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class ConnMosfan extends AsyncTask<String, Void, String> {

    private Context contxt;


    private String login_url = UNVERSALCLASS.url + "talimyonalish.php";

    public ConnMosfan(Context ctx) {

        contxt = ctx;

    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        if (type.equals("amosfansdsdfgxzcvAEF")) {

            try {

                String stolid = params[1];

                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);

                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String postData =
                        URLEncoder.encode("kalit", "UTF-8")
                                + "=" + URLEncoder.encode(stolid, "UTF-8");
                bufferedWriter.write(postData);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {

                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public void onPostExecute(String result) {
//
        DataMosfan dataMosfan = new DataMosfan(contxt, result);
        dataMosfan.execute();

    }

}
