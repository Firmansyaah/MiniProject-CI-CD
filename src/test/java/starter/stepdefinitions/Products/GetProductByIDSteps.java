package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.products.GetProductByID;

public class GetProductByIDSteps {
    GetProductByID getProductByID = new GetProductByID();

    @Given("I set product API endpoint for get product by ID")
    public void setProductApiEndpointForProductByID() {
        getProductByID.setProductApiEndpointForProductByID();
    }

    @Given("I set invalid product API endpoint")
    public void setInvalidProductApiEndpoint() {
        getProductByID.setInvalidProductApiEndpoint();
    }

    @When("I send GET request to get product by ID")
    public void sendGetRequestToGetProductByID() {
        getProductByID.sendGetRequestToGetProductByID();
    }

    @When("I send GET request to get product by ID with invalid endpoint")
    public void sendGetRequestToGetProductByIDWithInvalidEndpoint() {
        getProductByID.sendGetRequestToGetProductByIDInvalidEndpoint();
    }

    @Then("I receive a response product by ID 200")
    public void receiveResponseProductByID200() {
        getProductByID.receiveResponseProductByID200();
    }

    @Then("I receive a response product by ID 404")
    public void receiveResponseProductByID404() {
        getProductByID.receiveResponseProductByID404();
    }

    @Then("I receive detail product with ID")
    public void receiveDetailProductWithID() {
        getProductByID.receiveDetailProductWithID();
    }
}
