package com.portfolio.springboot.producingwebservice;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;

import com.portfolio.springboot.producingwebservice.io.spring.guides.gs_producing_web_service.Country;
import com.portfolio.springboot.producingwebservice.io.spring.guides.gs_producing_web_service.Currency;

import org.springframework.stereotype.Component;
import org.springframework.util.Assert;


@Component
public class CountryRepository {
    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        Country spain = new Country();
        spain.setName("Spain");
        spain.setCapital("Madrid");
        spain.setCurrency(Currency.EUR);
        spain.setPopulation(46704314);

        countries.put(spain.getName(), spain);

        Country nederland = new Country();
        nederland.setName("Netherlands");
        nederland.setCapital("Amsterdam");
        nederland.setCurrency(Currency.EUR);
        nederland.setPopulation(17474677);

        countries.put(nederland.getName(), nederland);

        Country poland = new Country();
        poland.setName("Poland");
        poland.setCapital("Warsaw");
        poland.setCurrency(Currency.PLN);
        poland.setPopulation(38186860);

        countries.put(poland.getName(), poland);

        Country uk = new Country();
        uk.setName("United Kingdom");
        uk.setCapital("London");
        uk.setCurrency(Currency.GBP);
        uk.setPopulation(63705000);

        countries.put(uk.getName(), uk);
    }

    public Country findCountry(String name) {
        Assert.notNull(name, "The country's name must not be null");
        return countries.get(name);
    }
}