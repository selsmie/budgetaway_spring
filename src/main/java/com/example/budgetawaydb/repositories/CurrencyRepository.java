package com.example.budgetawaydb.repositories;


import com.example.budgetawaydb.models.Currency;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CurrencyRepository extends JpaRepository<Currency, Long>{
}
