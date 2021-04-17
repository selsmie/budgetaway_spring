package com.example.budgetawaydb.models;

import java.util.ArrayList;

public class Country {

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    private Long id;

    private String name;

    private String flag;

    private String region;

    private ArrayList<String> currencies;

    private ArrayList<String> languages;

    private ArrayList<int> coords;

    private ArrayList<Airport> airports;

    public Country(Long id, String name, String flag, String region, ArrayList<String> currencies, ArrayList<String> languages, ArrayList<int> coords) {
        this.id = id;
        this.name = name;
        this.flag = flag;
        this.region = region;
        this.currencies = currencies;
        this.languages = languages;
        this.coords = coords;
        this.airports = airports;
    }

    public Country(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public ArrayList<String> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(ArrayList<String> currencies) {
        this.currencies = currencies;
    }

    public ArrayList<String> getLanguages() {
        return languages;
    }

    public void setLanguages(ArrayList<String> languages) {
        this.languages = languages;
    }

    public ArrayList<int> getCoords() {
        return coords;
    }

    public void setCoords(ArrayList<int> coords) {
        this.coords = coords;
    }

    public ArrayList<String> getAirports() {
        return airports;
    }

    public void setAirports(ArrayList<String> airports) {
        this.airports = airports;
    }
}
