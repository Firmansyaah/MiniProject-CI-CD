package starter.user.orders;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class CreateNewOrder {
    private static String VALID_URL = "https://altashop-api.fly.dev/api/orders";
    private static String INVALID_URL = "https://altashop-api.fly.dev/api/orders/invalid";
    private Response response;
    @Step("I set the API endpoint for creating an order")
    public String setApiEndpointForCreatingOrder() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for creating an order")
    public String setInvalidApiEndpointForCreatingOrder() {
        return INVALID_URL;
    }

    @Step("I send a POST request to create an order with valid data")
    public void sendPostRequestToCreateOrderWithValidData() {
        JSONArray productsArray = new JSONArray();
        JSONObject product = new JSONObject();
        product.put("product_id", 2);
        product.put("quantity", 1);
        productsArray.put(product);

         SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .body(productsArray.toString())
                .post(setApiEndpointForCreatingOrder());

            }


    @Step("I send a POST request to create an order with invalid endpoint")
    public Response sendPostRequestToCreateOrderWithInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("product_id", 2);
        requestBody.put("quantity", 1);

        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .body(requestBody)
                .post(setInvalidApiEndpointForCreatingOrder());
    }

    @Step("I receive data confirming the order details")
    public void receiveDataConfirmingOrderDetails() {
       JsonSchemaHelper helper = new JsonSchemaHelper();
       String schema = helper.getResponseSchema(JsonSchema.CREATE_NEW_ORDER);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
