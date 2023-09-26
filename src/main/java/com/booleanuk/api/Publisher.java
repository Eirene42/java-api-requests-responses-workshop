package com.booleanuk.api;

public class Publisher {
    private String name;
    private String city;

    public Publisher(String name, String city) {
        this.name = name;
        this.city = city;
    }

    public Publisher(String name) {
        this.name = name;
        this.city = "Unknown";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
