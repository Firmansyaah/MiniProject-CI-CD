package starter.user.orders;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetOrdersByID {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/orders/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/orders/invalid/"; // Assuming 999 is an invalid order ID

    @Step("I set the API endpoint for retrieving an order by ID")
    public String setApiEndpointForRetrievingOrderByID() {
        return VALID_URL + "13823";
    }

    @Step("I set an invalid API endpoint for retrieving an order by ID")
    public String setInvalidApiEndpointForRetrievingOrderByID() {
        return INVALID_URL + "13823";
    }

    @Step("I send a GET request to retrieve the order by ID")
    public Response sendGetRequestToRetrieveOrderByID() {
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setApiEndpointForRetrievingOrderByID());
    }

    @Step("I send a GET request to retrieve an order by ID with an invalid endpoint")
    public Response sendGetRequestToRetrieveOrderByIDWithInvalidEndpoint() {
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setInvalidApiEndpointForRetrievingOrderByID());
    }

    @Step("I receive data confirming the order ID details")
    public void receiveOrderDataForSpecifiedID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ORDERS_BY_ID);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I receive a status code in the 404 range indicating an error")
    public void receiveStatusCodeNotFound404RangeIndicatingError() {
        SerenityRest.then().statusCode(404);
    }
}
