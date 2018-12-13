package com.example.herr.MDReader;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class JsonUtilsUnitTest {
    @Test
    public void createJsonRepoTest() {
        assertEquals("",
                JsonUtils.getDrugRepository("https://api.fda.gov/drug/label.json?search=indications_and_usage=cough&limit=10"));
    }


}