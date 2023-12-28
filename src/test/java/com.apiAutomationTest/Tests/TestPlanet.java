package com.apiAutomationTest.Tests;

import com.apiAutomationTest.Request.Planet;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;

public class TestPlanet {
    private Planet planet = new Planet();

    public TestPlanet() throws IOException {
    }

    @Test(dependsOnMethods = {"com.apiAutomationTest.Tests.TestMovie.movieTest"})
    public void planetsTest(ITestContext context) throws IOException {
        List<String> planets = (List<String>) context.getAttribute("planets");
        planet.responsePlanets(planets.get(0));
        planet.gravityValidate();
        planet.terrainsValidate();
    }
}
