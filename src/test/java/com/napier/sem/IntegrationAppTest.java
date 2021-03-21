package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * The type Integration app test.
 */
public class IntegrationAppTest {

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
        app.connect("localhost:33060");
    }

    /**
     * Gets countries check.
     */
    @Test
    void getCountriesCheck()
    {
        ArrayList<Country> countries = app.getCountryData("world",  null, 5);
        Country cnt = new Country();
        cnt.setName("Royal Kingdom of Scotland");
        cnt.setCode("1274");
        cnt.setCapital("Stirling");
        cnt.setContinent("Europe");
        cnt.setRegion("Northern Europe");
        cnt.setPopulation(5500000);
        countries.add(cnt);
        assertEquals(6, countries.size());
    }


    /**
     * Gets cities check.
     */
    @Test
    void getCitiesCheck()
    {
        ArrayList<City> cities = app.getCityData("world",  null, 5);
        City city = new City();
        city.setId(1274);
        city.setName("Edinburgh");
        city.setDistrict("Dalry");
        city.setCountry("Scotland");
        city.setPopulation(820000);
        cities.add(city);
        assertEquals(6, cities.size());
    }

    /**
     * Gets capital cities check.
     */
    @Test
    void getCapitalCitiesCheck()
    {
        ArrayList<City> cities = app.getCapitalCityData("world",  null, 5);
        City city = new City();
        city.setId(1274);
        city.setName("Edinburgh");
        city.setCountry("Scotland");
        city.setPopulation(820000);
        cities.add(city);
        assertEquals(6, cities.size());
    }


}
