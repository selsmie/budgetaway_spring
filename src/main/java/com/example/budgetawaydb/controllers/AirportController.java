package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AirportController {

    @Autowired
    AirportRepository airportRepository;

    @GetMapping(value = "/airports")
    public ResponseEntity getAllAirports() {
        return new ResponseEntity(airportRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/airports/{id}")
    public ResponseEntity getAirport(@PathVariable Long id ) {
        return new ResponseEntity(airportRepository.findById(id), HttpStatus.OK);
    }
}
