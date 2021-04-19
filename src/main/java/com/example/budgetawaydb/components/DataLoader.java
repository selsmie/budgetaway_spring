package com.example.budgetawaydb.components;

import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.models.Flight;
import com.example.budgetawaydb.models.Language;
import com.example.budgetawaydb.models.Currency;
import com.example.budgetawaydb.repositories.*;
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

    @Autowired
    CurrencyRepository currencyRepository;


    public DataLoader() {

    }

    public void run(ApplicationArguments args) {

        Currency currency1 = new Currency("pound");
//        currencyRepository.save(currency1);
        ArrayList<Currency> englandCurrency = new ArrayList<>();
        englandCurrency.add(currency1 );

        Language language2 = new Language("english");
//        languageRepository.save(language2);
        ArrayList<Language> englandLanguages = new ArrayList<>();
        englandLanguages.add(language2 );

        Country country1 = new Country("England","flag","Europe", englandCurrency, englandLanguages, 10, 14);
        countryRepository.save(country1);

         Airport airport1 = new Airport("Leeds Bradford", country1);
        airportRepository.save(airport1);

        Airport airport2 = new Airport("Heathrow", country1);
        airportRepository.save(airport2);

        Flight flight1 = new Flight("British Airways", airport1, airport2);
        flightRepository.save(flight1);

        Currency currency2 = new Currency("pound");
//        currencyRepository.save(currency1);
        ArrayList<Currency> englandCurrency2 = new ArrayList<>();
        englandCurrency2.add(currency2 );

        Language language1 = new Language("spanish");
        ArrayList<Language> randomLanguages = new ArrayList<>();
        randomLanguages.add(language1);

        Country country2 = new Country("Scotland","flag", "Europe", englandCurrency2, randomLanguages, 10, 14);
        countryRepository.save(country2);
    }
}
