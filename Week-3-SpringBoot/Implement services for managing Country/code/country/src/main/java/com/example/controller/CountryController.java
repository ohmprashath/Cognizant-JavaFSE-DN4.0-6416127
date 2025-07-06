package com.example.controller;

import com.example.model.Country;
import com.example.service.CountryService;
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
        if (country.isPresent()) {
            return ResponseEntity.ok(country.get());
        }
        return ResponseEntity.notFound().build();
    }

    // Other CRUD endpoints as previously discussed...
}
