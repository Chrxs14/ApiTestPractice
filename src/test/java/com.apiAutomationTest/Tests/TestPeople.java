package com.apiAutomationTest.Tests;

import com.apiAutomationTest.Request.People;
import com.apiAutomationTest.utils.providers.Constants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.filters;
import static io.restassured.RestAssured.given;

public class TestPeople {
    private People people;
    private String apiUrl = Constants.API_URL;
    private String peopleEndpoint = Constants.API_URL_PEOPLE_ENDPOINT;
    private Map<String, Object> peopleBody;

    @Test(description = "Request /people/2")
    public void peopleTest() throws IOException {

        people = new People();
        people.consultEndpointStatusCode(apiUrl+peopleEndpoint, "2");
        Response response = people.getResponse();

        peopleBody = people.getPeopleInfo();
        people.setPeopleData(peopleBody);

        people.setName((String) response.jsonPath().get("name"));
        people.setSkinColor((String) response.jsonPath().get("skin_color"));
        people.setfimls(response.jsonPath().getList("films"));

        people.validateSkinColor(Constants.SKINCOLOR);
        people.validateAmountOfFilms(Constants.FILMSAMOUNT);

    }
}
