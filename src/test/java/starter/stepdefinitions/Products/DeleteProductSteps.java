package starter.stepdefinitions.Products;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.products.DeleteProduct;

public class DeleteProductSteps {
    DeleteProduct deleteProduct = new DeleteProduct();

    @Given("I set API endpoint for deleting product")
    public void setApiEndpointForDeletingProduct() {
        deleteProduct.setApiEndpointForDeletingProduct();
    }

    @Given("I set invalid API endpoint for deleting product")
    public void setInvalidApiEndpointForDeletingProduct() {
        deleteProduct.setInvalidApiEndpointForDeletingProduct();
    }

    @When("I send a DELETE request to delete product with ID")
    public void sendDeleteRequestToDeleteProduct() {
        deleteProduct.sendDeleteRequestToDeleteProduct();
    }
    @When("I send a DELETE request to delete product with invalid endpoint")
    public void sendDeleteRequestToDeleteProductInvalidEndpoint() {
        deleteProduct.sendDeleteRequestToDeleteProductWithInvalidEndpoint();
    }


    @Then("I receive status code delete 200")
    public void receiveStatusCodeDelete200() {
        deleteProduct.receiveStatusCodeDelete200();
    }

    @Then("I receive status code delete 404")
    public void receiveStatusCodeDelete404() {
        deleteProduct.receiveStatusCodeDelete404();
    }
}
