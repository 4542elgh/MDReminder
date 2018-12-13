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

    // use openFDA Label directory
    final static String OPENFDA_BASE_URL = "https://api.fda.gov/drug/label.json";

    // e.g. API fields: e.g. indications_and_usage:cough
    // https://api.fda.gov/drug/label.json?search=indications_and_usage:cough&limit=10

    // if we run out of calls to API, then use the key
    // get api key @https://open.fda.gov/apis/authentication/


    // API parameters
//    final static String apiKey = "kYUL8C4ZdJ9baxinXqh6w3gP1b2EHvwVhTQkKQGo";
    final static String DIRECTORY = "label.json";
    final static String PARAM_LIMIT = "limit=";
    final static String PARAM_QUERY = "search";
    final static String limitValue = "10";

    // build url to query data from openFDA
    public static URL buildUrl(String field, String lookup) {
        Uri builtUri = Uri.parse(OPENFDA_BASE_URL).buildUpon()
                .appendPath(DIRECTORY)
                .appendQueryParameter(PARAM_QUERY, field + "=" + lookup)
                .appendQueryParameter(PARAM_LIMIT, "10")
                .build();

        URL url = null;

        try {
            url = new URL(builtUri.toString());
            Log.d("e", url.toString());

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        return url;
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

    // encode url Strings for QR Reader
    // PARAM_FIELD e.g. indications_and_usage
    // PARAM_LOOKUP e.g. "cough"
    public static String encodeUrl(String PARAM_FIELD, String PARAM_LOOKUP) {

        String encoded_url = "";

        try {
            encoded_url = OPENFDA_BASE_URL + "?" + PARAM_QUERY + "=" + URLEncoder.encode(PARAM_FIELD + ":" + PARAM_LOOKUP + "&" +PARAM_LIMIT + limitValue, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return encoded_url;
    }

    // evan can use the code below to decode the encodedUrl
    // decode url Strings once scanned in QR Reader
    public static String decodeUrl(String encodedUrl) {
        String decoded_url = "";

        try {
            decoded_url = URLDecoder.decode(encodedUrl, "UTF-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return decoded_url;
    }


}
