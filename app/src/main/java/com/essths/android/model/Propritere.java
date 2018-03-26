package com.essths.android.model;

/**
 * Created by asus on 11/03/2018.
 */

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Propritere {

    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("valable")
    @Expose
    private Boolean valable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Boolean getValable() {
        return valable;
    }

    public void setValable(Boolean valable) {
        this.valable = valable;
    }

}