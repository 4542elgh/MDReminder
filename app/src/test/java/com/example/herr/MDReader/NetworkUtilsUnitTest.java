package com.example.herr.MDReader;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;


public class NetworkUtilsUnitTest {
    @Test
    public void labelUrlTest() {
        assertEquals("https://api.fda.gov/drug/ndc.json?search=product_type:human&limit=10",
                NetworkUtils.buildNdcUrl());
    }

    @Test
    public void httpUrlConnectionTest() throws Exception {
        String urlStr = "https://api.fda.gov/drug/label.json?search=indications_and_usage=cough&limit=10";

        try {
            URL url = new URL(urlStr);
            HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
            urlConn.connect();

            // test passes if HTTP Status == 200
            assertEquals(HttpURLConnection.HTTP_OK, urlConn.getResponseCode());

        } catch (IOException e) {
            System.err.println("Error creating HTTP connection");
            e.printStackTrace();
            throw e;
        }
    }
//
//    @Test
//    public void encodeUrlTest() {
//        assertEquals("https://api.fda.gov/drug/label.json?search=indications_and_usage%3Acough%26limit%3D10",
//                NetworkUtils.encodeUrl("indications_and_usage", "cough"));
//    }
//
//    @Test
//    public void decodeUrlTest() {
//        assertEquals("https://api.fda.gov/drug/label.json?search=indications_and_usage:cough&limit=10",
//                NetworkUtils.decodeUrl("https://api.fda.gov/drug/label.json?search=indications_and_usage%3Acough%26limit%3D10"));
//    }

}