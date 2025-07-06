package com.example.service;

import com.example.model.Country;
import com.example.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
