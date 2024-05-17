package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.core.Serenity;
import starter.user.products.GetProductComments;

public class GetProductCommentsSteps {

    private GetProductComments getProductComments = new GetProductComments();

    @Given("I set the API endpoint for retrieving comments for a product")
    public void setApiEndpointForRetrievingComments() {
        getProductComments.setApiEndpointForRetrievingComments();
    }

    @When("I send a GET request to retrieve comments for the product")
    public void sendGetRequestToRetrieveComments() {
        Response response = getProductComments.sendGetRequestToRetrieveComments();
        Serenity.recordReportData().withTitle("Response").andContents(response.asString());
    }

    @Then("I receive a status code 200 indicating successful retrieval of comments")
    public void receiveSuccessfulRetrievalStatusCode200() {
        getProductComments.receiveSuccessfulRetrievalStatusCode200();
    }

    @Then("I receive the comments data for the product")
    public void receiveCommentsData() {
        getProductComments.receiveCommentsData();
    }

    @Given("I set an invalid API endpoint for retrieving comments for a product")
    public void setInvalidApiEndpointForRetrievingComments() {
        getProductComments.setInvalidApiEndpointForRetrievingComments();
    }

    @When("I send a GET request with an invalid product")
    public void sendGetRequestWithInvalidProductIDInvalidEndpoint() {
        getProductComments.sendGetRequestWithInvalidProductIDInvalidEndpoint();
    }

    @Then("I receive a status code 404 indicating failure to retrieve comments")
    public void receiveFailureStatusCode404() {
        getProductComments.receiveFailureStatusCode404();
    }


}
