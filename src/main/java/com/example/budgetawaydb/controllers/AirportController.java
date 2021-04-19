package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.repositories.AirportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PutMapping(value = "airports/{id}")
    public ResponseEntity<Airport> putAirport(@RequestBody Airport airport, @PathVariable Long id) {
        Airport foundAirport = airportRepository.findById(id).get();
        foundAirport.setName(airport.getName());
        airportRepository.save(foundAirport);
        return new ResponseEntity<>(foundAirport, HttpStatus.OK);
    }

    @PostMapping("/airports")
    public ResponseEntity<List<Airport>> postAirport(@RequestBody List<Airport> airports) {
        airportRepository.saveAll(airports);
        return new ResponseEntity<>(airports, HttpStatus.CREATED);
    }


    @DeleteMapping(value = "/airports/{id}")
    public ResponseEntity<List<Airport>> deleteCountry(@PathVariable Long id) {
        airportRepository.deleteById(id);
        return new ResponseEntity<>(airportRepository.findAll(), HttpStatus.OK);
    }
}
