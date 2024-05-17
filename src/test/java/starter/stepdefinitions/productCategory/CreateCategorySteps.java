package starter.stepdefinitions.productCategory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import starter.user.productCategory.CreateCategory;

public class CreateCategorySteps {
    private CreateCategory createCategory = new CreateCategory();
    private Response response;

    @Given("I set the API endpoint for creating a category")
    public void setApiEndpointForCreatingCategory() {
        createCategory.setApiEndpointForCreatingCategory();
    }

    @Given("I set an invalid API endpoint for creating a category")
    public void setInvalidApiEndpointForCreatingCategory() {
        createCategory.setInvalidApiEndpointForCreatingCategory();
    }

    @When("I send a POST request to create a category with valid data")
    public void sendPostRequestToCreateCategoryWithValidData() {
        response = createCategory.sendPostRequestToCreateCategoryWithValidData();
    }

    @When("I send a POST request to create a category with invalid endpoint")
    public void sendPostRequestToCreateCategoryWithInvalidEndpoint() {
        response = createCategory.sendPostRequestToCreateCategoryWithInvalidEndpoint();
    }

    @Then("I receive a status code 200 indicating successful category creation")
    public void receiveStatusCodeForSuccessfulCategoryCreation200() {
        createCategory.receiveStatusCodeForSuccessfulCategoryCreation200();
    }

    @Then("I receive a status code 405 indicating endpoint")
    public void receiveStatusCodeForInvalidEndpoint405() {
        createCategory.receiveStatusCodeForInvalidEndpoint405();
    }

    @Then("I received data to create a category for the product")
    public void receivDataToCreateCategoryForProduct() {
        createCategory.receivDataToCreateCategoryForProduct();
    }
}
