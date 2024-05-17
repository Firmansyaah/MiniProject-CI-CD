package starter.user.orders;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllOrders {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/orders";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/orders/invalid";

    @Step("I set the API endpoint for retrieving all orders")
    public String setApiEndpointForRetrievingAllOrders() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving all orders")
    public String setInvalidApiEndpointForRetrievingAllOrders() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve all orders")
    public Response sendGetRequestToRetrieveAllOrders() {
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setApiEndpointForRetrievingAllOrders());
    }

    @Step("I send a GET request to retrieve all orders with invalid endpoint")
    public Response sendGetRequestToRetrieveAllOrdersWithInvalidEndpoint() {
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setInvalidApiEndpointForRetrievingAllOrders());
    }

    @Step("I receive data confirming the list of orders")
    public void receiveDataConfirmingListOfOrders() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_ORDERS);
        restAssuredThat(response -> response.statusCode(200));
        restAssuredThat(response -> response.body("'data'", notNullValue()));
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

    @Step("I receive a status code in the 400 range indicating an error")
    public void receiveStatusCodeIn400Range() {
        restAssuredThat(response -> response.statusCode(400));
    }
}
