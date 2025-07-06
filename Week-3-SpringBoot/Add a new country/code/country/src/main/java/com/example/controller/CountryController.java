package com.example.controller;

import com.example.model.Country;
import com.example.service.CountryService;
import com.example.cognizant.spring_learn.service.exception.CountryNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;


    @GetMapping("/{code}")
    public ResponseEntity<Country> getCountry(@PathVariable String code) {
        Optional<Country> country = countryService.getCountryByCode(code);
        return country.map(ResponseEntity::ok)
                      .orElse(ResponseEntity.notFound().build());
    }

   
    @PostMapping
    public ResponseEntity<Country> addCountry(@RequestBody Country country) {
        Country savedCountry = countryService.addCountry(country);
        return ResponseEntity.ok(savedCountry);
    }

  
    @PutMapping("/{code}")
    public ResponseEntity<Country> updateCountry(@PathVariable String code, @RequestBody Country country) {
        try {
            Country existing = countryService.findCountryByCode(code);
            existing.setCoName(country.getCoName());
            Country updated = countryService.updateCountry(existing);
            return ResponseEntity.ok(updated);
        } catch (CountryNotFoundException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{code}")
    public ResponseEntity<Void> deleteCountry(@PathVariable String code) {
        Optional<Country> country = countryService.getCountryByCode(code);
        if (country.isPresent()) {
            countryService.deleteCountry(code);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

 
    @GetMapping("/search")
    public ResponseEntity<List<Country>> searchCountries(@RequestParam String name) {
        List<Country> countries = countryService.searchCountriesByName(name);
        return ResponseEntity.ok(countries);
    }
}
