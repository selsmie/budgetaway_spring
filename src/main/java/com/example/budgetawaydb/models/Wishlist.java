package com.example.budgetawaydb.models;


import javax.persistence.*;

@Entity
@Table(name = "wishlists")
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "depAirport")
    private String depAirport;

    @Column(name = "arrAirport")
    private String arrAirport;

    @Column(name = "duration")
    private double duration;

    @Column(name = "price")
    private double price;

    public Wishlist(String name, String depAirport, String arrAirport, double duration, double price) {
        this.name = name;
        this.depAirport = depAirport;
        this.arrAirport = arrAirport;
        this.duration = duration;
        this.price = price;
    }

    public Wishlist() {
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

    public String getDepAirport() {
        return depAirport;
    }

    public void setDepAirport(String depAirport) {
        this.depAirport = depAirport;
    }

    public String getArrAirport() {
        return arrAirport;
    }

    public void setArrAirport(String arrAirport) {
        this.arrAirport = arrAirport;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
