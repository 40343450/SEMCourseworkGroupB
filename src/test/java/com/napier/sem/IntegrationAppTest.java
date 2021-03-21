package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IntegrationAppTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
        app.connect("localhost:33060");
    }

    @Test
    void getCountriesCheck()
    {
        ArrayList<Country> testList = app.getCountryData("world",  null, 5);
        Country testCountry = new Country();
        testCountry.setName("Royal Kingdom of Scotland");
        testCountry.setCode("1274");
        testCountry.setCapital("Stirling");
        testCountry.setContinent("Europe");
        testCountry.setRegion("Northern Europe");
        testCountry.setPopulation(5500000);
        testList.add(testCountry);
        assertEquals(6, testList.size());
    }

}
