package com.example.herr.MDReader;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class NetworkUtils {

    // use openFDA Label directory
    final static String BASE_URL = "https://api.fda.gov/drug/label.json";

    // get api key @https://open.fda.gov/apis/authentication/
    final static String apiKey = "kYUL8C4ZdJ9baxinXqh6w3gP1b2EHvwVhTQkKQGo";

    // return the first 10 results from API
    final static String limitCount = "&limit=10";
//    final static String searchBy = "?search=";

    // API fields:
    final static String indicationUsage = "indications_and_usage:";

    // build url with URLEncoder to format url Strings for QR Reader
    public static String encodeUrl(String lookup) {

        String encoded_url = "";

        try {
            encoded_url = BASE_URL + "?search=" + URLEncoder.encode(indicationUsage + lookup + limitCount, "UTF-8");

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
