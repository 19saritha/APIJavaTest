package stepDefinitions;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import objects.BikeAPI;
import org.junit.Assert;

public class BikeAPIStepDefs {
    public static RequestSpecification httpRequest;
    public static Response response;
    public BikeAPI bikeAPI = new BikeAPI();

    @Given("I create a request with base URL {string} and with basepath {string}")
    public void iCreateARequest(String baseUrl, String basePath) {
        httpRequest = bikeAPI.createAPIRequest(baseUrl, basePath);

    }

    @When("I fire a get request")
    public void iFireAGetRequest() {

        response = bikeAPI.getAPIResponse(httpRequest);
        Assert.assertEquals(response.getStatusCode(), 200);
    }

    @Then("I verify that in the response the city {string} is in the country {string}")
    public void iVerifyThatTheCityCityIsInTheCountryCountry(String city, String country){
        Assert.assertTrue("Country: "+ country + " doesn't for City: "+ city +".", bikeAPI.checkCityInCountry(city, country));

    }

    @Then("I return their corresponded latitude and longitude of the given city")
    public void iReturnTheirCorrespondedLatitudeAndLongitudeOfTheGivenCity() {
        System.out.println(bikeAPI.getLongitude());
        System.out.println(bikeAPI.getLatitude());
    }
}
