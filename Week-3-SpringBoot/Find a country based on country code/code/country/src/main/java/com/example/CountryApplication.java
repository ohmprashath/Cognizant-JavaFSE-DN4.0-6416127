package com.example;

import com.example.model.Country;
import com.example.cognizant.spring_learn.service.exception.CountryNotFoundException;
import com.example.service.CountryService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CountryApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(CountryApplication.class);

    @Autowired
    private CountryService countryService;

    public static void main(String[] args) {
        var context = SpringApplication.run(CountryApplication.class, args);
        CountryApplication app = context.getBean(CountryApplication.class);
        app.getAllCountriesTest(); // Call to test method
    }

    private void getAllCountriesTest() {
        LOGGER.info("Start");
        try {
            Country country = countryService.findCountryByCode("IN");
            LOGGER.debug("Country: {}", country);
            if (!"India".equals(country.getCoName())) {
                LOGGER.error("Country name does not match expected!");
            }
        } catch (CountryNotFoundException e) {
            LOGGER.error("Exception: {}", e.getMessage());
        }
        LOGGER.info("End");
    }
}
