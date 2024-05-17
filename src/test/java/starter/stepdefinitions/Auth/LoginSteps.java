package starter.stepdefinitions.Auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

import io.cucumber.java.en.When;
import starter.user.auth.Login;

public class LoginSteps {

    private Login login = new Login();

    @Given("I set API endpoint for user login")
    public void setApiEndpointForUserLogin() {
        login.setApiEndpoint();
    }

    @Given("I set the wrong API endpoint for user login")
    public void setWrongApiEndpointForUserLogin() {
        login.setWrongApiEndpointForUserLogin();
    }

    @When("I send a POST request to login with valid data")
    public void sendLoginRequestWithValidData() {
        login.sendLoginRequestWithValidData();
    }

    @When("I send a POST request to login with invalid endpoint")
    public void sendLoginRequestWithValidDataInvalidEndpoint() {
        login.sendLoginRequestWithValidDataInvalidEndpoint();
    }

    @Then("I receive status code login 200")
    public void receiveStatusCodeLogin200() {
        login.receiveStatusCodeLogin200();
    }

    @And("I receive a token in the response")
    public void receiveTokenInResponse() {
        login.receiveTokenInResponse();
    }

    @Then("I receive status code login 404")
    public void receiveStatusCodeLogin404() {
        login.receiveStatusCodeLogin404();
    }
}
