package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The type App test.
 */
public class AppTest {

    static App app;

    @BeforeAll
    static void init()
    {
        app = new App();
    }

    @Test
    void printCountries()
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
}
