package starter.user.products;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetProductByID {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/products/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/products/";

    @Step("I set product API endpoint for get product by ID")
    public void setProductApiEndpointForProductByID() {

    }

    @Step("I set invalid product API endpoint")
    public void setInvalidProductApiEndpoint() {
    }

    @Step("I send GET request to get product by ID")
    public void sendGetRequestToGetProductByID() {
        String token = generateToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(VALID_URL + "88712");
    }
    @Step("I send GET request to get product by ID with invalid endpoint")
    public void sendGetRequestToGetProductByIDInvalidEndpoint() {
        String token = generateToken();
        SerenityRest.given()
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(INVALID_URL + "88700");
    }
    private String generateToken() {
        return "your_generated_token";
    }

    @Step("I send GET request to get product by ID with invalid endpoint")
    public void sendGetRequestToGetProductByIDWithInvalidEndpoint() {
        SerenityRest.get(INVALID_URL + "88697");
    }

    @Step("I receive a response product by ID 200")
    public void receiveResponseProductByID200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive a response product by ID 404")
    public void receiveResponseProductByID404() {
        SerenityRest.then().statusCode(404);
    }

    @Step("I receive detail product with ID")
    public void receiveDetailProductWithID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_BY_ID);

        restAssuredThat(response -> response.body("'data'.'ID'", equalTo(88712)));
        restAssuredThat(response -> response.body("'data'.'Name'", equalTo("Sony PS5")));
        restAssuredThat(response -> response.body("'data'.'Description'", equalTo("play has no limits")));
        restAssuredThat(response -> response.body("'data'.'Price'", equalTo(299)));
        restAssuredThat(response -> response.body("'data'.'Ratings'", equalTo(4)));
        restAssuredThat(response -> response.body("'data'.'Categories'", empty()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
