package com.example.budgetawaydb.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "airports")
public class Airport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "departureAirport")
    @Cascade(org.hibernate.annotations.CascadeType.DELETE)
//    @JsonIgnoreProperties({"departureAirport"})
    @JsonBackReference
    private List<Flight> flights;

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    public Airport(String name, Country country) {
        this.name = name;
        this.flights = new ArrayList<>();
        this.country = country;
    }

    public Airport() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }
}
