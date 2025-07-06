package com.example.service;

import com.example.cognizant.spring_learn.service.exception.CountryNotFoundException;
import com.example.model.Country;
import java.util.List;
import java.util.Optional;
import org.springframework.transaction.annotation.Transactional;

public interface CountryService {

    @Transactional
    Country addCountry(Country country);

    Optional<Country> getCountryByCode(String code);

    Country updateCountry(Country country);

    void deleteCountry(String code);

    List<Country> searchCountriesByName(String name);

    @Transactional
    Country findCountryByCode(String countryCode) throws CountryNotFoundException;
}
