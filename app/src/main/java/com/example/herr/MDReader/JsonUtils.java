package com.example.herr.MDReader;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static ArrayList<Drug> getDrugRepository(String json) {

        ArrayList<Drug> drugRepository = new ArrayList<>();

        try {
            JSONObject mainJsonObject = new JSONObject(json);

            // get json array where name = "results"
            JSONArray fields = mainJsonObject.getJSONArray("results");

            for (int i = 0; i < fields.length(); i++) {

                // get object at the index
                JSONObject field = fields.getJSONObject(i);

                // add each field into the drug repository
                drugRepository.add( new Drug (
                        field.getString("inactive_ingredient"),
                        field.getString("pupose"),
                        field.getString("warnings"),
                        field.getString("questions"),
                        field.getString("when_using"),
                        field.getString("product_ndc"),
                        field.getString("product_type"),
                        field.getString("route"),
                        field.getString("package_ndc"),
                        field.getString("brand_name"),
                        field.getString("manufacturer_name"),
                        field.getString("version"),
                        field.getString("dosage_and_administration"),
                        field.getString("pregnancy_or_breast_feeding"),
                        field.getString("stop_use"),
                        field.getString("do_not_use"),
                        field.getString("indications_and_usage"),
                        field.getString("active_ingredients")
                ));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }

        return drugRepository;
    }
}