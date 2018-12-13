package com.example.herr.MDReader;

import org.junit.Test;

import static org.junit.Assert.*;


public class NetworkUtilsUnitTest {
    @Test
    public void encodeUrlTest() {

        assertEquals("https://api.fda.gov/drug/label.json?search=indications_and_usage%3Acough%26limit%3D10",
                NetworkUtils.encodeUrl("indications_and_usage", "cough"));
    }

    @Test
    public void decodeUrlTest() {
        assertEquals("https://api.fda.gov/drug/label.json?search=indications_and_usage:cough&limit=10",
                NetworkUtils.decodeUrl("https://api.fda.gov/drug/label.json?search=indications_and_usage%3Acough%26limit%3D10"));
    }

    @Test
    public void builtUrlTest() {
        assertEquals("https://api.fda.gov/drug/label.json?search=indications_and_usage:cough&limit=10",
                NetworkUtils.buildUrl("indications_and_usage", "cough"));
    }

}