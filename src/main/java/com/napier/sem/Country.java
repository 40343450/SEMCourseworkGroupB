package com.napier.sem;

import java.math.BigDecimal;

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
    public int capital;

    /**
     * The Surface area.
     */
    public BigDecimal surfaceArea;
    /**
     * The Indep year.
     */
    public Integer indepYear;
    /**
     * The Life expectancy.
     */
    public BigDecimal lifeExpectancy;
    /**
     * The G np.
     */
    public BigDecimal gNP;
    /**
     * The G np old.
     */
    public BigDecimal gNPOld;
    /**
     * The Local name.
     */
    public String localName;
    /**
     * The Government form.
     */
    public String governmentForm;
    /**
     * The Head of state.
     */
    public String headOfState;
    /**
     * The Code 2.
     */
    public String code2;

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

    /**
     * Instantiates a new Country.
     *
     * @param code           the code
     * @param name           the name
     * @param continent      the continent
     * @param region         the region
     * @param population     the population
     * @param capital        the capital
     * @param surfaceArea    the surface area
     * @param indepYear      the indep year
     * @param lifeExpectancy the life expectancy
     * @param gNP            the g np
     * @param gNPOld         the g np old
     * @param localName      the local name
     * @param governmentForm the government form
     * @param headOfState    the head of state
     * @param code2          the code 2
     */
    public Country(String code, String name, String continent, String region, int population, String capital, BigDecimal surfaceArea, Integer indepYear, BigDecimal lifeExpectancy, BigDecimal gNP, BigDecimal gNPOld, String localName, String governmentForm, String headOfState, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.population = population;
        this.capital = capital;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.lifeExpectancy = lifeExpectancy;
        this.gNP = gNP;
        this.gNPOld = gNPOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.code2 = code2;
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
                ", surfaceArea=" + surfaceArea +
                ", indepYear=" + indepYear +
                ", lifeExpectancy=" + lifeExpectancy +
                ", gNP=" + gNP +
                ", gNPOld=" + gNPOld +
                ", localName='" + localName + '\'' +
                ", governmentForm='" + governmentForm + '\'' +
                ", headOfState='" + headOfState + '\'' +
                ", code2='" + code2 + '\'' +
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

    /**
     * Gets surface area.
     *
     * @return the surface area
     */
    public BigDecimal getSurfaceArea() {
        return surfaceArea;
    }

    /**
     * Sets surface area.
     *
     * @param surfaceArea the surface area
     */
    public void setSurfaceArea(BigDecimal surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    /**
     * Gets indep year.
     *
     * @return the indep year
     */
    public Integer getIndepYear() {
        return indepYear;
    }

    /**
     * Sets indep year.
     *
     * @param indepYear the indep year
     */
    public void setIndepYear(Integer indepYear) {
        this.indepYear = indepYear;
    }

    /**
     * Gets life expectancy.
     *
     * @return the life expectancy
     */
    public BigDecimal getLifeExpectancy() {
        return lifeExpectancy;
    }

    /**
     * Sets life expectancy.
     *
     * @param lifeExpectancy the life expectancy
     */
    public void setLifeExpectancy(BigDecimal lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    /**
     * Gets np.
     *
     * @return the np
     */
    public BigDecimal getgNP() {
        return gNP;
    }

    /**
     * Sets np.
     *
     * @param gNP the g np
     */
    public void setgNP(BigDecimal gNP) {
        this.gNP = gNP;
    }

    /**
     * Gets np old.
     *
     * @return the np old
     */
    public BigDecimal getgNPOld() {
        return gNPOld;
    }

    /**
     * Sets np old.
     *
     * @param gNPOld the g np old
     */
    public void setgNPOld(BigDecimal gNPOld) {
        this.gNPOld = gNPOld;
    }

    /**
     * Gets local name.
     *
     * @return the local name
     */
    public String getLocalName() {
        return localName;
    }

    /**
     * Sets local name.
     *
     * @param localName the local name
     */
    public void setLocalName(String localName) {
        this.localName = localName;
    }

    /**
     * Gets government form.
     *
     * @return the government form
     */
    public String getGovernmentForm() {
        return governmentForm;
    }

    /**
     * Sets government form.
     *
     * @param governmentForm the government form
     */
    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    /**
     * Gets head of state.
     *
     * @return the head of state
     */
    public String getHeadOfState() {
        return headOfState;
    }

    /**
     * Sets head of state.
     *
     * @param headOfState the head of state
     */
    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    /**
     * Gets code 2.
     *
     * @return the code 2
     */
    public String getCode2() {
        return code2;
    }

    /**
     * Sets code 2.
     *
     * @param code2 the code 2
     */
    public void setCode2(String code2) {
        this.code2 = code2;
    }
}
