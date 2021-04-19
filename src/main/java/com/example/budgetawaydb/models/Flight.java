package com.example.budgetawaydb.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "flights")
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(name = "airline")
    private String airline;

    @Column(name = "arrival_time")
    private Date arrivalTime;

    @Column(name = "departure_time")
    private Date departureTime;

    @Column(name = "price")
    private double price;

    @ManyToOne
    @JoinColumn(name = "arrivalAirport_id", nullable = false)
    private Airport arrivalAirport;

    @ManyToOne
    @JoinColumn(name = "departureAirport_id", nullable = false)
    private Airport departureAirport;

    public Flight(String airline, Date arrivalTime, Date departureTime, Airport arrivalAirport, Airport departureAirport) {
        this.airline = airline;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;
    }

    public Flight (String airline, Airport arrivalAirport, Airport departureAirport){
        this.airline = airline;
        this.arrivalAirport = arrivalAirport;
        this.departureAirport = departureAirport;

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

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }
}
