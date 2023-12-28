package com.apiAutomationTest.Request;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Planet {
    private String expected_gravity;
    private String expected_terrains;

    private Response responsePlanet;
    Gson gson = new Gson();
    public void responsePlanets(String url){
        this.responsePlanet = RestAssured.get(url);
        Assert.assertEquals(responsePlanet.getStatusCode(),200);
    }

    public void gravityValidate() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/java/com.apiAutomationTest/utils/payloads/planet_data.json"));
        String payload = new String(bytes);
        String gravity = responsePlanet.jsonPath().get("gravity");

        JsonObject jsonObject = gson.fromJson(payload, JsonObject.class);
        this.expected_gravity = jsonObject.get("expected_gravity").getAsString();

        Assert.assertEquals(gravity, expected_gravity);
    }

    public void terrainsValidate() throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("src/test/java/com.apiAutomationTest/utils/payloads/planet_data.json"));
        String payload = new String(bytes);
        String terrains = responsePlanet.jsonPath().get("terrain");

        JsonObject jsonObject = gson.fromJson(payload, JsonObject.class);
        this.expected_terrains = jsonObject.get("expected_terrains").getAsString();

        Assert.assertEquals(terrains, expected_terrains);
    }

}
