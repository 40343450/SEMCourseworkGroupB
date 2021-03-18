import com.napier.sem.App;
import com.napier.sem.Country;
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
    //test for null
    @Test
    void printCountryTestNull()
    {
        app.printCountries(null);
    }
    //test for Empty country
    @Test
    void printCountryTestEmpty()
    {
        ArrayList<Country> country = new ArrayList<Country>();
        app.printCountries(country);
    }
    //test for null list
    @Test
    void printCountryTestContainsNull()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        countries.add(null);
        app.printCountries(countries);
    }
    //test for non null - happy path
    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<Country>();
        Country cnt = new Country();
        cnt.code = "1";
        cnt.name = "Scotland";
        cnt.continent = "Europe";
        cnt.region = "The Best";
        cnt.population = 6000000;
        cnt.capital = 1;
        countries.add(cnt);
        app.printCountries(countries);
    }
    //test null continent
//    @Test
//    void printContinentTestNull()
//    {
//        Continent cont;
//        cont = null;
//        app.printContinent(cont);
//    }
//    //test happy path
//    @Test
//    void printContinent()
//    {
//        Continent cont = new Continent();
//        cont.setContinentName("Europe");
//        cont.setPopulation(100000000);
//        app.printContinent(cont);
//    }

}
