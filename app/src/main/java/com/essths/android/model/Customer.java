package com.essths.android.model;

/**
 * Created by asus on 08/03/2018.
 */


import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Customer{


    @SerializedName("tickets")
    @Expose
    private List<String> tickets = null;
    @SerializedName("updated_date")
    @Expose
    private String updatedDate;
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("prenom")
    @Expose
    private String prenom;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("pay")
    @Expose
    private String pay;
    @SerializedName("state")
    @Expose
    private String state;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("date_naiss")
    @Expose
    private String dateNaiss;
    @SerializedName("imgUrl")
    @Expose
    private String imgUrl;
    @SerializedName("__v")
    @Expose
    private Integer v;

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }

    public String getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(String updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getPay() {
        return pay;
    }

    public void setPay(String pay) {
        this.pay = pay;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDateNaiss() {
        return dateNaiss;
    }

    public void setDateNaiss(String dateNaiss) {
        this.dateNaiss = dateNaiss;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getV() {
        return v;
    }

    public void setV(Integer v) {
        this.v = v;
    }
}