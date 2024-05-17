package starter.stepdefinitions.orders;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import starter.user.orders.GetAllOrders;

public class GetAllOrdersSteps {
    private GetAllOrders getAllOrders = new GetAllOrders();
    private Response response;

    @Given("I set the API endpoint for retrieving all orders")
    public void setApiEndpointForRetrievingAllOrders() {
        getAllOrders.setApiEndpointForRetrievingAllOrders();
    }

    @Given("I set an invalid API endpoint for retrieving all orders")
    public void setInvalidApiEndpointForRetrievingAllOrders() {
        getAllOrders.setInvalidApiEndpointForRetrievingAllOrders();
    }

    @When("I send a GET request to retrieve all orders")
    public void sendGetRequestToRetrieveAllOrders() { getAllOrders.sendGetRequestToRetrieveAllOrders();
    }

    @When("I send a GET request to retrieve all orders with invalid endpoint")
    public void sendGetRequestToRetrieveAllOrdersWithInvalidEndpoint() { getAllOrders.sendGetRequestToRetrieveAllOrdersWithInvalidEndpoint();
    }


    @Then("I receive data confirming the list of orders")
    public void receiveDataConfirmingListOfOrders() {
        getAllOrders.receiveDataConfirmingListOfOrders();
    }

    @Then("I receive a status code in the 400 range indicating an error")
    public void receiveStatusCodeIn400Range() {
        getAllOrders.receiveStatusCodeIn400Range();
    }
}
