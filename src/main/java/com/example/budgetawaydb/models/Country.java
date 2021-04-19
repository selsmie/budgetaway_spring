package com.example.budgetawaydb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "countries_languages",
            joinColumns = { @JoinColumn(
                    name = "country_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "language_id",
                    nullable = false,
                    updatable = false)
            }
    )
    private List<Language> languages;

    private int latitude;

    private int longitude;

   @OneToMany(mappedBy = "country")
   @JsonIgnoreProperties({"country"})
   @Cascade(org.hibernate.annotations.CascadeType.DELETE)
   private List<Airport> airports;

    public Country(String name, String flag, String region, ArrayList<String> currencies, List<Language> languages, int latitude, int longitude, List<Airport> airports) {
        this.name = name;
        this.flag = flag;
        this.region = region;
        this.currencies = currencies;
        this.languages = languages;
        this.latitude = latitude;
        this.longitude = longitude;
        this.airports = airports;
    }

    public Country(String name, String flag, String region, ArrayList<Language> languages, int latitude, int longitude){
        this.name = name;
        this.flag = flag;
        this.region = region;
        this.languages = languages;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }

    public int getLatitude() {
        return latitude;
    }

    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }

    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

}
