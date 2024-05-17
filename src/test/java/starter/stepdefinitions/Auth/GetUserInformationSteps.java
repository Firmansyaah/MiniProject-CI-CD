package starter.stepdefinitions.Auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.auth.GetUserInformation;

public class GetUserInformationSteps {
    private GetUserInformation getUserInformation = new GetUserInformation();

    @Given("I set the API endpoint for retrieving user information")
    public void setApiEndpointForRetrievingUserInfo() {
        getUserInformation.setApiEndpointForRetrievingUserInfo();
    }

    @Given("I set an invalid API endpoint for retrieving user information")
    public void setInvalidApiEndpointForRetrievingUserInfo() {
        getUserInformation.setInvalidApiEndpointForRetrievingUserInfo();
    }

    @When("I send a GET request to retrieve user information")
    public void sendGetRequestToRetrieveUserInfo() {
        getUserInformation.sendGetRequestToRetrieveUserInfo();
    }

    @When("I send a GET request to retrieve user information invalid endpoint")
    public void sendGetRequestToRetrieveUserInfoInvalidEndpoint() {
        getUserInformation.sendGetRequestToRetrieveUserInfoInvalidEndpoint();
    }

    @Then("I receive status code 200 indicating")
    public void receiveStatusCodeUserInformation200() {
        getUserInformation.receiveStatusCodeUserInformation200();
    }

    @Then("I receive status code 404 indicating")
    public void receiveStatusCodeUserInformation404() {
        getUserInformation.receiveStatusCodeUserInformation404();
    }

    @Then("I receive valid user information in the response")
    public void receiveValidUserInfo() {
        getUserInformation.receiveValidUserInfo();
    }

}
