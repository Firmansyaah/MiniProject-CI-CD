package starter.user.products;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;

public class CreateACommentForProduct {

    private static final String VALID_URL = "https://altashop-api.fly.dev/api/products/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/products/invalid/";

    public CreateACommentForProduct() {
        // Empty constructor
    }

    private String apiEndpoint;

    @Step("I set the API endpoint for creating a comment for product")
    public String setApiEndpointForCreatingCommentForProduct() {

        return VALID_URL + "88700/comments";
    }

    @Step("I set an invalid API endpoint for creating a comment for product")
    public String setInvalidApiEndpointForCreatingCommentForProduct() {
        return INVALID_URL + "88700/comments";
    }

    @Step("I send a POST request to create a comment for product")
    public Response sendPostRequestToCreateCommentForProduct() {
        String token = generateToken();

        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .body(requestBody.toString())
                .post(setApiEndpointForCreatingCommentForProduct());
    }
    @Step("I send a POST request to create a comment for product with invalid endpoint")
    public Response sendPostRequestToCreateCommentForProductWithInvalidEndpoint() {
        String token = generateToken();

        JSONObject requestBody = new JSONObject();
        requestBody.put("content", "the games are great including Gran Turismo 7 but sadly GT4 is much better");
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .body(requestBody.toString())
                .post(setInvalidApiEndpointForCreatingCommentForProduct());
    }
    private String generateToken() {
        // Implement your token generation logic here
        return "your_generated_token";
    }


    @Step("I receive status code create comment for product 200")
    public void receiveStatusCodeCreateACommentForProduct200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive status code create comment for product 404")
    public void receiveStatusCodeCreateACommentForProduct404() { SerenityRest.then().statusCode(404);
    }

    @Step("the response contains the created comment data")
    public void verifyResponseContainsCreatedCommentData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_A_COMMENT_FOR_PRODUCT);


        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));

    }

}
