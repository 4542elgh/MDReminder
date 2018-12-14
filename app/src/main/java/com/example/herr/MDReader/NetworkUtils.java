package com.example.herr.MDReader;

import android.net.Uri;
import android.util.Log;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Scanner;

public class NetworkUtils {

    /**
     *     other API fields can be found @
     *     if we run out of calls to API, get an api key @https://open.fda.gov/apis/authentication/
     *     hue's api key: "kYUL8C4ZdJ9baxinXqh6w3gP1b2EHvwVhTQkKQGo";
     */

    // open a HTTP connection to get data from url
    public static String getResponseFromHttpUrl(URL url) throws IOException {

        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            boolean hasInput = scanner.hasNext();
            if (hasInput) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }

}
