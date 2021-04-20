package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.models.Language;
import com.example.budgetawaydb.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;

    @GetMapping(value = "/languages")
    public ResponseEntity<List<Language>> getUniqueLanguages(){
        return new ResponseEntity<>(languageRepository.findAll(), HttpStatus.OK);
    }
}
