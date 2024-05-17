package starter.stepdefinitions.orders;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import starter.user.orders.CreateNewOrder;

public class CreateNewOrderSteps {
    private CreateNewOrder createOrder = new CreateNewOrder();

    @Given("I set the API endpoint for creating an order")
    public void setApiEndpointForCreatingOrder() {
        createOrder.setApiEndpointForCreatingOrder();
    }

    @Given("I set an invalid API endpoint for creating an order")
    public void setInvalidApiEndpointForCreatingOrder() {
        createOrder.setInvalidApiEndpointForCreatingOrder();
    }

    @When("I send a POST request to create an order with valid data")
    public void sendPostRequestToCreateOrderWithValidData() {
        createOrder.sendPostRequestToCreateOrderWithValidData();
    }

    @When("I send a POST request to create an order with invalid endpoint")
    public void sendPostRequestToCreateOrderWithInvalidEndpoint() {
        createOrder.sendPostRequestToCreateOrderWithInvalidEndpoint();
    }

    @Then("I receive data confirming the order details")
    public void receiveDataConfirmingOrderDetails() {
        createOrder.receiveDataConfirmingOrderDetails();
    }
}
