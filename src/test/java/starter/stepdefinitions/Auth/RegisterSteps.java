package starter.stepdefinitions.Auth;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.auth.Register;

public class RegisterSteps {

    Register register = new Register();

    @Given("I set API endpoint for user registration")
    public void setApiEndpointForUserRegistration() {
        register.setApiEndpoint();
    }
    @Given("I set the wrong API endpoint for user registration")
    public void setWrongApiEndpointForUserRegistration() {
        register.setWrongApiEndpointForUserRegistration();
    }

    @When("I send a POST request to register a new user with valid data")
    public void sendPostRequestToRegisterNewUserWithValidData() {
        register.sendRegisterRequestWithValidData();
    }

    @Then("I receive status code register 200")
    public void receiveStatusCodeRegister200() {register.receiveStatusCodeRegister200();
    }

    @Then("I receive valid registration data")
    public void receiveValidRegistrationData() {
        register.receiveValidRegistrationData();
    }

    @Then("I receive status code register 400")
    public void receiveStatusCodeRegister400() {
        register.receiveStatusCodeRegister400(); }
}
