package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class CountryController {

    @Autowired
    CountryRepository countryRepository;

    @GetMapping(value = "/countries")
    public ResponseEntity getAllCountries(){
        return new ResponseEntity(countryRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/countries/{id}")
    public ResponseEntity getCountry(@PathVariable Long id){
        return new ResponseEntity(countryRepository.findById(id), HttpStatus.OK);
    }

}
