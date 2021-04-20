package com.example.budgetawaydb.services;

import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.models.Currency;
import com.example.budgetawaydb.models.Language;
import com.example.budgetawaydb.repositories.AirportRepository;
import com.example.budgetawaydb.repositories.CurrencyRepository;
import com.example.budgetawaydb.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class CacheService {

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    AirportRepository airportRepository;

    private List<Country> countries;

    public CacheService(List<Country> countries) {
        this.countries = countries;
    }

    public List<Country> getCountries() {
        return countries;
    }

    public void setCountries(List<Country> countries) {
        this.countries = countries;
    }

    public void languageSaving(List<Country> countries) {
        countries.forEach((newCountry) -> {
            List<Language>  languages = newCountry.getLanguages();
            List<Language> dbLanguages = new ArrayList<>();
            languages.forEach((language) -> {
                if (languageRepository.findOneByNameIgnoreCase(language.getName()) != null){
                    dbLanguages.add(languageRepository.findOneByNameIgnoreCase(language.getName()));
                } else {
                    languageRepository.save(language);
                    dbLanguages.add(languageRepository.findOneByNameIgnoreCase(language.getName()));
                }
            });
            newCountry.setLanguages(dbLanguages);
        });
    }

    public void currencySaving(List<Country> countries) {
        countries.forEach((newCountry) -> {
            List<Currency>  currencies = newCountry.getCurrencies();
            List<Currency> dbCurrencies = new ArrayList<>();
            currencies.forEach((currency) -> {
                if (currencyRepository.findOneByNameIgnoreCase(currency.getName()) != null){
                    dbCurrencies.add(currencyRepository.findOneByNameIgnoreCase(currency.getName()));
                } else {
                    currencyRepository.save(currency);
                    dbCurrencies.add(currencyRepository.findOneByNameIgnoreCase(currency.getName()));
                }
            });
            newCountry.setCurrencies(dbCurrencies);
        });
    }

    public void airportSaving(List<Country> countries) {
        countries.forEach((newCountry) -> {
            List<Airport>  airports = newCountry.getAirports();
            List<Airport> dbAirports = new ArrayList<>();
            airports.forEach((airport) -> {
                if (airportRepository.findOneByNameIgnoreCase(airport.getName()) != null){
                    dbAirports.add(airportRepository.findOneByNameIgnoreCase(airport.getName()));
                } else {
                    airportRepository.save(airport);
                    dbAirports.add(airportRepository.findOneByNameIgnoreCase(airport.getName()));
                }
            });
            newCountry.setAirports(dbAirports);
        });
    }
}
