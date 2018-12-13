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

    final static String OPENFDA_BASE_URL = "https://api.fda.gov/drug/";
    final static String PARAM_NDC_DIRECTORY = "ndc.json";

    // api universal query parameters
    final static String PARAM_SEARCH = "search";
    final static String PARAM_LIMIT = "limit";

    // lookup terms
    final static String limitValue = "10";
    final static String isFinished = "true";
    final static String humanDrug = "product_type:human";

    // build label url
    public static URL buildNdcUrl() {

        Uri ndcUri = Uri.parse(OPENFDA_BASE_URL).buildUpon()
                .path(PARAM_NDC_DIRECTORY) // out: ndc.json?
                .appendQueryParameter(PARAM_SEARCH, humanDrug) //out: search=product_type:human
                .appendQueryParameter(PARAM_LIMIT, limitValue) //limit=10
                .build();

        URL ndcUrl = null;

        try {
            ndcUrl = new URL(ndcUri.toString());
            Log.d("TAG", ndcUrl.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return ndcUrl;
    }

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
