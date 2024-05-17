package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.products.GetProductRatings;

public class GetProductRatingsSteps{
    private GetProductRatings getProductRatings = new GetProductRatings();

    @Given("I set the API endpoint for retrieving product ratings")
    public void setApiEndpointForRetrievingProductRatings() {
        getProductRatings.setApiEndpointForRetrievingProductRatings();
    }

    @Given("I set an invalid API endpoint for retrieving product ratings")
    public void setInvalidApiEndpointForRetrievingProductRatings() {
        getProductRatings.setInvalidApiEndpointForRetrievingProductRatings();
    }

    @When("I send a GET request to retrieve product ratings for product")
    public void sendGetRequestToRetrieveProductRatings() {
        getProductRatings.sendGetRequestToRetrieveProductRatings();
    }

    @When("I send a GET request to retrieve product ratings for product with invalid endpoint")
    public void sendGetRequestToRetrieveProductRatingsInvalidEndpoint() {
        getProductRatings.sendGetRequestToRetrieveProductRatingsInvalidEndpoint();
    }

    @Then("I receive status code product ratings 200")
    public void receiveStatusCodeProductRatings200() {
        getProductRatings.receiveStatusCodeProductRatings200();
    }

    @And("the response contains product ratings data")
    public void verifyProductRatingsData() {
        getProductRatings.verifyProductRatingsData();
    }

    @Then("I receive status code product ratings 400")
    public void receiveStatusCodeProductRatings400() {
        getProductRatings.receiveStatusCodeProductRatings400();
    }

}
