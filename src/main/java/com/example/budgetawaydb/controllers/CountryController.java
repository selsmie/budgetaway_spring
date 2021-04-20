package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.models.Currency;
import com.example.budgetawaydb.models.Language;
import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.repositories.AirportRepository;
import com.example.budgetawaydb.repositories.CountryRepository;
import com.example.budgetawaydb.repositories.CurrencyRepository;
import com.example.budgetawaydb.repositories.LanguageRepository;
import com.example.budgetawaydb.services.CacheService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @Autowired
    LanguageRepository languageRepository;

    @Autowired
    CurrencyRepository currencyRepository;

    @Autowired
    AirportRepository airportRepository;

    @GetMapping(value = "/countries")
    public ResponseEntity getAllCountriesAndFilters(
            @RequestParam(required = false, name="region") String region,
            @RequestParam(required = false, name="language") String language
            ) {
        if (region != null && language != null) {
            return new ResponseEntity(countryRepository.findByRegionAndLanguagesNameAllIgnoreCase(region, language), HttpStatus.OK);
        }
        if (region != null) {
            return new ResponseEntity(countryRepository.findByRegionIgnoreCase(region), HttpStatus.OK);
        }
        if (language != null) {
            return new ResponseEntity(countryRepository.findByLanguagesNameIgnoreCase(language), HttpStatus.OK);
        }
        return new ResponseEntity(countryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/countries/{id}")
    public ResponseEntity getCountry(@PathVariable Long id){
        return new ResponseEntity(countryRepository.findById(id), HttpStatus.OK);
    }

    @PutMapping(value = "countries/{id}")
    public ResponseEntity<Country> putCountry(@RequestBody Country country, @PathVariable Long id){
        Country foundCountry = countryRepository.findById(id).get();
        foundCountry.setName(country.getName());
        countryRepository.save(foundCountry);
        return new ResponseEntity<>(foundCountry, HttpStatus.OK);
    }

    @PostMapping("/countries")
    public ResponseEntity<List<Country>> postCountry(@RequestBody List<Country> countries) {
//        CacheService cacheService = new CacheService(countries);
//        cacheService.languageSaving();
//        cacheService.currencySaving();
//        cacheService.airportSaving();
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
        countryRepository.saveAll(countries);
        countries.forEach((newCountry) -> {
            List<Airport>  airports = newCountry.getAirports();
            List<Airport> dbAirports = new ArrayList<>();
            airports.forEach((airport) -> {
                if (airportRepository.findOneByNameIgnoreCase(airport.getName()) != null){
                    dbAirports.add(airportRepository.findOneByNameIgnoreCase(airport.getName()));
                } else {
                    airport.setCountry(newCountry);
                    airportRepository.save(airport);
                    dbAirports.add(airportRepository.findOneByNameIgnoreCase(airport.getName()));
                }
            });
            newCountry.setAirports(dbAirports);
        });
        return new ResponseEntity<>(countries, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/countries/{id}")
    public ResponseEntity<List<Country>> deleteCountry(@PathVariable Long id) {
        countryRepository.deleteById(id);
        return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
    }



}
