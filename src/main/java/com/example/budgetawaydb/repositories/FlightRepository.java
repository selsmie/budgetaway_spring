package com.example.budgetawaydb.repositories;

import com.example.budgetawaydb.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Long> {
}
