package com.example.budgetawaydb.repositories;

import com.example.budgetawaydb.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long>{

}
