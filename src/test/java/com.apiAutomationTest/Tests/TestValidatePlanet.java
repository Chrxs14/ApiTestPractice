package com.apiAutomationTest.Tests;

import com.apiAutomationTest.Request.Movie;
import com.apiAutomationTest.Request.People;
import com.apiAutomationTest.Request.Planet;
import com.apiAutomationTest.utils.Constants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class TestValidatePlanet {
    private People people = new People();
    private Planet planet = new Planet();
    private String apiUrl = Constants.API_URL;
    private String peopleEndpoint = Constants.API_URL_PEOPLE_ENDPOINT;
    private Map<String, Object> peopleBody;
    private Movie movie = new Movie();

    @Test
    public void validatePlanetTest(){
        people.consultEndpointStatusCode(apiUrl+peopleEndpoint, "2");

        peopleBody = people.getPeopleInfo();
        people.setPeopleData(peopleBody);

        List<String> listOfFilms = people.listOfFilms();
        movie.responseFilms(listOfFilms.get(1));

        List<String> planets = movie.listOPlanets();
        planet.responsePlanets(planets.get(0));

        String url = planet.getUrlResponsePlanet();
        planet.validatePlanet(url, planet.responsePlanets(planets.get(0)));
    }
}
