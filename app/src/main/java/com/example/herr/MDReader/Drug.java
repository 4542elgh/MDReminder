package com.example.herr.MDReader;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.Ignore;
import android.support.annotation.NonNull;

@Entity(tableName ="drugs")
// each medication will contain these info:
public class Drug {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private int id;

    @ColumnInfo(name="inactiveIngredient")
    private String inactiveIngredient;

    @ColumnInfo(name="purpose")
    private String purpose;

    @ColumnInfo(name="warnings")
    private String warnings;

    @ColumnInfo(name="questions")
    private String questions;

    @ColumnInfo(name="whenUsing")
    private String whenUsing;

    @NonNull
    @ColumnInfo(name="productNdc")
    private String productNdc;

    @ColumnInfo(name="prodType")
    private String prodType;

    @ColumnInfo(name="route")
    private String route;

    @NonNull
    @ColumnInfo(name="packageNdc")
    private String packageNdc;

    @ColumnInfo(name="brand_name")
    private String brand_name;

    @ColumnInfo(name="manufacturer_name")
    private String manufacturer_name;

    @ColumnInfo(name="version")
    private String version;

    @ColumnInfo(name="dosageAndAdministration")
    private String dosageAndAdministration;

    @ColumnInfo(name="pregnancyOrBreastFeeding")
    private String pregnancyOrBreastFeeding;

    @ColumnInfo(name="stop_use")
    private String stop_use;

    @ColumnInfo(name="do_not_use")
    private String do_not_use;

    @ColumnInfo(name="indicationsAndUsage")
    private String indicationsAndUsage;

    @ColumnInfo(name="activeIngredient")
    private String activeIngredient;

    public Drug(int id,
                String inactiveIngredient, String purpose,
                String warnings, String questions,
                String whenUsing, String productNdc,
                String prodType, String route, String packageNdc,
                String brand_name, String manufacturer_name,
                String version, String dosageAndAdministration,
                String pregnancyOrBreastFeeding, String stop_use,
                String do_not_use, String indicationsAndUsage,
                String activeIngredient) {

        this.id = id;
        this.inactiveIngredient = inactiveIngredient;
        this.purpose = purpose;
        this.warnings = warnings;
        this.questions = questions;
        this.whenUsing = whenUsing;
        this.productNdc = productNdc;
        this.prodType = prodType;
        this.route = route;
        this.packageNdc = packageNdc;
        this.brand_name = brand_name;
        this.manufacturer_name = manufacturer_name;
        this.version = version;
        this.dosageAndAdministration = dosageAndAdministration;
        this.pregnancyOrBreastFeeding = pregnancyOrBreastFeeding;
        this.stop_use = stop_use;
        this.do_not_use = do_not_use;
        this.indicationsAndUsage = indicationsAndUsage;
        this.activeIngredient = activeIngredient;
    }

    public Drug(String inactiveIngredient, String purpose,
                String warnings, String questions,
                String whenUsing, String productNdc,
                String prodType, String route, String packageNdc,
                String brand_name, String manufacturer_name,
                String version, String dosageAndAdministration,
                String pregnancyOrBreastFeeding, String stop_use,
                String do_not_use, String indicationsAndUsage,
                String activeIngredient) {

        this.inactiveIngredient = inactiveIngredient;
        this.purpose = purpose;
        this.warnings = warnings;
        this.questions = questions;
        this.whenUsing = whenUsing;
        this.productNdc = productNdc;
        this.prodType = prodType;
        this.route = route;
        this.packageNdc = packageNdc;
        this.brand_name = brand_name;
        this.manufacturer_name = manufacturer_name;
        this.version = version;
        this.dosageAndAdministration = dosageAndAdministration;
        this.pregnancyOrBreastFeeding = pregnancyOrBreastFeeding;
        this.stop_use = stop_use;
        this.do_not_use = do_not_use;
        this.indicationsAndUsage = indicationsAndUsage;
        this.activeIngredient = activeIngredient;
    }

    // Getter()

    public int getId() { return id; }

    public String getInactiveIngredient() {
        return inactiveIngredient;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getWarnings() {
        return warnings;
    }

    public String getQuestions() {
        return questions;
    }

    public String getWhenUsing() {
        return whenUsing;
    }

    public String getProductNdc() {
        return productNdc;
    }

    public String getProdType() {
        return prodType;
    }

    public String getRoute() {
        return route;
    }

    public String getPackageNdc() {
        return packageNdc;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public String getManufacturer_name() {
        return manufacturer_name;
    }

    public String getVersion() {
        return version;
    }

    public String getDosageAndAdministration() {
        return dosageAndAdministration;
    }

    public String getPregnancyOrBreastFeeding() {
        return pregnancyOrBreastFeeding;
    }

    public String getStop_use() {
        return stop_use;
    }

    public String getDo_not_use() {
        return do_not_use;
    }

    public String getIndicationsAndUsage() {
        return indicationsAndUsage;
    }

    public String getActiveIngredient() {
        return activeIngredient;
    }

    // Setter()
    public void setId(int id) { this.id = id; }

    public void setInactiveIngredient(String inactiveIngredient) {
        this.inactiveIngredient = inactiveIngredient;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setWarnings(String warnings) {
        this.warnings = warnings;
    }

    public void setQuestions(String questions) {
        this.questions = questions;
    }

    public void setWhenUsing(String whenUsing) {
        this.whenUsing = whenUsing;
    }

    public void setProductNdc(String productNdc) {
        this.productNdc = productNdc;
    }

    public void setProdType(String prodType) {
        this.prodType = prodType;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public void setPackageNdc(String packageNdc) {
        this.packageNdc = packageNdc;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public void setManufacturer_name(String manufacturer_name) {
        this.manufacturer_name = manufacturer_name;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public void setDosageAndAdministration(String dosageAndAdministration) {
        this.dosageAndAdministration = dosageAndAdministration;
    }

    public void setPregnancyOrBreastFeeding(String pregnancyOrBreastFeeding) {
        this.pregnancyOrBreastFeeding = pregnancyOrBreastFeeding;
    }

    public void setStop_use(String stop_use) {
        this.stop_use = stop_use;
    }

    public void setDo_not_use(String do_not_use) {
        this.do_not_use = do_not_use;
    }

    public void setIndicationsAndUsage(String indicationsAndUsage) {
        this.indicationsAndUsage = indicationsAndUsage;
    }

    public void setActiveIngredient(String activeIngredient) {
        this.activeIngredient = activeIngredient;
    }
}
