package com.example.budgetawaydb.controllers;


import com.example.budgetawaydb.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public class FlightController {

    @Autowired
    FlightRepository flightRepository;

    @GetMapping(value = "/flights")
    public ResponseEntity getAllFlights() {
        return new ResponseEntity(flightRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/flights/{id}")
    public ResponseEntity getFlight(@PathVariable Long id ) {
        return new ResponseEntity(flightRepository.findById(id), HttpStatus.OK);
    }
}
