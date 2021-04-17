package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(value = "/countries")
    public ResponseEntity getAllCountriesAndFilters(
            @RequestParam(required = false, name="region") String region,
            @RequestParam(required = false, name="language") String language
            ){
        if (region != null && language != null) {
            return new ResponseEntity(countryRepository.findByRegionAndLanguage(region, language), HttpStatus.OK);
        }
        if (region != null) {
            return new ResponseEntity(countryRepository.findByRegion(region), HttpStatus.OK);
        }
        if (language != null) {
            return new ResponseEntity(countryRepository.findByLanguage(language), HttpStatus.OK);
        }
        return new ResponseEntity(countryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/countries/{id}")
    public ResponseEntity getCountry(@PathVariable Long id){
        return new ResponseEntity(countryRepository.findById(id), HttpStatus.OK);
    }

}
