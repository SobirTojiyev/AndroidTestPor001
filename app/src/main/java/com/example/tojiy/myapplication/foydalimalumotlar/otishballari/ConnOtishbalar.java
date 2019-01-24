package com.example.tojiy.myapplication.foydalimalumotlar.otishballari;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

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
import java.nio.charset.Charset;

public class ConnOtishbalar extends AsyncTask<String, Void, String> {

    private Context contxt;
    private static final Charset ISO = Charset.forName("ISO-8859-1");
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    private String login_url = UNVERSALCLASS.url + "abc.json";

    public ConnOtishbalar(Context ctx) {

        contxt = ctx;

    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];

        if (type.equals("aotishballnsdsdfgxzcvAEF")) {

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
        String text1 = new String(result.getBytes(ISO), UTF_8);
        DataOtishbalar dataOtishbalar = new DataOtishbalar(contxt, text1);
        dataOtishbalar.execute();
//        Toast.makeText(contxt, "" + result, Toast.LENGTH_SHORT).show();


    }

}
