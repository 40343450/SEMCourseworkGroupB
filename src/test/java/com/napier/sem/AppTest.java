package com.napier.sem;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type App test.
 */
public class AppTest {

    /**
     * The App.
     */
    static App app;

    /**
     * Init.
     */
    @BeforeAll
    static void init()
    {
        app = new App();
    }

    /**
     * Check countries.
     */
    @Test
    void checkCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country cnt = new Country();
        cnt.setCode("SCT");
        cnt.setName("Scotland");
        cnt.setContinent("Europe");
        cnt.setRegion("Northern Europe");
        cnt.setPopulation(5500000);
        cnt.setCapital("Stirling");
        countries.add(cnt);
        assertEquals(1,countries.size());
    }

    /**
     * Check print countries.
     */
    @Test
    void checkPrintCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        while(countries.size()<5)
        {
            countries.add(new Country(RandomStringUtils.randomAlphabetic(3,3), RandomStringUtils.randomAlphabetic(5,10), RandomStringUtils.randomAlphabetic(5,10), RandomStringUtils.randomAlphabetic(5,10), ThreadLocalRandom.current().nextInt(1, 900000000 + 1), RandomStringUtils.randomAlphabetic(5,10)));
        }
        app.printCountries(countries);
    }

    /**
     * Check cities.
     */
    @Test
    void checkCities()
    {
        ArrayList<City> cities = new ArrayList<>();
        City city = new City();
        city.setId(1274);
        city.setName("Edinburgh");
        city.setDistrict("Dalry");
        city.setCountry("Scotland");
        city.setPopulation(820000);
        cities.add(city);
        assertEquals(1,cities.size());
    }

    /**
     * Check print cities.
     */
    @Test
    void checkPrintCities()
    {
        ArrayList<City> cities = new ArrayList<>();
        while(cities.size()<5)
        {
            cities.add(new City(ThreadLocalRandom.current().nextInt(1, 9000 + 1), RandomStringUtils.randomAlphabetic(5,10), RandomStringUtils.randomAlphabetic(5,10), RandomStringUtils.randomAlphabetic(5,10), ThreadLocalRandom.current().nextInt(1, 900000000 + 1)));
        }
        app.printCities(cities);
    }

    /**
     * Check print capital cities.
     */
    @Test
    void checkPrintCapitalCities()
    {
        ArrayList<City> cities = new ArrayList<>();
        while(cities.size()<5)
        {
            cities.add(new City(ThreadLocalRandom.current().nextInt(1, 9000 + 1), RandomStringUtils.randomAlphabetic(5,10), RandomStringUtils.randomAlphabetic(5,10), RandomStringUtils.randomAlphabetic(5,10), ThreadLocalRandom.current().nextInt(1, 900000000 + 1)));
        }
        app.printCapitals(cities);
    }

    /**
     * Check population.
     */
    @Test
    void checkPopulation()
    {
        ArrayList<Population> population = new ArrayList<>();
        Population pop = new Population();
        pop.setLocationName("Scotland");
        pop.setWholeLocationPopulation(5000000);
        pop.setWholeLocationPopulationInCities(2800000);
        pop.setWholeLocationPopulationNotInCities(2200000);
        population.add(pop);
        assertEquals(1,population.size());
    }


}
