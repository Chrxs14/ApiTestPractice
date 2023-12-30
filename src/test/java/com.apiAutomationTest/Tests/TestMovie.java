package com.apiAutomationTest.Tests;

import com.apiAutomationTest.Request.Movie;
import com.apiAutomationTest.Request.People;
import com.apiAutomationTest.utils.Constants;
import io.restassured.response.Response;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class TestMovie{
    private People people = new People();
    private String apiUrl = Constants.API_URL;
    private String peopleEndpoint = Constants.API_URL_PEOPLE_ENDPOINT;
    private Map<String, Object> peopleBody;
    private Movie movie = new Movie();
    @Test
    public void movieTest(){
        people.consultEndpointStatusCode(apiUrl+peopleEndpoint, "2");

        peopleBody = people.getPeopleInfo();
        people.setPeopleData(peopleBody);

        List<String> listOfFilms = people.listOfFilms();

         movie.responseFilms(listOfFilms.get(1));

         movie.dateValidator();
         movie.charactersValidator();
         movie.planetsValidator();
         movie.starshipsValidator();
         movie.vehiclesValidator();
         movie.speciesValidator();
    }
}
