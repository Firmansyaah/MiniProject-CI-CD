package starter.stepdefinitions.Products;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;
import starter.user.products.GetAllProducts;

public class GetAllProductsSteps {
        @Steps
        GetAllProducts getAllProducts;

        @Given("I set API endpoint for get all products")
        public void setApiEndpointForGetAllProduct() { getAllProducts.setApiEndpointForGetAllProduct(); }

        @Given("I set API invalid endpoint for get all products")
        public void setApiInvalidEndpointForGetAllProduct() { getAllProducts.setApiInvalidEndpointForGetAllProduct(); }

        @When("I send a request to get all products")
        public void sendGetAllProductsRequest() { getAllProducts.sendGetAllProductsRequest(); }

        @When("I send a request to get all products with invalid endpoint")
        public void sendGetAllProductsRequestInvalidEndpoint() { getAllProducts.sendGetAllProductsRequestInvalidEndpoint(); }

        @Then("I receive status code product 200")
        public void receiveStatusCodeProduct200() {
            getAllProducts.receiveStatusCodeProduct200();
        }

        @And("I receive valid data for all products")
        public void receiveValidAllProducts() {
            getAllProducts.receiveValidAllProducts();
        }

        @Then("I receive status code product 404")
        public void receiveStatusCodeProduct404() { getAllProducts.receiveStatusCodeProduct404();}

}
