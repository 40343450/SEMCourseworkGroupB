package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


/**
 * The type App.
 */
public class App {

    private static final String FIXED_WIDTH_FORMATTING_WORLD="%-15s %-65s %-35s %-45s %-20s %-20s";//6

    private static final String FIXED_WIDTH_FORMATTING_CITY="%-35s %-35s %-35s %-35s";//4

    private static final String FIXED_WIDTH_FORMATTING_CAP_CITY="%-35s %-35s %-35s";//3

    private static final String FIXED_WIDTH_FORMATTING_POPULATION="%-35s %-35s %-35s %-35s %-35s %-35s";//6

    private static final String WORLD = "world";

    private static final String CONTINENT  = "continent";

    private static final String REGION = "region";

    /*
    * COMMON SQL FILTERS
    * */

    private static final String ORDER_BY_POPULATION=" ORDER BY population DESC";

    private static final String STATEMENT_END = ";";

    private static final String FILTER_REGION = " AND region = ? ";
    
    private static final String FILTER_CONTINENT = " AND continent = ? ";

    private static final String LIMIT_ROWS_RETURNED = " LIMIT ";

    /*
    * COUNTRY REPORTS QUERIES
    * */

    private static final String COUNTRY_SELECT_STATEMENT = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name as 'capital' FROM country, city where country.capital = city.id ";

    private static final String COUNTRY_SELECT_STATEMENT_WORLD=  COUNTRY_SELECT_STATEMENT + ORDER_BY_POPULATION;

    private static final String COUNTRY_SELECT_STATEMENT_BY_CONTINENT= COUNTRY_SELECT_STATEMENT + FILTER_CONTINENT + ORDER_BY_POPULATION;

    private static final String COUNTRY_SELECT_STATEMENT_BY_REGION= COUNTRY_SELECT_STATEMENT + FILTER_REGION + ORDER_BY_POPULATION;

    /*
    * CITY REPORTS QUERIES
    * */



    /*
    * PEOPLE REPORTS
    * */


    /*
    * Creating an instance of Connection
    * */
    private Connection con = null;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {
        // Create new Application
        App a = new App();
        // Connect to database
        a.connect();

        /*
        * USE CASE 1
        * */
        System.out.println("\n\nUSE CASE 1\n\nAs a user I would like to generate a report about all the" +
                " countries in the world organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryList(WORLD,null));

        /*
         * USE CASE 2
         * */
        System.out.println("\n\nUSE CASE 2\n\nAs a user I would like to generate a report about all the" +
                " countries in a continent organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryList(CONTINENT,"Asia"));

        /*
         * USE CASE 3
         * */
        System.out.println("\n\nUSE CASE 3\n\nAs a user I would like to generate a report about all the" +
                " countries in a region organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryList(REGION,"Eastern Asia"));


        /*
        * USE CASE 4
        * */

        System.out.println("\n\nUSE CASE: 4\n\n");
        a.printCountries(a.getCountryListLimitByN(REGION,"Eastern Asia", 1));

        /*
         * USE CASE 5
         * */

        System.out.println("\n\nUSE CASE: 5\n\n");


        /*
         * USE CASE 6
         * */

        System.out.println("\n\nUSE CASE: 6\n\n");


        /*
         * USE CASE 7
         * */

        System.out.println("\n\nUSE CASE: 7\n\n");


        /*
         * USE CASE 8
         * */

        System.out.println("\n\nUSE CASE: 8\n\n");


        /*
         * USE CASE 9
         * */

        System.out.println("\n\nUSE CASE: 9\n\n");


        /*
         * USE CASE 10
         * */

        System.out.println("\n\nUSE CASE: 10\n\n");


        /*
         * USE CASE 11
         * */

        System.out.println("\n\nUSE CASE: 11\n\n");


        /*
         * USE CASE 12
         * */

        System.out.println("\n\nUSE CASE: 12\n\n");


        /*
         * USE CASE 13
         * */

        System.out.println("\n\nUSE CASE: 13\n\n");


        /*
         * USE CASE 14
         * */

        System.out.println("\n\nUSE CASE: 14\n\n");


        /*
         * USE CASE 15
         * */

        System.out.println("\n\nUSE CASE: 15\n\n");


        /*
         * USE CASE 16
         * */

        System.out.println("\n\nUSE CASE: 16\n\n");


        /*
         * USE CASE 17
         * */

        System.out.println("\n\nUSE CASE: 17\n\n");


        /*
         * USE CASE 18
         * */

        System.out.println("\n\nUSE CASE: 18\n\n");


        /*
         * USE CASE 19
         * */

        System.out.println("\n\nUSE CASE: 19\n\n");


        /*
         * USE CASE 20
         * */

        System.out.println("\n\nUSE CASE: 20\n\n");


        /*
         * USE CASE 21
         * */

        System.out.println("\n\nUSE CASE: 21\n\n");


        /*
         * USE CASE 22
         * */

        System.out.println("\n\nUSE CASE: 22\n\n");


        /*
         * USE CASE 23
         * */

        System.out.println("\n\nUSE CASE: 23\n\n");


        /*
         * USE CASE 24
         * */

        System.out.println("\n\nUSE CASE: 24\n\n");


        /*
         * USE CASE 25
         * */

        System.out.println("\n\nUSE CASE: 25\n\n");


        /*
         * USE CASE 26
         * */

        System.out.println("\n\nUSE CASE: 26\n\n");


        /*
         * USE CASE 27
         * */

        System.out.println("\n\nUSE CASE: 27\n\n");


        /*
         * USE CASE 28
         * */

        System.out.println("\n\nUSE CASE: 28\n\n");


        /*
         * USE CASE 29
         * */

        System.out.println("\n\nUSE CASE: 29\n\n");


        /*
         * USE CASE 30
         * */

        System.out.println("\n\nUSE CASE: 30\n\n");


        /*
         * USE CASE 31
         * */

        System.out.println("\n\nUSE CASE: 31\n\n");


        /*
         * USE CASE 32
         * */

        System.out.println("\n\nUSE CASE: 32\n\n");


        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root",
                        "coursework");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + i);
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect.
     */
    public void disconnect() {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets country list.
     *
     * @param filterType the filter type
     * @param filter     the filter
     * @return the country list
     */
    public ArrayList<Country> getCountryList(String filterType, String filter)
    {
        switch(filterType)
        {
            case WORLD:
                return getCountryListByWorld(filterType);
            case CONTINENT:
                return getCountryListByContinent(filterType, filter);
            case REGION:
                return getCountryListByRegion(filterType, filter);
            default:
                throw new IllegalArgumentException("ERROR! - INVALID ARGUMENTS PASSED:\n\n" + "Filter: " + filter +
                        "\nFilter Type: " + filterType);
        }
    }

    /**
     * Gets country list limit by n.
     *
     * @param filterType the filter type
     * @param filter     the filter
     * @param maxRows    the max rows
     * @return the country list limit by n
     */
    public ArrayList<Country> getCountryListLimitByN(String filterType, String filter, Integer maxRows)
    {
        switch(filterType)
        {
            case WORLD:
                return getCountryListByWorldLimitByN(filterType,maxRows);
            case CONTINENT:
                return getCountryListByContinentLimitByN(filterType,filter, maxRows);
            case REGION:
                return getCountryListByRegionLimitByN(filterType,filter, maxRows);
            default:
                throw new IllegalArgumentException("ERROR! - INVALID ARGUMENTS PASSED:\n\n" + "Filter: " + filter +
                        "\nFilter Type: " + filterType + "\nMax rows: " + maxRows);
        }
    }

    /**
     * Gets country list by world.
     *
     * @return the country list by world
     */
    public ArrayList<Country> getCountryListByWorld(String filterType)
    {
        return getCountries(filterType,null, COUNTRY_SELECT_STATEMENT_WORLD + STATEMENT_END);
    }

    /**
     * Gets country list by world limit by n.
     *
     * @param maxRows the max rows
     * @return the country list by world limit by n
     */
    public ArrayList<Country> getCountryListByWorldLimitByN(String filterType,Integer maxRows)
    {
        if(maxRows != null && maxRows > 0)
        {
            return getCountries(filterType,null, COUNTRY_SELECT_STATEMENT_WORLD + LIMIT_ROWS_RETURNED
                    + maxRows + STATEMENT_END);
        }
        else
        {
            System.out.println("ERROR:  getCountryListByWorldLimitByN(String filterType,Integer maxRows)\n\nMaxRows" +
                    " invalid!");
            return null;
        }
    }


    /**
     * Gets country list by continent.
     *
     * @param continent the continent
     * @return the country list by continent
     */
    public ArrayList<Country> getCountryListByContinent(String filterType, String continent)
    {
        if(continent != null && !continent.isEmpty())
        {
            return getCountries(filterType,continent, COUNTRY_SELECT_STATEMENT_BY_CONTINENT);
        }
        else
        {
            throw new NullPointerException("You must enter a a valid continent!");
        }
    }

    /**
     * Gets country list by continent limit by n.
     *
     * @param continent the continent
     * @param maxRows   the max rows
     * @return the country list by continent limit by n
     */
    public ArrayList<Country> getCountryListByContinentLimitByN(String filterType,String continent, Integer maxRows)
    {
        if(continent != null && !continent.isEmpty())
        {
            if(maxRows != null && maxRows > 0)
            {
                return getCountries(filterType,continent, COUNTRY_SELECT_STATEMENT_BY_CONTINENT +
                        LIMIT_ROWS_RETURNED + maxRows + STATEMENT_END);
            }
            else
            {
                System.out.println("ERROR: getCountryListByContinentLimitByN(String filterType,String continent," +
                        " Integer maxRows)\n\nMaxRows invalid!");
                return null;
            }
        }
        else
        {
            throw new NullPointerException("You must enter a a valid continent!");
        }
    }

    /**
     * Gets country list by region.
     *
     * @param region the region
     * @return the country list by region
     */
    public ArrayList<Country> getCountryListByRegion(String filterType, String region)
    {
        if(region != null && !region.isEmpty()) {
            return getCountries(filterType,region, COUNTRY_SELECT_STATEMENT_BY_REGION);
        }
        else
        {
            throw new NullPointerException("You must enter a a valid region!");
        }
    }

    /**
     * Gets country list by region limit by n.
     *
     * @param region  the region
     * @param maxRows the max rows
     * @return the country list by region limit by n
     */
    public ArrayList<Country> getCountryListByRegionLimitByN(String filterType,String region, Integer maxRows)
    {
        if(region != null && !region.isEmpty()) {
            if(maxRows != null && maxRows > 0)
            {
                return getCountries(filterType,region, COUNTRY_SELECT_STATEMENT_BY_REGION +
                        LIMIT_ROWS_RETURNED + maxRows.toString() + STATEMENT_END);
            }
            else
            {
                System.out.println("ERROR: getCountryListByRegionLimitByN(String filterType,String region, " +
                        "Integer maxRows)\n\nMaxRows invalid!");
                return null;
            }
        }
        else
        {
            throw new NullPointerException("You must enter a a valid region!");
        }
    }


    private ArrayList<Country> getCountries(String filterType, String filter, String sqlStatement) {
        //DEBUG System.out.println(sqlStatement);
        if(!filterType.equals(WORLD) && !(filter == null || filter.isEmpty()))
        {
            try
            {
                PreparedStatement stmt = con.prepareStatement(sqlStatement);
                stmt.setString(1, filter);
                //DEBUG System.out.println(stmt.toString());
                ResultSet rset = stmt.executeQuery();
                return returnCountryResultAsList(rset);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else if (filterType.equals(WORLD) && (filter == null || filter.isEmpty()))
        {
            try
            {
                PreparedStatement stmt = con.prepareStatement(sqlStatement);
                //DEBUG System.out.println(stmt.toString());
                ResultSet rset = stmt.executeQuery();
                return returnCountryResultAsList(rset);
            }
            catch (Exception e)
            {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else
        {
            throw new IllegalArgumentException("ERROR! - SQL STRUCTURE NOT VALID!\n");
        }
    }

    private ArrayList<Country> returnCountryResultAsList(ResultSet rset) throws SQLException {
        ArrayList<Country> countries = new ArrayList<>();
        // Check one is returned
        while (rset.next()) {
            Country cnt = new Country();
            cnt.code = rset.getString("code");
            cnt.name = rset.getString("name");
            cnt.continent = rset.getString("continent");
            cnt.region = rset.getString("region");
            cnt.population = rset.getInt("population");
            cnt.capital = rset.getInt("capital");
            countries.add(cnt);
        }
        return countries;
    }

    /*
    *
    Country Report

    A country report requires the following columns:

        Code.
        Name.
        Continent.
        Region.
        Population.
        Capital.

    City Report

    A city report requires the following columns:

        Name.
        Country.
        District.
        Population.

    Capital City Report

    A capital city report requires the following columns:

        Name.
        Country.
        Population.

    Population Report

    For the population reports, the following information is requested:

        The name of the continent/region/country.
        The total population of the continent/region/country.
        The total population of the continent/region/country living in cities (including a %).
        The total population of the continent/region/country not living in cities (including a %).

    **/


    /**
     * Print countries.
     *
     * @param countries the countries
     */
    public void printCountries(ArrayList<Country> countries)
    {
        if(countries != null && !countries.isEmpty()) {
            System.out.printf((FIXED_WIDTH_FORMATTING_WORLD) + "%n", "Country Code", "Country Name", "Country Continent", "Country Region", "Country Population", "Country Capital");
            for (Country country : countries) {
                String country_string =
                        String.format(FIXED_WIDTH_FORMATTING_WORLD,
                                country.code, country.name, country.continent, country.region, country.population, country.capital);
                System.out.println(country_string);
            }
        }
        else
        {
            throw new NullPointerException("ERROR! - Countries List Is Empty!");
        }
    }
}