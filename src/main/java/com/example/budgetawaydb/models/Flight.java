package com.example.budgetawaydb.models;

import java.util.Date;

public class Flight {

    private Long Id;

    private String airline;

    private Date arrivalTime;

    private Date departureTime;

    private double price;

    public Flight(Long id, String airline, Date arrivalTime, Date departureTime) {
        Id = id;
        this.airline = airline;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
    }

    public Flight() {

    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
