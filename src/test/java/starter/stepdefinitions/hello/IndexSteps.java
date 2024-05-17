package starter.stepdefinitions.hello;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.hello.Index;

public class IndexSteps {
    private Index index = new Index();

    @Given("I set the API endpoint for retrieving the index")
    public void setApiEndpointForRetrievingIndex() {
        index.setApiEndpointForRetrievingIndex();
    }

    @Given("I set an invalid API endpoint for retrieving the index")
    public void setInvalidApiEndpointForRetrievingIndex() {
        index.setInvalidApiEndpointForRetrievingIndex();
    }

    @When("I send a GET request to retrieve the index")
    public void sendGetRequestToRetrieveIndex() {
        index.sendGetRequestToRetrieveIndex();
    }

    @When("I send a GET request to retrieve the index invalid endpoint")
    public void sendGetRequestToRetrieveIndexInvalidEndpoint() {
        index.sendGetRequestToRetrieveIndexInvalidEndpoint();
    }

    @Then("I receive valid index information in the response")
    public void receiveValidIndexInfo() {
        index.receiveValidIndexInfo();
    }
}
