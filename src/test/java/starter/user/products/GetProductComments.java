package starter.user.products;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetProductComments {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/products/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/products/invalid/";

    @Step("I set the API endpoint for retrieving comments for a product")
    public String setApiEndpointForRetrievingComments() {
        return VALID_URL + "88697/comments";
    }

    @Step("I send a GET request to retrieve comments for the product")
    public Response sendGetRequestToRetrieveComments() {
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setApiEndpointForRetrievingComments());
    }

    @Step("I receive a status code 200 indicating successful retrieval of comments")
    public void receiveSuccessfulRetrievalStatusCode200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive the comments data for the product")
    public void receiveCommentsData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_COMMENTS);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I set an invalid API endpoint for retrieving comments for a product")
    public String setInvalidApiEndpointForRetrievingComments() {
        return INVALID_URL + "88697/comments";
    }

    @Step("I send a GET request with an invalid product")
    public Response sendGetRequestWithInvalidProductIDInvalidEndpoint() {
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setInvalidApiEndpointForRetrievingComments());
    }

    @Step("I receive a status code 404 indicating failure to retrieve comments")
    public void receiveFailureStatusCode404() {
        SerenityRest.then().statusCode(404);
    }
}
