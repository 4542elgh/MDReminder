package com.example.herr.MDReader;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class NetworkUtilsUnitTest {
    @Test
    public void addition_isCorrect() {

        assertEquals(4, 2 + 2);
    }

    @Test
    public void encodeUrlTest() {

        assertEquals("https://api.fda.gov/drug/label.json?search=indications_and_usage%3Acough%26limit%3D10",
                NetworkUtils.encodeUrl("cough"));
    }

    @Test
    public void decodeUrlTest() {
        assertEquals("https://api.fda.gov/drug/label.json?search=indications_and_usage:cough&limit=10",
                NetworkUtils.decodeUrl("https://api.fda.gov/drug/label.json?search=indications_and_usage%3Acough%26limit%3D10"));
    }

}