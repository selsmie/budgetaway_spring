package com.example.budgetawaydb.repositories;

import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AirportRepository extends JpaRepository<Airport, Long> {

    Airport findOneByNameIgnoreCase(String name);
}
