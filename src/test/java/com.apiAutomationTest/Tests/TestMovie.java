package com.apiAutomationTest.Tests;

import com.apiAutomationTest.Request.Movie;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.List;

public class TestMovie{
    private Movie movie = new Movie();
    @Test(dependsOnMethods = {"com.apiAutomationTest.Tests.TestPeople.peopleTest"})
    public void movieTest(ITestContext context){
         List<String>  films = (List<String>) context.getAttribute("films");
         movie.responseFilms(films.get(1));
         movie.dateValidator();
         movie.charactersValidator();
         movie.planetsValidator();
         movie.starshipsValidator();
         movie.vehiclesValidator();
         movie.speciesValidator();

         context.setAttribute("planets", movie.getPlanets());
    }
}
