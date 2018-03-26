package com.essths.android.model;

/**
 * Created by asus on 11/03/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ticket{
    public ticket(String sujet, String date, String place) {
        this.sujet = sujet;
        this.date = date;
        this.place = place;
    }

    @SerializedName("propritere")
    @Expose
    private List<Propritere> propritere = null;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("sujet")
    @Expose
    private String sujet;
    @SerializedName("date")
    @Expose
    private String date;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("place")
    @Expose
    private String place;
    @SerializedName("price")
    @Expose
    private String price;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public List<Propritere> getPropritere() {
        return propritere;
    }

    public void setPropritere(List<Propritere> propritere) {
        this.propritere = propritere;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }

}