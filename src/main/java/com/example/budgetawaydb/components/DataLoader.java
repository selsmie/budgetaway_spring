package com.example.budgetawaydb.components;

import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.models.Flight;
import com.example.budgetawaydb.models.Language;
import com.example.budgetawaydb.repositories.AirportRepository;
import com.example.budgetawaydb.repositories.CountryRepository;
import com.example.budgetawaydb.repositories.FlightRepository;
import com.example.budgetawaydb.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    AirportRepository airportRepository;

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    LanguageRepository languageRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Language language2 = new Language("english");
        ArrayList<Language> englandLanguages = new ArrayList<>();
        englandLanguages.add(language2 );

        Country country1 = new Country("England","flag","Europe", englandLanguages, 10, 14);
        countryRepository.save(country1);

         Airport airport1 = new Airport("Leeds Bradford", country1);
        airportRepository.save(airport1);

        Airport airport2 = new Airport("Heathrow", country1);
        airportRepository.save(airport2);

        Flight flight1 = new Flight("British Airways", airport1, airport2);
        flightRepository.save(flight1);

        Language language1 = new Language("spanish");
        ArrayList<Language> randomLanguages = new ArrayList<>();
        randomLanguages.add(language1);

        Country country2 = new Country("Scotland","flag","Europe",randomLanguages, 10, 14);
        countryRepository.save(country2);
    }
}
