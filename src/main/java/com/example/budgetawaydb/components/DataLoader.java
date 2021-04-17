package com.example.budgetawaydb.components;

import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.models.Flight;
import com.example.budgetawaydb.repositories.AirportRepository;
import com.example.budgetawaydb.repositories.CountryRepository;
import com.example.budgetawaydb.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    FlightRepository flightRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Country country1 = new Country("England", "Flag", "Europe");
        countryRepository.save(country1);

        Airport airport1 = new Airport("Leeds Bradford", country1);
        airportRepository.save(airport1);

        Airport airport2 = new Airport("Heathrow", country1);
        airportRepository.save(airport2);

        Flight flight1 = new Flight("British Airways", airport1, airport2);
        flightRepository.save(flight1);
    }
}
