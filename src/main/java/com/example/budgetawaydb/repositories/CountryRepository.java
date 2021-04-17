package com.example.budgetawaydb.repositories;

import com.example.budgetawaydb.models.Country;
import com.sun.tools.internal.xjc.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long>{

    List<Country> findByRegion(String region);

    List<Country> findByInLanguages(String language);

    List<Country> findByRegionAndLanguages(String region, String language);

}