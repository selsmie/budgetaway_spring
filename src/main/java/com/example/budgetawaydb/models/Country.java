package com.example.budgetawaydb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "countries")
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "flag")
    private String flag;

    @Column(name = "region")
    private String region;

    @Column(name = "currencies")
    private ArrayList<String> currencies;

    @Column(name = "languages")
    private ArrayList<String> languages;

    @Column(name = "coordinates")
    private ArrayList<int> coords;

   @OneToMany(mappedBy = "airport")
   @JsonBackReference
   @Cascade(org.hibernate.annotations.CascadeType.DELETE)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
