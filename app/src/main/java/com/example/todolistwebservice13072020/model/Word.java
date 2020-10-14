package com.example.todolistwebservice13072020.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Word {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("en")
    @Expose
    private String en;
    @SerializedName("vn")
    @Expose
    private String vn;
    @SerializedName("ismemorized")
    @Expose
    private Integer ismemorized;

    public Word() {
    }

    public Word(String en, String vn, Integer ismemorized) {
        this.en = en;
        this.vn = vn;
        this.ismemorized = ismemorized;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEn() {
        return en;
    }

    public void setEn(String en) {
        this.en = en;
    }

    public String getVn() {
        return vn;
    }

    public void setVn(String vn) {
        this.vn = vn;
    }

    public Integer getIsmemorized() {
        return ismemorized;
    }

    public void setIsmemorized(Integer ismemorized) {
        this.ismemorized = ismemorized;
    }
}
