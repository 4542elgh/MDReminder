package com.example.herr.MDReader;

import org.junit.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import static org.junit.Assert.*;


public class NetworkUtilsUnitTest {
    @Test
    public void httpUrlConnectionTest() throws Exception {
        String urlStr = "https://api.fda.gov/drug/ndc.json?search=product_ndc:68428-036";

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

}