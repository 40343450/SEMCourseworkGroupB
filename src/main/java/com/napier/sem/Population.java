package com.napier.sem;

/**
 * The type Population.
 */
public class Population
{
    /*
    * The name of the continent/region/country.
    * */
    private String locationName;

    /*
    * The total population of the continent/region/country.
    * */
    private long wholeLocationPopulation;

    /*
    * The total population of the continent/region/country living in cities (including a %).
    * */
    private int wholeLocationPopulationInCities;
    /*
    * The total population of the continent/region/country not living in cities (including a %).
    * */
    private int wholeLocationPopulationNotInCities;

    /**
     * Instantiates a new Population.
     */
    public Population() {
    }

    /**
     * Instantiates a new Population.
     *
     * @param locationName                       the location name
     * @param wholeLocationPopulation            the whole location population
     * @param wholeLocationPopulationInCities    the whole location population in cities
     * @param wholeLocationPopulationNotInCities the whole location population not in cities
     */
    public Population(String locationName, int wholeLocationPopulation, int wholeLocationPopulationInCities, int wholeLocationPopulationNotInCities) {
        this.locationName = locationName;
        this.wholeLocationPopulation = wholeLocationPopulation;
        this.wholeLocationPopulationInCities = wholeLocationPopulationInCities;
        this.wholeLocationPopulationNotInCities = wholeLocationPopulationNotInCities;
    }

    /**
     * Gets location name.
     *
     * @return the location name
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * Sets location name.
     *
     * @param locationName the location name
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * Gets whole location population.
     *
     * @return the whole location population
     */
    public long getWholeLocationPopulation() {
        return wholeLocationPopulation;
    }

    /**
     * Sets whole location population.
     *
     * @param wholeLocationPopulation the whole location population
     */
    public void setWholeLocationPopulation(long wholeLocationPopulation) {
        this.wholeLocationPopulation = wholeLocationPopulation;
    }

    /**
     * Gets whole location population in cities.
     *
     * @return the whole location population in cities
     */
    public int getWholeLocationPopulationInCities() {
        return wholeLocationPopulationInCities;
    }

    /**
     * Gets whole location population in cities percentage.
     *
     * @return the whole location population in cities percentage
     */
    /*
    * The total population of the continent/region/country living in cities (including a %).
    * */
    public String getWholeLocationPopulationInCitiesPercentage()
    {
        return ((getWholeLocationPopulationInCities()/wholeLocationPopulation)*100)+" %";
    }


    /**
     * Sets whole location population in cities.
     *
     * @param wholeLocationPopulationInCities the whole location population in cities
     */
    public void setWholeLocationPopulationInCities(int wholeLocationPopulationInCities) {
        this.wholeLocationPopulationInCities = wholeLocationPopulationInCities;
    }

    /**
     * Gets whole location population not in cities.
     *
     * @return the whole location population not in cities
     */
    public int getWholeLocationPopulationNotInCities() {
        return wholeLocationPopulationNotInCities;
    }

    /**
     * Gets whole location population not in cities percentage.
     *
     * @return the whole location population not in cities percentage
     */
    /*
    *The total population of the continent/region/country not living in cities (including a %).
    * */
    public String getWholeLocationPopulationNotInCitiesPercentage()
    {
        return ((getWholeLocationPopulationNotInCities()/wholeLocationPopulation)*100)+" %";
    }

    /**
     * Sets whole location population not in cities.
     *
     * @param wholeLocationPopulationNotInCities the whole location population not in cities
     */
    public void setWholeLocationPopulationNotInCities(int wholeLocationPopulationNotInCities) {
        this.wholeLocationPopulationNotInCities = wholeLocationPopulationNotInCities;
    }

}
