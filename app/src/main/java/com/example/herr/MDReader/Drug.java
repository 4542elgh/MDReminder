package com.example.herr.MDReader;

// create the Drug model
public class Drug {
    String active_ingredient = "active_ingredient";
    String inactive_ingredient = "inactive_ingredient";
    String manufacturer_name = "manufacturer_name";
    String product_type = "product_type";
    String route = "route";
    String brand_name = "brand_name";
    String product_ndc = "product_ndc";
    String package_ndc = "package_ndc";
    String warnings = "warnings";
    String dosage_and_administration = "dosage_and_administration";
    String stop_use = "stop_use";
    String purpose = "purpose";
    String questions = "questions";
    String when_using = "when_using";
    String indications_and_usage = "indications_and_usage";

    // Drug constructor
    public Drug(String active_ingredient, String inactive_ingredient,
                String manufacturer_name, String product_type,
                String route, String brand_name, String product_ndc,
                String package_ndc, String warnings, String dosage_and_administration,
                String stop_use, String purpose, String questions,
                String when_using, String indications_and_usage) {

        this.active_ingredient = active_ingredient;
        this.inactive_ingredient = inactive_ingredient;
        this.manufacturer_name = manufacturer_name;
        this.product_type = product_type;
        this.route = route;
        this.brand_name = brand_name;
        this.product_ndc = product_ndc;
        this.package_ndc = package_ndc;
        this.warnings = warnings;
        this.dosage_and_administration = dosage_and_administration;
        this.stop_use = stop_use;
        this.purpose = purpose;
        this.questions = questions;
        this.when_using = when_using;
        this.indications_and_usage = indications_and_usage;
    }

    // Drug Getter()
    public String getActive_ingredient() {
        return active_ingredient;
    }

    public String getInactive_ingredient() {
        return inactive_ingredient;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public String getProduct_type() {
        return product_type;
    }

    public String getRoute() {
        return route;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getProduct_ndc() {
        return product_ndc;
    }

    public String getPackage_ndc() {
        return package_ndc;
    }

    public String getWarnings() {
        return warnings;
    }

    public String getDosage_and_administration() {
        return dosage_and_administration;
    }

    public String getStop_use() {
        return stop_use;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getQuestions() {
        return questions;
    }

    public String getWhen_using() {
        return when_using;
    }

    public String getIndications_and_usage() {
        return indications_and_usage;
    }

    // Drug Setter()
    public void setActive_ingredient(String active_ingredient) {
        this.active_ingredient = active_ingredient;
    }

    public void setInactive_ingredient(String inactive_ingredient) {
        this.inactive_ingredient = inactive_ingredient;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public void setProduct_ndc(String product_ndc) {
        this.product_ndc = product_ndc;
    }

    public void setPackage_ndc(String package_ndc) {
        this.package_ndc = package_ndc;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public void setDosage_and_administration(String dosage_and_administration) {
        this.dosage_and_administration = dosage_and_administration;
    }

    public void setStop_use(String stop_use) {
        this.stop_use = stop_use;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setWhen_using(String when_using) {
        this.when_using = when_using;
    }

    public void setIndications_and_usage(String indications_and_usage) {
        this.indications_and_usage = indications_and_usage;
    }
}
