package com.example.herr.MDReader;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class JsonUtils {

    public static ArrayList<Drug> getDrugList(String json) {

        ArrayList<Drug> drugList = new ArrayList<>();

        try {
            JSONObject jsonRespond = new JSONObject(json);

            // get json array where name = "results"
            JSONArray fields = jsonRespond.getJSONArray("results");

            for (int i = 0; i < fields.length(); i++) {

                // get object at the index
                JSONObject field = fields.getJSONObject(i);

                for (int j = 0; j < field.names().length(); j++) {
                    Log.d("arrayName",field.names().getString(j));
                }

                String inactive_ingredient = "N/A";
                if (field.has("inactive_ingredient")){
                    inactive_ingredient = "";
                    JSONArray subFields = field.getJSONArray("inactive_ingredient");
//                    active_ingredients =  field.getString("active_ingredients");
                    for (int j = 0; j < subFields.length(); j++) {
                        inactive_ingredient += "\n\u2022\u0009    "+subFields.getJSONObject(j).toString();
                    }
                }

//                String warnings = "N/A";
//                if (field.has("warnings")){
//                    warnings =  field.getString("warnings");
//                }
                String warnings = "N/A";
                if (field.has("warnings")){
                    warnings = "";
                    JSONArray subFields = field.getJSONArray("warnings");
//                    active_ingredients =  field.getString("active_ingredients");
                    for (int j = 0; j < subFields.length(); j++) {
                        warnings += "\n\u2022\u0009    "+subFields.getJSONObject(j).getString("warnings")
                                + "    "
                                + subFields.getJSONObject(j).toString();
                    }
                }

                String when_using = "N/A";
                if (field.has("when_using")){
                    when_using =  field.getString("when_using");
                }

                String product_ndc = "N/A";
                if (field.has("product_ndc")){
                    product_ndc =  field.getString("product_ndc");
                }

                String product_type = "N/A";
                if (field.has("product_type")){
                    product_type =  field.getString("product_type");
                }

                String route = "N/A";
                if (field.has("route")){
                    route = "";
                    JSONArray subFields = field.getJSONArray("route");
                    for (int j = 0; j < subFields.length(); j++) {
                        route += "\n\u2022\u0009    "+subFields.get(j);
                    }
                }

//                String package_ndc = "N/A";
//                if (field.has("package_ndc")){
//                    package_ndc =  field.getString("package_ndc");
//                }
                String package_ndc = "N/A";
                if (field.has("package_ndc")){
                    route = "";
                    JSONArray subFields = field.getJSONArray("package_ndc");
                    for (int j = 0; j < subFields.length(); j++) {
                        route += "\n\u2022\u0009    "+subFields.get(j);
                    }
                }

                String brand_name = "N/A";
                if (field.has("brand_name")){
                    brand_name =  field.getString("brand_name");
                }

                String dosage_and_administration = "N/A";
                if (field.has("dosage_and_administration")){
                    dosage_and_administration =  field.getString("dosage_and_administration");
                }

                String pregnancy_or_breast_feeding = "N/A";
                if (field.has("pregnancy_or_breast_feeding")){
                    pregnancy_or_breast_feeding =  field.getString("pregnancy_or_breast_feeding");
                }

                String stop_use = "N/A";
                if (field.has("stop_use")){
                    stop_use =  field.getString("stop_use");
                }

                String do_not_use = "N/A";
                if (field.has("do_not_use")){
                    do_not_use =  field.getString("do_not_use");
                }

                String indications_and_usage = "N/A";
                if (field.has("indications_and_usage")){
                    indications_and_usage =  field.getString("indications_and_usage");
                }

                String active_ingredients = "N/A";
                if (field.has("active_ingredients")){
                    active_ingredients = "";
                    JSONArray subFields = field.getJSONArray("active_ingredients");
//                    active_ingredients =  field.getString("active_ingredients");
                    for (int j = 0; j < subFields.length(); j++) {
                        active_ingredients += "\n\u2022\u0009    "+subFields.getJSONObject(j).getString("name") + "    " + subFields.getJSONObject(j).getString("strength");
                    }
                }

                // add each field into the drug repository
                drugList.add( new Drug (
                        inactive_ingredient,
                        warnings,
                        when_using,
                        product_ndc,
                        product_type,
                        route,
                        package_ndc,
                        brand_name,
                        dosage_and_administration,
                        pregnancy_or_breast_feeding,
                        stop_use,
                        do_not_use,
                        indications_and_usage,
                        active_ingredients
                ));
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return drugList;
    }
}