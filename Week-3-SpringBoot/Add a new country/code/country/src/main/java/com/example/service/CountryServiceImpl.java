package com.example.service;

import com.example.cognizant.spring_learn.service.exception.CountryNotFoundException;
import com.example.model.Country;
import com.example.repository.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepo;

    @Override
    public Country addCountry(Country country) {
        return countryRepo.save(country);
    }

    @Override
    public Optional<Country> getCountryByCode(String code) {
        return countryRepo.findById(code);
    }

    @Override
    @Transactional
    public Country findCountryByCode(String countryCode) throws CountryNotFoundException {
        return countryRepo.findById(countryCode)
            .orElseThrow(() -> new CountryNotFoundException("Country with code " + countryCode + " not found"));
    }

    @Override
    public Country updateCountry(Country country) {
        return countryRepo.save(country);
    }

    @Override
    public void deleteCountry(String code) {
        countryRepo.deleteById(code);
    }

    @Override
    public List<Country> searchCountriesByName(String name) {
        return countryRepo.findByCoNameContainingIgnoreCase(name);
    }
}
