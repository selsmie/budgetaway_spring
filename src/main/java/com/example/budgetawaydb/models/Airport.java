package com.example.budgetawaydb.models;

import javax.persistence.Id;
import java.util.ArrayList;

public class Airport {

    private Long Id;

    private String name;

    private ArrayList<String> flights;

    public Airport(String name, Long id) {
        this.name = name;
        Id = id;
        this.flights = flights;
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

    public ArrayList<String> getFlights() {
        return flights;
    }

    public void setFlights(ArrayList<String> flights) {
        this.flights = flights;
    }
}
