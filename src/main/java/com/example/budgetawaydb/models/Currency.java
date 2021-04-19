package com.example.budgetawaydb.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "currencies")
public class Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "countries_currencies",
            joinColumns = { @JoinColumn(
                    name = "currency_id",
                    nullable = false,
                    updatable = false)
            },
            inverseJoinColumns = { @JoinColumn(
                    name = "country_id",
                    nullable = false,
                    updatable = false)
            }
    )
    private List<Country> countries;

    public Currency(String name, ArrayList<Country> countries) {
        this.name = name;
        this.countries = countries;
    }

    public Currency(String name){
        this.name = name;
    }

    public Currency(){}

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

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }
}
