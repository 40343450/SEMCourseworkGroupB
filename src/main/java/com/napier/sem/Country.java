package com.napier.sem;

/**
 * The type Country.
 */
public class Country {
    /**
     * The Code.
     */
    public String code;
    /**
     * The Name.
     */
    public String name;
    /**
     * The Continent.
     */
    public String continent;
    /**
     * The Region.
     */
    public String region;
    /**
     * The Population.
     */
    public int population;
    /**
     * The Capital.
     */
    public String capital;


    /**
     * Instantiates a new Country.
     */
    public Country() {
    }

    /**
     * Instantiates a new Country.
     *
     * @param code       the code
     * @param name       the name
     * @param continent  the continent
     * @param region     the region
     * @param population the population
     * @param capital    the capital
     */
    public Country(String code, String name, String continent, String region, int population, String capital) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
    }


    @Override
    public String toString() {
        return "Country{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", continent='" + continent + '\'' +
                ", region='" + region + '\'' +
                ", population=" + population +
                ", capital='" + capital + '\'' +
                '}';
    }

    /**
     * Gets code.
     *
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * Sets code.
     *
     * @param code the code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets continent.
     *
     * @return the continent
     */
    public String getContinent() {
        return continent;
    }

    /**
     * Sets continent.
     *
     * @param continent the continent
     */
    public void setContinent(String continent) {
        this.continent = continent;
    }

    /**
     * Gets region.
     *
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * Sets region.
     *
     * @param region the region
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(int population) {
        this.population = population;
    }

    /**
     * Gets capital.
     *
     * @return the capital
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Sets capital.
     *
     * @param capital the capital
     */
    public void setCapital(String capital) {
        this.capital = capital;
    }
}
