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
        assertEquals(1,countries.size());
    }
}
