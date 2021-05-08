package com.example.budgetawaydb.controllers;



import com.example.budgetawaydb.models.Airport;
import com.example.budgetawaydb.models.Wishlist;
import com.example.budgetawaydb.repositories.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@RestController
public class WishlistController {

    @Autowired
    WishlistRepository wishlistRepository;

    @GetMapping(value = "/wishlists")
    public ResponseEntity getAllWishlists() {
        return new ResponseEntity(wishlistRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/wishlists/{id}")
    public ResponseEntity getWishlistById(@PathVariable Long id) {
        return new ResponseEntity(wishlistRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/wishlists")
    public ResponseEntity<Wishlist> postWishlist(@RequestBody Wishlist wishlists) {
        wishlistRepository.save(wishlists);
        return new ResponseEntity<>(wishlists, HttpStatus.CREATED);
    }

    @PutMapping(value = "/wishlists/{id}")
    public ResponseEntity<Wishlist> putWishlist(@RequestBody Wishlist wishlist, @PathVariable Long id) {
        Wishlist foundWishlist = wishlistRepository.findById(id).get();
        foundWishlist.setName(wishlist.getName());
        foundWishlist.setArrAirport(wishlist.getArrAirport());
        foundWishlist.setDepAirport(wishlist.getDepAirport());
        foundWishlist.setDuration(wishlist.getDuration());
        foundWishlist.setPrice(wishlist.getPrice());
        wishlistRepository.save(foundWishlist);
        return new ResponseEntity<>(foundWishlist, HttpStatus.OK);
    }

    @DeleteMapping(value = "/wishlists/{id}")
    public ResponseEntity<Wishlist> deleteWishlist(@PathVariable Long id) {
        wishlistRepository.deleteById(id);
        return new ResponseEntity(wishlistRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/wishlists/cost")
    public ResponseEntity getWishlistCost() {
        List<Wishlist> fullList = new ArrayList<>();
        fullList.addAll(wishlistRepository.findAll());
        double totalCost = 0;
        for (Wishlist wishlist : fullList) {
            totalCost += wishlist.getPrice();
        }
        return new ResponseEntity(totalCost, HttpStatus.OK);
    }
}




