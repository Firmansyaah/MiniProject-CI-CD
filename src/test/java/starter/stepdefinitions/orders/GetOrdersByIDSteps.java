package starter.stepdefinitions.orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.orders.GetOrdersByID;

public class GetOrdersByIDSteps {
    private GetOrdersByID getOrder = new GetOrdersByID();

    @Given("I set the API endpoint for retrieving an order by ID")
    public void setApiEndpointForRetrievingOrderByID() {
        getOrder.setApiEndpointForRetrievingOrderByID();
    }

    @Given("I set an invalid API endpoint for retrieving an order by ID")
    public void setInvalidApiEndpointForRetrievingOrderByID() {
        getOrder.setInvalidApiEndpointForRetrievingOrderByID();
    }

    @When("I send a GET request to retrieve the order by ID")
    public void sendGetRequestToRetrieveOrderByID() {
        getOrder.sendGetRequestToRetrieveOrderByID();
    }

    @When("I send a GET request to retrieve an order by ID with an invalid endpoint")
    public void sendGetRequestToRetrieveOrderByIDWithInvalidEndpoint() {
        getOrder.sendGetRequestToRetrieveOrderByIDWithInvalidEndpoint();
    }


    @Then("I receive data confirming the order ID details")
    public void receiveOrderDataForSpecifiedID() {
        getOrder.receiveOrderDataForSpecifiedID();
    }
    @Then("I receive a status code in the 404 range indicating an error")
    public void receiveStatusCodeNotFound404RangeIndicatingError(){ getOrder.receiveStatusCodeNotFound404RangeIndicatingError();}
}
