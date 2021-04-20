package com.example.budgetawaydb.repositories;

import com.example.budgetawaydb.models.Country;
import com.example.budgetawaydb.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LanguageRepository extends JpaRepository<Language, Long> {

    Optional<Language> findOneByName(Language language);
    Language findOneByNameIgnoreCase(String name);

    List<Language> findAll();
}
