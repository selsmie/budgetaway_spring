package com.example.budgetawaydb.repositories;

import com.example.budgetawaydb.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long>{

    List<Country> findByRegion(String region);

//    List<Country> findByLanguagesContaining(String language);

//    List<Country> findByRegionAndLanguages(String region, String language);

}

