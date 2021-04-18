package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.models.Flight;
import com.example.budgetawaydb.repositories.FlightRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
import java.util.List;

@RestController
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

    @PostMapping(value = "/flights")
    public ResponseEntity<List<Flight>> postFlight(@RequestBody List<Flight> flights) {
        flightRepository.saveAll(flights);
        return new ResponseEntity<>(flights, HttpStatus.CREATED);
    }

    @PutMapping(value = "/flights/{id}")
    public ResponseEntity<Flight> putFlight(@RequestBody Flight flight, @PathVariable Long id) {
        Flight foundFlight = flightRepository.findById(id).get();
        foundFlight.setAirline(flight.getAirline());
        flightRepository.save(foundFlight);
        return new ResponseEntity<>(foundFlight, HttpStatus.OK);
    }

    @DeleteMapping(value = "/flights/{id}")
    public ResponseEntity<Long> deleteFlight(@PathVariable Long id) {
        flightRepository.deleteById(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}

