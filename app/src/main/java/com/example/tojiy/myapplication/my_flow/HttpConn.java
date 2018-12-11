package com.example.tojiy.myapplication.my_flow;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpConn {public static HttpURLConnection connection(String urlAddress){


    try {

        URL url = new URL(urlAddress);
        HttpURLConnection connection= (HttpURLConnection) url.openConnection();

        connection.setRequestMethod("GET");
        connection.setConnectTimeout(20000);
        connection.setReadTimeout(20000);
        connection.setDoInput(true);
        return connection;

    } catch (MalformedURLException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }


    return null;
}

}
