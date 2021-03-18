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
        ArrayList<Country> country = new ArrayList<>();
        app.printCountries(country);
    }
    //test for non null - happy path
    @Test
    void printCountries()
    {
        ArrayList<Country> countries = new ArrayList<>();
        Country cnt = new Country();
        cnt.code = "SCT";
        cnt.name = "Scotland";
        cnt.continent = "Europe";
        cnt.region = "Northern Europe";
        cnt.population = 5500000;
        cnt.capital = "Peking";
        countries.add(cnt);
        app.printCountries(countries);
    }

}
