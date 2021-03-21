package com.napier.sem;

/**
 * The type City.
 */
public class City {

    /**
     * The Id.
     */
    private Integer id;
    /**
     * The Name.
     */
    private String name;
    /**
     * The Country code.
     */
    private String country;
    /**
     * The District.
     */
    private String district;
    /**
     * The Population.
     */
    private Integer population;

    /**
     * Instantiates a new City.
     */
    public City() {
    }

    /**
     * Instantiates a new City.
     *
     * @param id          the id
     * @param name        the name
     * @param country the country code
     * @param district    the district
     * @param population  the population
     */
    public City(Integer id, String name, String country, String district, Integer population) {
        this.id = id;
        this.name = name;
        this.country = country;
        this.district = district;
        this.population = population;
    }

    @Override
    public String toString() {
        return "City{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", countryCode='" + country + '\'' +
                ", district='" + district + '\'' +
                ", population=" + population +
                '}';
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Integer id) {
        this.id = id;
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
     * Gets country code.
     *
     * @return the country code
     */
    public String getCountry() {
        return country;
    }

    /**
     * Sets country code.
     *
     * @param country the country code
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * Gets district.
     *
     * @return the district
     */
    public String getDistrict() {
        return district;
    }

    /**
     * Sets district.
     *
     * @param district the district
     */
    public void setDistrict(String district) {
        this.district = district;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public Integer getPopulation() {
        return population;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(Integer population) {
        this.population = population;
    }
}
