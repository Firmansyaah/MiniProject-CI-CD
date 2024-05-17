package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.products.CreateANewProduct;

public class CreateANewProductSteps {

    @Steps
    CreateANewProduct createANewProduct;

    @Given("I set API endpoint for creating a new product")
    public void setApiEndpointForCreatingNewProduct() {
        createANewProduct.setApiEndpointForCreatingNewProduct();
    }

    @Given("I set the wrong API endpoint for creating a new product")
    public void setWrongApiEndpointForProductCreation() {
        createANewProduct.setWrongApiEndpointForProductCreation();
    }

    @When("I send a POST request to create a new product with valid data")
    public void sendCreateProductRequestWithValidData() {
        createANewProduct.sendCreateProductRequestWithValidData();
    }

    @When("I send a POST request to create a new product with invalid endpoint")
    public void sendCreateProductRequestWithInvalidEndpoint() {
        createANewProduct.sendCreateProductRequestWithInvalidEndpoint();
    }

    @Then("I receive status code Created 200")
    public void receiveStatusCodeCreated200() {
        createANewProduct.receiveStatusCodeCreated200();
    }

    @Then("I receive valid product data in the response")
    public void receiveValidProductData() {
        createANewProduct.receiveValidProductData();
    }

    @Then("I receive status code created 405")
    public void receiveStatusCodeCreated405() {
        createANewProduct.receiveStatusCodeCreated405();
    }
}
