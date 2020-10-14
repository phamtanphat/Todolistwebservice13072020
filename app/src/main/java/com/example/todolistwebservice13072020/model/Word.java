package com.example.todolistwebservice13072020.model;

public class Word {

    private String id;
    private String en;
    private String vn;
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
