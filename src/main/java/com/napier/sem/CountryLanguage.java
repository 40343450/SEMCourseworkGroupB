package com.napier.sem;

import java.math.BigDecimal;

/**
 * The type Country language.
 */
public class CountryLanguage {

    private String code;
    private String language;
    private String official;
    private double percentage;
    private Population population;

    /**
     * Instantiates a new Country language.
     *
     * @param code       the code
     * @param language   the language
     * @param official   the official
     * @param percentage the percentage
     * @param population the population
     */
    public CountryLanguage(String code, String language, String official, double percentage, Population population) {
        this.code = code;
        this.language = language;
        this.official = official;
        this.percentage = percentage;
        this.population = population;
    }

    /**
     * Instantiates a new Country language.
     */
    public CountryLanguage() {
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
     * Gets language.
     *
     * @return the language
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Sets language.
     *
     * @param language the language
     */
    public void setLanguage(String language) {
        this.language = language;
    }

    /**
     * Is official boolean.
     *
     * @return the boolean
     */
    public String isOfficial() {
        return official;
    }

    /**
     * Sets official.
     *
     * @param official the official
     */
    public void setOfficial(String official) {
        this.official = official;
    }

    /**
     * Gets percentage.
     *
     * @return the percentage
     */
    public double getPercentage() {
        return percentage;
    }

    /**
     * Sets percentage.
     *
     * @param percentage the percentage
     */
    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    /**
     * Gets population.
     *
     * @return the population
     */
    public Population getPopulation() {
        return population;
    }

    /**
     * Sets population.
     *
     * @param population the population
     */
    public void setPopulation(Population population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "CountryLanguage{" +
                "code='" + code + '\'' +
                ", language='" + language + '\'' +
                ", official=" + official +
                ", percentage=" + percentage +
                ", population=" + population +
                '}';
    }
}