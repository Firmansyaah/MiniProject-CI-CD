package starter.stepdefinitions.productCategory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import starter.user.productCategory.GetAllCategory;

public class GetAllCategorySteps {

    private GetAllCategory getAllCategories;
    private Response response;

    @Given("I set the API endpoint for retrieving all categories")
    public void setApiEndpointForRetrievingAllCategories() {
        getAllCategories = new GetAllCategory();
    }

    @Given("I set an invalid API endpoint for retrieving all categories")
    public void setInvalidApiEndpointForRetrievingAllCategories() {
        getAllCategories = new GetAllCategory();
    }

    @When("I send a GET request to retrieve all categories")
    public void sendGetRequestToRetrieveAllCategories() {
        response = getAllCategories.sendGetRequestToRetrieveAllCategories();
    }

    @When("I send a GET request to retrieve all categories with invalid endpoint")
    public void sendGetRequestToRetrieveAllCategoriesWithInvalidEndpoint() {
        response = getAllCategories.sendGetRequestToRetrieveAllCategoriesWithInvalidEndpoint();
    }

    @Then("I receive the data for all categories")
    public void receiveDataForAllCategories() {
        getAllCategories.receiveDataForAllCategories();
    }
    @Then("I receive a status code 400 indicating category not found")
    public void receiveStatusCodeForCategoryNotFound400() {getAllCategories.receiveStatusCodeForCategoryNotFound400();
    }
}
