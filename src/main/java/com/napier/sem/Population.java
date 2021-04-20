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
    private Long wholeLocationPopulation;

    /*
    * The total population of the continent/region/country living in cities (including a %).
    * */
    private Long wholeLocationPopulationInCities;

    private double wholeLocationPopulationInCitiesPercentage;
    /*
    * The total population of the continent/region/country not living in cities (including a %).
    * */
    private Long wholeLocationPopulationNotInCities;

    private double wholeLocationPopulationNotInCitiesPercentage;

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
     */
    public Population(String locationName, Long wholeLocationPopulation, Long wholeLocationPopulationInCities) {
        this.locationName = locationName;
        this.wholeLocationPopulation = wholeLocationPopulation;
        this.wholeLocationPopulationInCities = wholeLocationPopulationInCities;
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
    public Long getWholeLocationPopulation() {
        return wholeLocationPopulation;
    }

    /**
     * Sets whole location population.
     *
     * @param wholeLocationPopulation the whole location population
     */
    public void setWholeLocationPopulation(Long wholeLocationPopulation) {
        this.wholeLocationPopulation = wholeLocationPopulation;
    }

    /**
     * Gets whole location population in cities.
     *
     * @return the whole location population in cities
     */
    public Long getWholeLocationPopulationInCities() {
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
    public double getWholeLocationPopulationInCitiesPercentage()
    {
        wholeLocationPopulationInCitiesPercentage = Math.round(((double)getWholeLocationPopulationInCities()/(double)getWholeLocationPopulation())*100);
        return wholeLocationPopulationInCitiesPercentage;
    }


    /**
     * Sets whole location population in cities.
     *
     * @param wholeLocationPopulationInCities the whole location population in cities
     */
    public void setWholeLocationPopulationInCities(Long wholeLocationPopulationInCities) {
        this.wholeLocationPopulationInCities = wholeLocationPopulationInCities;
    }

    /**
     * Gets whole location population not in cities.
     *
     * @return the whole location population not in cities
     */
    public Long getWholeLocationPopulationNotInCities() {
        wholeLocationPopulationNotInCities = wholeLocationPopulation - wholeLocationPopulationInCities;
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
    public double getWholeLocationPopulationNotInCitiesPercentage()
    {   wholeLocationPopulationNotInCitiesPercentage = Math.round(((double)getWholeLocationPopulationNotInCities()/(double)getWholeLocationPopulation())*100);
        return wholeLocationPopulationNotInCitiesPercentage;
    }

    /**
     * Sets whole location population not in cities.
     *
     * @param wholeLocationPopulationNotInCities the whole location population not in cities
     */
    public void setWholeLocationPopulationNotInCities(Long wholeLocationPopulationNotInCities) {
        this.wholeLocationPopulationNotInCities = wholeLocationPopulationNotInCities;
    }

}
