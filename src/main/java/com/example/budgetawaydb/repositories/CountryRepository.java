package com.example.budgetawaydb.repositories;

import com.example.budgetawaydb.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.budgetawaydb.models.Language;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long>{

    List<Country> findByRegionIgnoreCase(String region);

    List<Country> findByLanguagesNameIgnoreCase(String language);

    List<Country> findByRegionAndLanguagesNameAllIgnoreCase(String region, String language);
}
