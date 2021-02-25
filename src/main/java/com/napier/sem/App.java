package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;


/**
 * The type App.
 *
 * @author scottmcmahon 40343450
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

        //TODO remove this in future releases!!!!
        //testing a get countries method for the moment.
        for(Country c : a.getCountry())
        {
            System.out.println(c.getName());
        }


        // Disconnect from database
        a.disconnect();

    }


    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

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
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     * Gets country.
     *
     * @return the country or null if exception hit
     */
    public ArrayList<Country> getCountry()
    {
        //TODO review this as it was quickly written to prove MYSQL
        // Docker image is working and connected as expected
        try
        {
            // Create an SQL statement
            Statement stmt = con.createStatement();
            // Create string for SQL statement
            String strSelect =
                    "SELECT code, name, continent, region, population, capital FROM country ORDER BY Population DESC;";
            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strSelect);

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
                cnt.capital = rset.getInt("capital");
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



}