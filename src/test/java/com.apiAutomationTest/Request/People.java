package com.apiAutomationTest.Request;

import com.apiAutomationTest.utils.Constants;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class People {
    private String apiUrl;
    private String id;
    private Map<String, Object> peopleData;
    private String name;
    private String skinColor;
    private List<String> films;
    private Response responsePeople;

    public People() {
    }

    //Response people

    public Response getResponse(){
        String apiUrl = Constants.API_URL;
        String endpoint = Constants.API_URL_PEOPLE_ENDPOINT;
        String id = "2";

        this.responsePeople = RestAssured.get(apiUrl+endpoint+id);

        Assert.assertEquals(responsePeople.getStatusCode(), 200);
        return this.responsePeople;
    }

    public void consultEndpointStatusCode(String endpoint, String id){
        this.apiUrl = endpoint;
        this.id = id;
        Response responsePeople = RestAssured.get(endpoint+id);

        Assert.assertEquals(responsePeople.getStatusCode(), 200);
        responsePeople.getStatusCode();
    }

    //Name

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    //Skin
    public String getSkinColor() {
        return skinColor;
    }

    public void setSkinColor(String skinColor) {
        this.skinColor = skinColor;
    }

    public void validateSkinColor(String skinColor){
        Assert.assertEquals(skinColor, this.skinColor);
    }

    //Films

    public List<String> getFimls() {
        return films;
    }

    public void setfimls(List<String> fimls) {
        this.films = fimls;
    }

    public void validateAmountOfFilms(int filmsAmount){
        Assert.assertEquals(this.films.size(), filmsAmount);
    }

    //People Data

    public Map<String, Object> getPeopleData() {
        return peopleData;
    }

    public void setPeopleData(Map<String, Object> peopleData) {
        this.peopleData = peopleData;
    }

    public Map<String, Object> getPeopleInfo(){
        String apiUrl = Constants.API_URL;
        String endpoint = Constants.API_URL_PEOPLE_ENDPOINT;
        String id = "2";

        this.responsePeople = RestAssured.get(apiUrl+endpoint+id);

        Assert.assertEquals(responsePeople.getStatusCode(), 200);
        return responsePeople.jsonPath().getMap("$");
    }

    public List<String> listOfFilms(){
        String apiUrl = Constants.API_URL;
        String endpoint = Constants.API_URL_PEOPLE_ENDPOINT;
        String id = "2";

        this.responsePeople = RestAssured.get(apiUrl+endpoint+id);

        Assert.assertEquals(responsePeople.getStatusCode(), 200);
        return responsePeople.jsonPath().getList("films");
    }
}
