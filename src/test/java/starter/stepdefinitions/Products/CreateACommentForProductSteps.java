package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.products.CreateACommentForProduct;

public class CreateACommentForProductSteps {

    private final CreateACommentForProduct createACommentForProduct = new CreateACommentForProduct();

    @Given("I set the API endpoint for creating a comment for product")
    public void setApiEndpointForCreatingCommentForProduct() {
        createACommentForProduct.setApiEndpointForCreatingCommentForProduct();
    }

    @Given("I set an invalid API endpoint for creating a comment for product")
    public void setInvalidApiEndpointForCreatingCommentForProduct() {
        createACommentForProduct.setInvalidApiEndpointForCreatingCommentForProduct();
    }

    @When("I send a POST request to create a comment for product")
    public void sendPostRequestToCreateCommentForProduct() {
        createACommentForProduct.sendPostRequestToCreateCommentForProduct();
    }
    @When("I send a POST request to create a comment for product with invalid endpoint")
    public void sendPostRequestToCreateCommentForProductWithInvalidEndpoint() {
        createACommentForProduct.sendPostRequestToCreateCommentForProductWithInvalidEndpoint();
    }

    @Then("I receive status code create comment for product 200")
    public void receiveStatusCodeCreateACommentForProduct200() {
        createACommentForProduct.receiveStatusCodeCreateACommentForProduct200();
    }

    @Then("I receive status code create comment for product 404")
    public void receiveStatusCodeCreateACommentForProduct404() {
        createACommentForProduct.receiveStatusCodeCreateACommentForProduct404();
    }

    @Then("the response contains the created comment data")
    public void verifyResponseContainsCreatedCommentData() {
        createACommentForProduct.verifyResponseContainsCreatedCommentData();
    }

}
