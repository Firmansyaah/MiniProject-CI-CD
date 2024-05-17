package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.products.AssignAProductRating;


public class AssignAProductRatingSteps {
    private final AssignAProductRating assignAProductRating = new AssignAProductRating();

    @Given("I set the API endpoint for assigning product rating")
    public void setApiEndpointForAssigningProductRating() {assignAProductRating.setApiEndpointForAssigningProductRating();
    }

    @Given("I set an invalid API endpoint for assigning product rating")
    public void setInvalidApiEndpointForAssigningProductRating() {
    assignAProductRating.setInvalidApiEndpointForAssigningProductRating();
    }

    @When("I send a POST request to assign a rating of 4 to product")
    public void sendPostRequestToAssignProductRating4() {
        assignAProductRating.sendPostRequestToAssignProductRating4();
    }
    @When("I send a POST request to assign a rating of 4 to product with invalid endpoint")
    public void sendPostRequestToAssignProductRating4WithInvalidEndpoint() {
        assignAProductRating.sendPostRequestToAssignProductRating4WithInvalidEndpoint();
    }

    @Then("I receive status code assign product rating 404")
    public void receiveStatusCodeAssignProductRating404() { assignAProductRating.receiveStatusCodeAssignProductRating404();}


    @Then("I receive status code assign product rating 200")
    public void receiveStatusCodeAssignProductRating200() { assignAProductRating.receiveStatusCodeAssignProductRating200(); }

}
