package com.apiAutomationTest.Request;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class Movie {
    private Response responseFilm;

    public Response responseFilms(String url){
        this.responseFilm = RestAssured.get(url);
        Assert.assertEquals(responseFilm.getStatusCode(),200);
        return responseFilm;
    }

    public void dateValidator(){
        boolean isCorrect;
        String dateFilm = responseFilm.jsonPath().get("release_date");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);

        try{
            dateFormat.parse(dateFilm);
            System.out.println("El formato es correcto.");
            isCorrect=true;
        }catch(ParseException e){
            System.out.println(e.getMessage());
            isCorrect=false;
        }
        Assert.assertTrue(isCorrect);
    }

    public void charactersValidator(){
        List<String> characters = responseFilm.jsonPath().getList("characters");
        Assert.assertFalse(characters.isEmpty());
    }
    public void planetsValidator(){
        List<String> planets = responseFilm.jsonPath().getList("planets");
        Assert.assertFalse(planets.isEmpty());
    }
    public void starshipsValidator(){
        List<String> starships = responseFilm.jsonPath().getList("starships");
        Assert.assertFalse(starships.isEmpty());
    }
    public void vehiclesValidator(){
        List<String> vehicles = responseFilm.jsonPath().getList("vehicles");
        Assert.assertFalse(vehicles.isEmpty());
    }
    public void speciesValidator(){
        List<String> species = responseFilm.jsonPath().getList("species");
        Assert.assertFalse(species.isEmpty());
    }

    public List<String> getPlanets(){
        List<String> planets = responseFilm.jsonPath().getList("planets");
        Assert.assertFalse(planets.isEmpty());
        return planets;
    }

    public List<String> listOPlanets(){
        return this.responseFilm.jsonPath().getList("planets");
    }

    public void error404(String url){
        this.responseFilm = RestAssured.get(url);
        Assert.assertEquals(responseFilm.getStatusCode(),404);
    }
}
