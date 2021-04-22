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

    @ManyToMany(cascade=CascadeType.ALL)
    @JoinTable(
            name = "countries_currencies",
            joinColumns = { @JoinColumn(
                    name = "country_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "currency_id",
                    nullable = false,
                    updatable = false)
            }
    )
    private List<Currency> currencies;

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

    @Column(name = "latitude")
    private double latitude;

    @Column(name = "longitude")
    private double longitude;

    @Column(name = "timezone")
    private int timezone;

   @OneToMany(mappedBy = "country")
   @JsonIgnoreProperties({"country"})
   @Cascade(org.hibernate.annotations.CascadeType.DELETE)
   private List<Airport> airports;

    public Country(String name, String flag, String region, ArrayList<Currency> currencies, ArrayList<Language> languages, double latitude, double longitude, ArrayList<Airport> airports, int timezone) {
        this.name = name;
        this.flag = flag;
        this.region = region;
        this.currencies = currencies;
        this.languages = languages;
        this.latitude = latitude;
        this.longitude = longitude;
        this.airports = airports;
        this.timezone = timezone;
    }

    public Country(String name, String flag, String region, ArrayList<Currency> currencies, ArrayList<Language> languages, int latitude, int longitude){
        this.name = name;
        this.flag = flag;
        this.region = region;
        this.languages = languages;
        this.currencies = currencies;
        this.latitude = latitude;
        this.longitude = longitude;

    }

    public Country() {}

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

    public List<Currency> getCurrencies() {
        return currencies;
    }

    public void setCurrencies(List<Currency> currencies) {
        this.currencies = currencies;
    }

    public List<Language> getLanguages() {
        return languages;
    }

    public void setLanguages(List<Language> languages) {
        this.languages = languages;
    }


    public List<Airport> getAirports() {
        return airports;
    }

    public void setAirports(List<Airport> airports) {
        this.airports = airports;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getTimezone() {
        return timezone;
    }

    public void setTimezone(int timezone) {
        this.timezone = timezone;
    }
}
