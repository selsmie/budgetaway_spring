package com.example.budgetawaydb.repositories;


import com.example.budgetawaydb.models.Currency;
import com.example.budgetawaydb.models.Language;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long>{

    Currency findOneByNameIgnoreCase(String name);
}
