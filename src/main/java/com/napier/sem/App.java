package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


/**
 * This application is an attempt at the SET08403 2020-1 TR2 001 - Software Engineering Methods coursework.
 * The type app is the main implementation class for this submission.
 *
 * @author scottmcmahon 40343450 Last updated 01-03-2021
 */
public class App {
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

        //TODO REFACTOR >> REDUCE DUPLICATION BY IMPLEMENTING METHODS WHICH TAKE IN ARGUMENTS BASED ON WHAT IS BEING ASKED FO
        //TODO IMPLEMENT ALL USE CASES REMAINING (1,2,3 IMPLEMENTED)


        /*
        * USE CASE 1
        * */
        System.out.println("\n\nAs a user I would like to generate a report about all the countries in the world organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryListByWorld());

        /*
         * USE CASE 2
         * */
        System.out.println("\n\nAs a user I would like to generate a report about all the countries in a continent organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryListByContinent("Asia"));

        /*
         * USE CASE 3
         * */
        System.out.println("\n\nAs a user I would like to generate a report about all the countries in a region organised by largest population to smallest:\n\n");
        a.printCountries(a.getCountryListByRegion("Eastern Asia"));


        // Disconnect from database
        a.disconnect();
    }


    /**
     * Connection to database.
     */
    private Connection con = null;

    /**
     * Connect to database.
     * <p>
     * con in this context is the type Connection
     * <p>
     * This code is based on content from
     * https://github.com/Kevin-Sim/SET08103/tree/master/labs/lab03
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
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "coursework");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from database.
     * <p>
     * con in this context is the type Connection
     * <p>
     * This code is based on content from
     * https://github.com/Kevin-Sim/SET08103/tree/master/labs/lab03
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
     * Gets country list by world.
     * <p>
     * USE CASE 1
     * As a user I would like to generate a report about all the countries in the world organised by largest population to smallest.
     *
     * @return the country list by world
     */
    public ArrayList<Country> getCountryListByWorld()
    {
        try
        {
            // Create string for SQL statement
            String strSelect =
                    "SELECT country.code, country.name, country.continent, country.region, country.population, city.name as 'capital' FROM country, city where country.capital = city.id ORDER BY Population DESC;";
            PreparedStatement stmt = con.prepareStatement(strSelect);

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery();


            ArrayList<Country> countries  = new ArrayList<>();
            // Check one is returned
            while (rset.next())
            {
                Country cnt = new Country();
                cnt.code = rset.getString("code");
                cnt.name = rset.getString("name");
                cnt.continent = rset.getString("continent");
                cnt.region = rset.getString("region");
                cnt.population = rset.getInt("population");
                cnt.capital = rset.getString("capital");
                countries.add(cnt);
            }
            return countries;
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Gets country list by continent.
     * <p>
     * USE CASE 2
     * As a user I would like to generate a report about all the countries in a continent organised by largest population to smallest
     *
     * @param continent the continent
     * @return the country list by continent
     */
    public ArrayList<Country> getCountryListByContinent(String continent)
    {
        if(continent != null && !continent.isEmpty()) {
            try
            {

                // Create string for SQL statement
                String strSelect = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name as 'capital' FROM country, city where country.capital =  city.id and continent = ? ORDER BY Population DESC;";
                // Create an SQL statement
                PreparedStatement stmt = con.prepareStatement(strSelect);
                stmt.setString(1, continent);

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery();

                ArrayList<Country> countries = new ArrayList<>();
                // Check one is returned
                while (rset.next())
                {
                    Country cnt = new Country();
                    cnt.code = rset.getString("code");
                    cnt.name = rset.getString("name");
                    cnt.continent = rset.getString("continent");
                    cnt.region = rset.getString("region");
                    cnt.population = rset.getInt("population");
                    cnt.capital = rset.getString("capital");
                    countries.add(cnt);
                }
                return countries;
            } catch (Exception e) {
                System.out.println(e.getMessage());
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
     * <p>
     * USE CASE 3
     * As a user I would like to generate a report about all the countries in a region organised by largest population to smallest
     *
     * @param region the region
     * @return the country list by region
     */
    public ArrayList<Country> getCountryListByRegion(String region)
    {
        if(region != null && !region.isEmpty()) {
            try
            {

                // Create string for SQL statement
                String strSelect = "SELECT country.code, country.name, country.continent, country.region, country.population, city.name as 'capital' FROM country, city where country.capital =  city.id and region = ? ORDER BY Population DESC;";
                // Create an SQL statement
                PreparedStatement stmt = con.prepareStatement(strSelect);
                stmt.setString(1, region);

                // Execute SQL statement
                ResultSet rset = stmt.executeQuery();

                ArrayList<Country> countries = new ArrayList<>();
                // Check one is returned
                while (rset.next())
                {
                    Country cnt = new Country();
                    cnt.code = rset.getString("code");
                    cnt.name = rset.getString("name");
                    cnt.continent = rset.getString("continent");
                    cnt.region = rset.getString("region");
                    cnt.population = rset.getInt("population");
                    cnt.capital = rset.getString("capital");
                    countries.add(cnt);
                }
                return countries;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                return null;
            }
        }
        else
        {
            throw new NullPointerException("You must enter a a valid region!");
        }
    }


    /**
     * Print countries.
     *
     * @param countries the countries
     */
    /*
     * matches user requirement displaying code, name, continent, region, population & capital
     * (ISSUE #33 on ISSUE TRACKER)
     * */
    public void printCountries(ArrayList<Country> countries)
    {
        System.out.println(String.format("%-15s %-65s %-35s %-45s %-20s %-20s", "Country Code", "Country Name", "Country Continent", "Country Region", "Country Population", "Country Capital"));
        for(Country country : countries)
        {
            String country_string =
                    String.format("%-15s %-65s %-35s %-45s %-20s %-20s",
                            country.code, country.name, country.continent, country.region, country.population, country.capital);
            System.out.println(country_string);
        }
        //code, name, continent, region, population, capital
    }
}