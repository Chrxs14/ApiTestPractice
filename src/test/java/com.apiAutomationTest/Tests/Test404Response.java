package com.apiAutomationTest.Tests;

import com.apiAutomationTest.Request.Movie;
import com.apiAutomationTest.utils.Constants;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test404Response {
    private String apiUrl = Constants.API_URL;
    private Movie movie = new Movie();
    @Test
    public void validate404Error(){
        movie.error404(apiUrl + "/films/7");
    }
}
