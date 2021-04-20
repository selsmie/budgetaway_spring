package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.models.Language;
import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.repositories.CountryRepository;
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
        CacheService.languageSaving(countries);
        CacheService.currencySaving(countries);
        CacheService.airportSaving(countries);
        countryRepository.saveAll(countries);
        return new ResponseEntity<>(countries, HttpStatus.CREATED);
    }

    @DeleteMapping(value = "/countries/{id}")
    public ResponseEntity<List<Country>> deleteCountry(@PathVariable Long id) {
        countryRepository.deleteById(id);
        return new ResponseEntity<>(countryRepository.findAll(), HttpStatus.OK);
    }



}
