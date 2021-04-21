package com.example.budgetawaydb.controllers;

import com.example.budgetawaydb.models.Flight;
import com.example.budgetawaydb.models.Language;
import com.example.budgetawaydb.repositories.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LanguageController {

    @Autowired
    LanguageRepository languageRepository;

    @GetMapping(value = "/languages")
    public ResponseEntity<List<Language>> getUniqueLanguages(){
        return new ResponseEntity<>(languageRepository.findAll(), HttpStatus.OK);
    }

    @PutMapping(value = "/languages/{id}")
    public ResponseEntity<Language> putFlight(@RequestBody Language language, @PathVariable Long id) {
        Language foundLanguage = languageRepository.findById(id).get();
        foundLanguage.setName(language.getName());
        languageRepository.save(foundLanguage);
        return new ResponseEntity<>(foundLanguage, HttpStatus.OK);
    }
}
