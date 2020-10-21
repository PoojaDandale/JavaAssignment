package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import io.restassured.response.Response;


public class ExRates{
	
	Response r;
	@Given("Rates API for Latest Foreign Exchange rates")
	public void rates_api_for_latest_foreign_exchange_rates() {
	    System.out.println("API Launch");
	}

	@When("The API is available")
	public void the_api_is_available() {
	    r = given().get("https://api.ratesapi.io/api/latest");
	}

	@Then("Validate the code")
	public void validate_the_code() {
	    Assert.assertEquals(200, r.getStatusCode());
	    System.out.println("Status Code="+r.getStatusCode());
	}

}