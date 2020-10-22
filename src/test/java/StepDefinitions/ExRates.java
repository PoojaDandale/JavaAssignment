package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static io.restassured.RestAssured.*;
import org.testng.Assert;
import io.restassured.response.Response;
import static org.hamcrest.CoreMatchers.equalTo;

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
	
	@Then("Validate the response")
	public void validate_the_response() {
	    r.then().body("base", equalTo("EUR"));
	    System.out.println("Body validation");
	}

	@When("An incorrect or incomplete url is provided")
	public void an_incorrect_or_incomplete_url_is_provided() {
	    r=given().get("https://api.ratesapi.io/api/");
	}

	@Then("Validate the correct response")
	public void validate_the_correct_response() {
	    System.out.println("Incorrect url");
	    r.then().body("error",equalTo("time data 'api' does not match format '%Y-%m-%d'"));
	}
	
	Response res;
	
	@Given("Rates API for specific date Foreign Exchange rates")
	public void rates_API_for_specific_date_Foreign_Exchange_rates() {
	    System.out.println("API launch for foreign rates");
	}

	@When("The API is available for foreign")
	public void the_API_is_available_for_foreign() {
	   res = given().get("https://api.ratesapi.io/api/2020-10-22");
	}

	@Then("success status")
	public void success_status() {
		System.out.println("Status code"+res.getStatusCode());
		Assert.assertEquals(200,res.getStatusCode());
	    	}

	
	@Then("response assertion")
	public void response_assertion() {
	    res.then().body("base",equalTo("EUR"));	}

	
	@When("The future date is privided in the url")
	public void the_future_date_is_privided_in_the_url() {
		res=given().get("https://api.ratesapi.io/api/2020-12-15");
	    	}

	@Then("future validation")
	public void future_validation() {
	    res.then().body("date",equalTo("2020-10-08"));
	}


}