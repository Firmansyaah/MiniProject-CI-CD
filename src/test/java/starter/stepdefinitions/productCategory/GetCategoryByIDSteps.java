package starter.stepdefinitions.productCategory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import starter.user.productCategory.GetCategoryByID;

public class GetCategoryByIDSteps {

    private GetCategoryByID getCategoryByID = new GetCategoryByID();
    private Response response;

    @Given("I set the API endpoint for retrieving a category by ID")
    public void setApiEndpointForRetrievingCategoryByID() {
        getCategoryByID.setApiEndpointForRetrievingCategoryByID();
    }

    @Given("I set an invalid API endpoint for retrieving a category by ID")
    public void setInvalidApiEndpointForRetrievingCategoryByID() {
        getCategoryByID.setInvalidApiEndpointForRetrievingCategoryByID();
    }

    @When("I send a GET request to retrieve the category by ID")
    public void sendGetRequestToRetrieveCategoryByID() {
        response = getCategoryByID.sendGetRequestToRetrieveCategoryByID();
    }

    @When("I send a GET request to retrieve a category by ID with invalid endpoint")
    public void sendGetRequestToRetrieveCategoryWithInvalidID() {
        response = getCategoryByID.sendGetRequestToRetrieveCategoryWithInvalidID();
    }

    @Then("I receive a status code 200 indicating successful retrieval")
    public void receiveStatusCodeForSuccessfulRetrieval200() { getCategoryByID.receiveStatusCodeForSuccessfulRetrieval200();
    }

    @Then("I receive a status code 404 indicating category not found")
    public void receiveStatusCodeForCategoryNotFound404() {getCategoryByID.receiveStatusCodeForCategoryNotFound404();
    }

    @Then("I receive the category data for the specified ID")
    public void receiveCategoryDataForSpecifiedID() {
        getCategoryByID.receiveCategoryDataForSpecifiedID();
    }

}
