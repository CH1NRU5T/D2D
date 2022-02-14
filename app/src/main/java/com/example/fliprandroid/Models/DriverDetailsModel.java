package com.example.fliprandroid.Models;

public class DriverDetailsModel {

    private String name;
    private int experience;
    private int mobile;
    private String fromCity1;
    private String toCity1;
    private String fromCity2;
    private String toCity2;
    private String fromCity3;
    private String toCity3;

    public DriverDetailsModel(String name, int experience, int mobile, String fromCity1, String toCity1, String fromCity2, String toCity2, String fromCity3, String toCity3) {
        this.name = name;
        this.experience = experience;
        this.mobile = mobile;
        this.fromCity1 = fromCity1;
        this.toCity1 = toCity1;
        this.fromCity2 = fromCity2;
        this.toCity2 = toCity2;
        this.fromCity3 = fromCity3;
        this.toCity3 = toCity3;
    }

    public String getName() {
        return name;
    }

    public int getExperience() {
        return experience;
    }

    public int getMobile() {
        return mobile;
    }

    public String getFromCity1() {
        return fromCity1;
    }

    public String getToCity1() {
        return toCity1;
    }

    public String getFromCity2() {
        return fromCity2;
    }

    public String getToCity2() {
        return toCity2;
    }

    public String getFromCity3() {
        return fromCity3;
    }

    public String getToCity3() {
        return toCity3;
    }
}
