package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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

    @Test
    void getPopulationCheck()
    {
        ArrayList<Population> totPopulation = app.getPopulationData("country", null, 5);
        Population pop = new Population();
        pop.setLocationName("United Kingdom");
        pop.setWholeLocationPopulation(Long.valueOf(10));
        pop.setWholeLocationPopulationInCities(Long.valueOf(6));
        assertEquals(Long.valueOf(4), pop.getWholeLocationPopulationNotInCities());
        assertEquals(Double.valueOf(40), pop.getWholeLocationPopulationNotInCitiesPercentage());
        assertEquals(Double.valueOf(60), pop.getWholeLocationPopulationInCitiesPercentage());
        totPopulation.add(pop);
        assertEquals(6, totPopulation.size());
    }

    @Test
    void checkCountryLanguageGetters()
    {
        ArrayList<CountryLanguage> langPopulation = app.getLanguageData( null,"Chinese", 5);

        String countryCode = "GBR";
        String language = "Gaelic";
        double langPercentage = 4.0;
        String isofficial = "T";
        String countryName = "United Kingdom";
        Long wholeLocationPopulation = Long.valueOf(71000000);
        double totalPopSpeaking = Double.valueOf(wholeLocationPopulation)*langPercentage/100;

        CountryLanguage cl = new CountryLanguage();
        cl.setCode(countryCode);
        cl.setLanguage(language);
        cl.setPercentage(langPercentage);
        cl.setOfficial(isofficial);
        cl.setPopulation(new Population(countryName, wholeLocationPopulation));

        assertEquals(countryCode,cl.getCode());
        assertEquals(language,cl.getLanguage());
        assertEquals(langPercentage,cl.getPercentage());
        assertEquals(isofficial,cl.isOfficial());
        assertEquals(countryName,cl.getPopulation().getLocationName());
        assertEquals(totalPopSpeaking,cl.getPopulation().getWholeLocationPopulation()*cl.getPercentage()/100);

        langPopulation.add(cl);
        assertEquals(6, langPopulation.size());

    }

}
