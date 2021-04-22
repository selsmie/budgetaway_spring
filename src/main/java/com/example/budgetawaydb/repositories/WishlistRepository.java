package com.example.budgetawaydb.repositories;


import com.example.budgetawaydb.models.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

}
