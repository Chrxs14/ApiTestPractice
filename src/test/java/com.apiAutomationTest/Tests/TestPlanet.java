package com.apiAutomationTest.Tests;

import org.testng.annotations.Test;

public class TestPlanet {

    @Test(dependsOnMethods = {"com.apiAutomationTest.Tests.TestPeople.movieTest"})
    public void planetsTest(){
        
    }
}
