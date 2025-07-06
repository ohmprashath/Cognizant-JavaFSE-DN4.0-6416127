package com.example.service;

import com.example.model.Country;
import java.util.List;
import java.util.Optional;

public interface CountryService {
    Country addCountry(Country country);
    Optional<Country> getCountryByCode(String code);
    Country updateCountry(Country country);
    void deleteCountry(String code);
    List<Country> searchCountriesByName(String name);
}
