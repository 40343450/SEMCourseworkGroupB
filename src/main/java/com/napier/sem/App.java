package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


/**
 * The type App.
 */
public class App {

    private static final String FIXED_WIDTH_FORMATTING_WORLD = "%-15s %-65s %-35s %-45s %-20s %-20s";//6

    private static final String FIXED_WIDTH_FORMATTING_CITY = "%-65s %-65s %-65s %-15s";//4

    private static final String FIXED_WIDTH_FORMATTING_CAP_CITY = "%-35s %-35s %-35s";//3

    private static final String FIXED_WIDTH_FORMATTING_POPULATION = "%-35s %-35s %-35s %-35s %-35s %-35s";//6

    private static final String WORLD = "world";

    private static final String CONTINENT = "continent";

    private static final String REGION = "region";

    private static final String COUNTRY = "country";

    private static final String DISTRICT = "district";

    /*
     * COMMON SQL FILTERS
     * */

    private static final String ORDER_BY_POPULATION = " ORDER BY population DESC";

    private static final String STATEMENT_END = ";";


    private static final String FILTER_REGION = " AND region = ? ";

    private static final String FILTER_CONTINENT = " AND continent = ? ";

    private static final String FILTER_COUNTRY = " AND country.name = ? ";

    private static final String FILTER_DISTRICT = " AND district = ? ";

    private static final String LIMIT_ROWS_RETURNED = " LIMIT ";

    /*
     * COUNTRY REPORTS QUERIES
     * */

    private static final String COUNTRY_SELECT_STATEMENT = "SELECT country.code, country.name, country.continent," +
            " country.region, country.population, city.name as 'capital' FROM country, city where country.capital " +
            "= city.id ";

    private static final String COUNTRY_SELECT_STATEMENT_WORLD = COUNTRY_SELECT_STATEMENT + ORDER_BY_POPULATION;

    private static final String COUNTRY_SELECT_STATEMENT_BY_CONTINENT = COUNTRY_SELECT_STATEMENT + FILTER_CONTINENT
            + ORDER_BY_POPULATION;

    private static final String COUNTRY_SELECT_STATEMENT_BY_REGION = COUNTRY_SELECT_STATEMENT + FILTER_REGION
            + ORDER_BY_POPULATION;

    /*
     * CITY REPORTS QUERIES
     * */

    private static final String CITY_SELECT_STATEMENT = "SELECT city.id, city.name, country.name as 'country', " +
            "city.district, city.population  FROM city, country where country.code = city.countrycode ";

    private static final String CITY_SELECT_STATEMENT_WORLD = CITY_SELECT_STATEMENT + ORDER_BY_POPULATION;

    private static final String CITY_SELECT_STATEMENT_BY_CONTINENT = CITY_SELECT_STATEMENT + FILTER_CONTINENT
            + ORDER_BY_POPULATION;

    private static final String CITY_SELECT_STATEMENT_BY_REGION = CITY_SELECT_STATEMENT + FILTER_REGION
            + ORDER_BY_POPULATION;

    private static final String CITY_SELECT_STATEMENT_BY_COUNTRY = CITY_SELECT_STATEMENT + FILTER_COUNTRY
            + ORDER_BY_POPULATION;

    private static final String CITY_SELECT_STATEMENT_BY_DISTRICT = CITY_SELECT_STATEMENT + FILTER_DISTRICT
            + ORDER_BY_POPULATION;
    /*
     * CAPITAL CITY QUERIES
     *
     * */
    private static final String CAPITAL_SELECT_STATEMENT = "SELECT city.name, country.name 'country', " +
            "SUM(city.population) as 'population' FROM city, country where country.capital = city.id ";

    private static final String CAPITAL_GROUP_BY = "GROUP BY city.name, country.name ";

    private static final String CAPITAL_SELECT_STATEMENT_WORLD = CAPITAL_SELECT_STATEMENT + CAPITAL_GROUP_BY +
            ORDER_BY_POPULATION;

    private static final String CAPITAL_SELECT_STATEMENT_BY_CONTINENT = CAPITAL_SELECT_STATEMENT + FILTER_CONTINENT
            + CAPITAL_GROUP_BY +ORDER_BY_POPULATION;

    private static final String CAPITAL_SELECT_STATEMENT_BY_REGION = CAPITAL_SELECT_STATEMENT + FILTER_REGION
            + CAPITAL_GROUP_BY +ORDER_BY_POPULATION;


    /*
     * POPULATION QUERIES
     *
     *
     *
     * private static final String WORLD = "world";
     * private static final String CONTINENT = "continent";
     * private static final String REGION = "region";
     * private static final String COUNTRY = "country";
     * private static final String DISTRICT = "district";
     *
     *
     * The population of people, people living in cities, and people not living in cities in each continent.
     * The population of people, people living in cities, and people not living in cities in each region.
     * The population of people, people living in cities, and people not living in cities in each country.

    Additionally, the following information should be accessible to the organisation:

    The population of the world.
    The population of a continent.
    The population of a region.
    The population of a country.
    The population of a district.
    The population of a city.

    * Finally, the organisation has asked if it is possible to provide the number of people who speak the following the following languages from greatest number to smallest, including the percentage of the world population:
    * Chinese.
    * English.
    * Hindi.
    * Spanish.
    * Arabic.
    *
    * */

    private static final String POPULATION_SELECT_STATEMENT_WORLD = "SELECT 'world' as 'name', SUM(population) as 'population' FROM country ";

    //TO-DO FINISH POP REPORTS

    private static final String POPULATION_SELECT_STATEMENT_BY_CONTINENT = CAPITAL_SELECT_STATEMENT + FILTER_CONTINENT
            + CAPITAL_GROUP_BY +ORDER_BY_POPULATION;

    private static final String POPULATION_SELECT_STATEMENT_BY_REGION = CAPITAL_SELECT_STATEMENT + FILTER_REGION
            + CAPITAL_GROUP_BY +ORDER_BY_POPULATION;

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

        // Connect to database
        if (args.length < 1) {
            a.connect("localhost:33060");
        } else {
            a.connect(args[0]);
        }

        /*
         * USE CASE 1
         * */
        System.out.println("\n\nUSE CASE 1\n\nAs a user I would like to generate a report about all the" +
                " countries in the world organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryData(WORLD, null, null));

        /*
         * USE CASE 2
         * */
        System.out.println("\n\nUSE CASE 2\n\nAs a user I would like to generate a report about all the" +
                " countries in a continent organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryData(CONTINENT, "Asia",null));

        /*
         * USE CASE 3
         * */
        System.out.println("\n\nUSE CASE 3\n\nAs a user I would like to generate a report about all the" +
                " countries in a region organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryData(REGION, "Eastern Asia",null));


        /*
         * USE CASE 4
         * */

        System.out.println("\n\nUSE CASE: 4\n\nAs a user I would like to generate a report about the top N " +
                "populated countries in the world where N is provided by the user.");
        a.printCountries(a.getCountryData(WORLD, null, 15));

        /*
         * USE CASE 5
         * */

        System.out.println("\n\nUSE CASE: 5\n\nAs a user I would like to generate a report about the top N " +
                "populated countries in a continent where N is provided by the user.");
        a.printCountries(a.getCountryData(CONTINENT, "Asia",2));

        /*
         * USE CASE 6
         * */

        System.out.println("\n\nUSE CASE: 6\n\nAs a user I would like to generate a report about the top N" +
                " populated countries in a region where N is provided by the user.");
        a.printCountries(a.getCountryData(REGION, "Eastern Asia",2));

        /*
         * USE CASE 7
         * */

        System.out.println("\n\nUSE CASE: 7\n\nAs a user I would like to generate a report about all the cities in " +
                "the world organised by largest population to smallest.");
        a.printCities(a.getCityData(WORLD,null,null));

        /*
         * USE CASE 8
         * */

        System.out.println("\n\nUSE CASE: 8\n\nAs a user I would like to generate a report about all the cities in a " +
                "continent organised by largest population to smallest.");
        a.printCities(a.getCityData(CONTINENT,"Europe",null));

        /*
         * USE CASE 9
         * */

        System.out.println("\n\nUSE CASE: 9\n\nAs a user I would like to generate a report about all the cities in a" +
                " region organised by largest population to smallest.");
        a.printCities(a.getCityData(REGION,"Western Europe",null));

        /*
         * USE CASE 10
         * */

        System.out.println("\n\nUSE CASE: 10\n\nAs a user I would like to generate a report about all the cities in a" +
                " country organised by largest population to smallest.");
        a.printCities(a.getCityData(COUNTRY,"United Kingdom",null));

        /*
         * USE CASE 11
         * */

        System.out.println("\n\nUSE CASE: 11\n\nAs a user I would like to generate a report about all the cities in a" +
                " district organised by largest population to smallest.");
        a.printCities(a.getCityData(DISTRICT,"Scotland",null));

        /*
         * USE CASE 12
         * */

        System.out.println("\n\nUSE CASE: 12\n\nAs a user I would like to generate a report about the top N populated" +
                " cities in the world where N is provided by the user.");
        a.printCities(a.getCityData(WORLD,null,2));

        /*
         * USE CASE 13
         * */

        System.out.println("\n\nUSE CASE: 13\n\nAs a user I would like to generate a report about the top N populated" +
                " cities in a continent where N is provided by the user.");
        a.printCities(a.getCityData(CONTINENT,"Europe",3));

        /*
         * USE CASE 14
         * */

        System.out.println("\n\nUSE CASE: 14\n\nAs a user I would like to generate a report about the top N populated" +
                " cities in a region where N is provided by the user.");
        a.printCities(a.getCityData(REGION,"Western Europe",2));

        /*
         * USE CASE 15
         * */

        System.out.println("\n\nUSE CASE: 15\n\nAs a user I would like to generate a report about the top N populated" +
                " cities in a country where N is provided by the user.");
        a.printCities(a.getCityData(COUNTRY,"United Kingdom",3));

        /*
         * USE CASE 16
         * */

        System.out.println("\n\nUSE CASE: 16\n\nAs a user I would like to generate a report about the top N populated" +
                " cities in a district where N is provided by the user.");
        a.printCities(a.getCityData(DISTRICT,"Scotland",2));

        /*
         * USE CASE 17
         * */

        System.out.println("\n\nUSE CASE: 17\n\nAs a user I would like to generate a report about " +
                "all the capital" +
                " cities in the world organised by largest population to smallest.");
        a.printCapitals(a.getCapitalCityData(WORLD, null, 2));

        /*
         * USE CASE 18
         * */

        System.out.println("\n\nUSE CASE: 18\n\n As a user i would like to generate a report about" +
                " all the capital cities"+
                " in a continent organised by largest to smallest");


        /*
         * USE CASE 19
         * */

        System.out.println("\n\nUSE CASE: 19\n\n As a user i would like to generate a report about all the " +
                "capital cities"+
                " in a region organised by largest to smallest");


        /*
         * USE CASE 20
         * */

        System.out.println("\n\nUSE CASE: 20\n\n As a user i would like to generate a report about the top N " +
                "populated capital cities"+
                " in the world where N is provided by user");


        /*
         * USE CASE 21
         * */

        System.out.println("\n\nUSE CASE: 21\n\n As a user i would like to generate a report about the top N " +
                "populated capital cities"+
                " in a continent where N is provided by the user");


        /*
         * USE CASE 22
         * */

        System.out.println("\n\nUSE CASE: 22\n\n As a user i would like to generate a report about the top N " +
                "populated capital cities"+
                " in a region where N is provided by the user");


        /*
         * USE CASE 23
         * */

        System.out.println("\n\nUSE CASE: 23\n\n As a user i would like to generate a report about the"+
                " population of people, people living in cities and people not living in cities in each continent");


        /*
         * USE CASE 24
         * */

        System.out.println("\n\nUSE CASE: 24\n\n As a user i would like to generate a report about"+
                " the population of people, people living in cities and people not living in cities in each region");


        /*
         * USE CASE 25
         * */

        System.out.println("\n\nUSE CASE: 25\n\n As a user I would like to generate a report about"+
                " the population of people, people living in cities, and people not living in cities in each region.");


        /*
         * USE CASE 26
         * */

        System.out.println("\n\nUSE CASE: 26\n\n As a user I would like to make information about"+
                " the population of the world, population of any continent, population of any region,"+
                " population of any country, population of any district and population of any city accessible to the " +
                "organisation.");


        /*
         * USE CASE 27
         * */

        System.out.println("\n\nUSE CASE: 27\n\n As a user I would like to be provided a number of people who speak" +
                " Chinese.");


        /*
         * USE CASE 28
         * */

        System.out.println("\n\nUSE CASE: 28\n\n As a user I would like to be provided a number of people who speak " +
                "English.");


        /*
         * USE CASE 29
         * */

        System.out.println("\n\nUSE CASE: 29\n\n As a user I would like to be provided a number of people who speak" +
                " Hindi.");


        /*
         * USE CASE 30
         * */

        System.out.println("\n\nUSE CASE: 30\n\n As a user I would like to be provided a number of people who speak " +
                "Spanish.");


        /*
         * USE CASE 31
         * */

        System.out.println("\n\nUSE CASE: 31\n\n As a user I would like to be provided a number of people who speak " +
                "Spanish.");


        /*
         * USE CASE 32
         * */

        System.out.println("\n\nUSE CASE: 32\n\n As a user I would like to be provided a number of people who speak " +
                "Arabic.");


        System.out.println("---------------- PROGRAM REPORTS GENERATED - EXITING ----------------");
        // Disconnect from database
        a.disconnect();
    }

    /**
     * Connect.
     *
     * @param location the location
     */
    public void connect(String location)
    {
        try {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
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
                con = DriverManager.getConnection("jdbc:mysql://" + location +
                        "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "coursework");
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
    public void disconnect()
    {
        if (con != null) {
            try {
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets country data.
     *
     * @param filterType the filter type
     * @param filter     the filter
     * @param limit      the limit
     * @return the country data
     */
    public ArrayList<Country> getCountryData(String filterType, String filter, Integer limit)
    {
        switch (filterType) {
            case WORLD:
                if (limit != null && limit > 0) {
                    return getCountries(filterType, null, COUNTRY_SELECT_STATEMENT_WORLD +
                            LIMIT_ROWS_RETURNED + limit + STATEMENT_END);
                } else {
                    return getCountries(filterType, null, COUNTRY_SELECT_STATEMENT_WORLD +
                            STATEMENT_END);
                }
            case CONTINENT:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCountries(filterType, filter, COUNTRY_SELECT_STATEMENT_BY_CONTINENT +
                                LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    } else
                    {
                        return getCountries(filterType, filter, COUNTRY_SELECT_STATEMENT_BY_CONTINENT +
                                STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCountryData()!");
                    throw new NullPointerException("You must enter a a valid continent!");
                }
            case REGION:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCountries(filterType, filter, COUNTRY_SELECT_STATEMENT_BY_REGION
                                + LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    }
                    else
                    {
                        return getCountries(filterType, filter, COUNTRY_SELECT_STATEMENT_BY_REGION +
                                STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCountryData()!");
                    throw new NullPointerException("You must enter a a valid region!");
                }
            default:
                throw new IllegalArgumentException("Filter Type not valid!");
        }
    }

    private ArrayList<Country> getCountries(String filterType, String filter, String sqlStatement)
    {
        //DEBUG System.out.println(sqlStatement);
        try
        {
            if (filter != null && !filter.isEmpty())
            {
                return returnCountryResultAsList(getResultSet(filter, sqlStatement));
            } else if (filter == null)
            {
                return returnCountryResultAsList(getResultSet(sqlStatement));
            }
        } catch (Exception e) {
            System.out.println("ERROR getting countries:\n\n " + e);
        }
        return null;
    }

    private ArrayList<Country> returnCountryResultAsList(ResultSet rset) throws SQLException
    {
        ArrayList<Country> countries = new ArrayList<>();
        // Check one is returned
        while (rset.next()) {
            Country cnt = new Country();
            cnt.setCode(rset.getString("code"));
            cnt.setName(rset.getString("name"));
            cnt.setContinent(rset.getString("continent"));
            cnt.setRegion(rset.getString("region"));
            cnt.setPopulation(rset.getInt("population"));
            cnt.setCapital(rset.getString("capital"));
            countries.add(cnt);
        }
        return countries;
    }

    /**
     * Gets country data.
     *
     * @param filterType the filter type
     * @param filter     the filter
     * @param limit      the limit
     * @return the country data
     */
    public ArrayList<City> getCityData(String filterType, String filter, Integer limit)
    {
        switch (filterType) {
            case WORLD:
                if (limit != null && limit > 0) {
                    return getCities(filterType, null, CITY_SELECT_STATEMENT_WORLD +
                            LIMIT_ROWS_RETURNED + limit + STATEMENT_END);
                } else {
                    return getCities(filterType, null, CITY_SELECT_STATEMENT_WORLD + STATEMENT_END);
                }
            case CONTINENT:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_CONTINENT +
                                LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    } else
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_CONTINENT +
                                STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCityData()!");
                    throw new NullPointerException("You must enter a a valid continent!");
                }
            case REGION:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_REGION
                                + LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    }
                    else
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_REGION
                                + STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCityData()!");
                    throw new NullPointerException("You must enter a a valid region!");
                }
            case COUNTRY:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_COUNTRY
                                + LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    }
                    else
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_COUNTRY
                                + STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCityData()!");
                    throw new NullPointerException("You must enter a a valid country!");
                }
            case DISTRICT:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_DISTRICT
                                + LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    }
                    else
                    {
                        return getCities(filterType, filter, CITY_SELECT_STATEMENT_BY_DISTRICT
                                + STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCityData()!");
                    throw new NullPointerException("You must enter a a valid district!");
                }
            default:
                throw new IllegalArgumentException("Filter Type not valid!");
        }
    }

    private ArrayList<City> getCities(String filterType, String filter, String sqlStatement)
    {
        //DEBUG System.out.println(sqlStatement);
        try
        {
            if (filter != null && !filter.isEmpty())
            {
                return returnCityResultAsList(getResultSet(filter, sqlStatement));
            } else if (filter == null)
            {
                return returnCityResultAsList(getResultSet(sqlStatement));
            }
        } catch (Exception e) {
            System.out.println("ERROR getting cities:\n\n " + e);
        }
        return null;
    }

    private ArrayList<City> returnCityResultAsList(ResultSet rset) throws SQLException
    {
        ArrayList<City> cities = new ArrayList<>();
        // Check one is returned
        while (rset.next()) {
            City city = new City();
            city.setId(rset.getInt("id"));
            city.setName(rset.getString("name"));
            city.setDistrict(rset.getString("district"));
            city.setCountry(rset.getString("country"));
            city.setPopulation(rset.getInt("population"));
            cities.add(city);
        }
        return cities;
    }

    /**
     * Gets country data.
     *
     * @param filterType the filter type
     * @param filter     the filter
     * @param limit      the limit
     * @return the country data
     */
    public ArrayList<City> getCapitalCityData(String filterType, String filter, Integer limit)
    {
        switch (filterType) {
            case WORLD:
                if (limit != null && limit > 0) {
                    return getCapitalCities(null, CAPITAL_SELECT_STATEMENT_WORLD +
                            LIMIT_ROWS_RETURNED + limit + STATEMENT_END);
                } else {
                    return getCapitalCities(null, CAPITAL_SELECT_STATEMENT_WORLD + STATEMENT_END);
                }
            case CONTINENT:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCapitalCities(filter, CAPITAL_SELECT_STATEMENT_BY_CONTINENT +
                                LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    } else
                    {
                        return getCapitalCities(filter, CAPITAL_SELECT_STATEMENT_BY_CONTINENT +
                                STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCapitalCityData()!");
                    throw new NullPointerException("You must enter a a valid continent!");
                }
            case REGION:
                if (filter != null && !filter.isEmpty())
                {
                    if (limit != null && limit > 0)
                    {
                        return getCapitalCities(filter, CAPITAL_SELECT_STATEMENT_BY_REGION
                                + LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);
                    }
                    else
                    {
                        return getCapitalCities(filter, CAPITAL_SELECT_STATEMENT_BY_REGION
                                + STATEMENT_END);
                    }
                } else
                {
                    System.out.println("ERROR: com.napier.sem.App.getCapitalCityData()!");
                    throw new NullPointerException("You must enter a a valid region!");
                }
            default:
                throw new IllegalArgumentException("Filter Type not valid!");
        }
    }

    private ArrayList<City> getCapitalCities(String filter, String sqlStatement)
    {
        //DEBUG System.out.println(sqlStatement);
        try
        {
            if (filter != null && !filter.isEmpty())
            {
                return returnCapitalResultAsList(getResultSet(filter, sqlStatement));
            } else if (filter == null)
            {
                return returnCapitalResultAsList(getResultSet(sqlStatement));
            }
        } catch (Exception e) {
            System.out.println("ERROR getting cities:\n\n " + e);
        }
        return null;
    }

    private ArrayList<City> returnCapitalResultAsList(ResultSet rset) throws SQLException
    {
        ArrayList<City> capitals = new ArrayList<>();
        // Check one is returned
        while (rset.next()) {
            City capital = new City();
            capital.setName(rset.getString("name"));
            capital.setCountry(rset.getString("country"));
            capital.setPopulation(rset.getInt("population"));
            capitals.add(capital);
        }
        return capitals;
    }

    /**
     * Gets country data.
     *
     * @param filterType the filter type
     * @param filter     the filter
     * @param limit      the limit
     * @return the country data
     */
    public ArrayList<Population> getPopulationData(String filterType, String filter, Integer limit) {
        switch (filterType)
        {
            case WORLD:
                return getPopulation(filterType, CAPITAL_SELECT_STATEMENT_WORLD +
                            LIMIT_ROWS_RETURNED + limit + STATEMENT_END);
            case CONTINENT:
                        return getPopulation(filterType, CAPITAL_SELECT_STATEMENT_BY_CONTINENT +
                                LIMIT_ROWS_RETURNED + limit.toString() + STATEMENT_END);

            case REGION:
                        return getPopulation(filterType, CAPITAL_SELECT_STATEMENT_BY_REGION
                                + STATEMENT_END);
            default:
                throw new IllegalArgumentException("Filter Type not valid!");
        }
    }

    private ArrayList<Population> getPopulation(String filterType, String sqlStatement)
    {
        //DEBUG System.out.println(sqlStatement);
        try
        {
            return returnPopulationResultAsList(getResultSet(sqlStatement));
        } catch (Exception e)
        {
            System.out.println("ERROR getting cities:\n\n " + e);
        }
        return null;
    }

    private ArrayList<Population> returnPopulationResultAsList(ResultSet rset) throws SQLException
    {
        ArrayList<Population> population = new ArrayList<>();
        // Check one is returned
        while (rset.next())
        {
            Population pop = new Population();
            pop.setLocationName(rset.getString("name"));
            pop.setWholeLocationPopulation(rset.getInt("population"));
            pop.setWholeLocationPopulationInCities(rset.getInt("country"));
            pop.setWholeLocationPopulationNotInCities(rset.getInt("population"));
            population.add(pop);
        }
        return population;
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

    private ResultSet getResultSet(String sqlStatement) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(sqlStatement);
        //DEBUG System.out.println(stmt.toString());
        return stmt.executeQuery();
    }


    private ResultSet getResultSet(String filter, String sqlStatement) throws SQLException {
        PreparedStatement stmt = con.prepareStatement(sqlStatement);
        stmt.setString(1, filter);
        //DEBUG System.out.println(stmt.toString());
        return stmt.executeQuery();
    }

    /**
     * Print countries.
     *
     * @param countries the countries
     */
    public void printCountries(ArrayList<Country> countries)
    {
        if (countries != null && !countries.isEmpty())
        {
            System.out.printf((FIXED_WIDTH_FORMATTING_WORLD) + "%n", "Country Code", "Country Name", "Country Continent"
                    , "Country Region", "Country Population", "Country Capital");

            for (Country country : countries)
            {
                String country_string =
                        String.format(FIXED_WIDTH_FORMATTING_WORLD,
                                country.getCode(), country.getName(), country.getContinent(), country.getRegion(),
                                country.getPopulation(), country.getCapital());
                System.out.println(country_string);
            }

        } else {
            System.out.println("ERROR! - Countries List Is Empty!");
        }
    }
    /**
     * Print cities.
     *
     * @param cities the cities
     */
    public void printCities(ArrayList<City> cities)
    {
        if(cities != null && !cities.isEmpty()) {
            System.out.printf((FIXED_WIDTH_FORMATTING_CITY) + "%n", "Name", "Country", "District", "Population");
            for (City city : cities) {
                String city_string =
                        String.format(FIXED_WIDTH_FORMATTING_CITY,
                                city.getName(), city.getCountry(), city.getDistrict(),
                                city.getPopulation());
                System.out.println(city_string);
            }
        }
        else
        {
            throw new NullPointerException("ERROR! - Cities List Is Empty!");
        }
    }

    /**
     * Print countries.
     *
     * @param cities the countries
     */
    public void printCapitals(ArrayList<City> cities)
    {
        if (cities != null && !cities.isEmpty())
        {
            System.out.printf((FIXED_WIDTH_FORMATTING_CAP_CITY) + "%n","City Name", "Country"
                    ,"Population");

            for (City city : cities)
            {
                String city_string =
                        String.format(FIXED_WIDTH_FORMATTING_CAP_CITY,
                                city.getName(), city.getCountry(),
                                city.getPopulation());
                System.out.println(city_string);
            }

        } else {
            System.out.println("ERROR! - Countries List Is Empty!");
        }
    }

    /**
     * Print population.
     *
     * @param populations the populations
     */
    public void printPopulation(ArrayList<Population> populations)
    {
        if(populations != null && !populations.isEmpty()) {
            System.out.printf((FIXED_WIDTH_FORMATTING_POPULATION) + "%n", "Name", "Total Population", "City Population",
                    "%", "Non-City Population", "%");
            for (Population population : populations) {
                String population_string =
                        String.format(FIXED_WIDTH_FORMATTING_POPULATION,
                                population.getLocationName(), population.getWholeLocationPopulation(),
                                population.getWholeLocationPopulationInCities(),
                                population.getWholeLocationPopulationInCitiesPercentage(),
                                population.getWholeLocationPopulationNotInCities(),
                                population.getWholeLocationPopulationNotInCitiesPercentage());
                System.out.println(population_string);
            }
        }
        else
        {
            throw new NullPointerException("ERROR! - Population List Is Empty!");
        }
    }

}