package starter.user.products;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class AssignAProductRating {

    private static final String VALID_URL = "https://altashop-api.fly.dev/api/products/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/products/invalid/";

    @Step("I set the API endpoint for assigning product rating")
    public String setApiEndpointForAssigningProductRating() {
        return VALID_URL + "88712/ratings";
    }

    @Step("I set an invalid API endpoint for assigning product rating")
    public String setInvalidApiEndpointForAssigningProductRating() {
        return INVALID_URL + "-1/ratings";
    }

    @Step("I send a POST request to assign a rating of 4 to the product")
    public void sendPostRequestToAssignProductRating4() {

        String token = generateToken();

        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 4);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .body(requestBody.toString())
                .post(setApiEndpointForAssigningProductRating());
    }

    @Step("I send a POST request to assign a rating of 4 to the product with an invalid endpoint")
    public void sendPostRequestToAssignProductRating4WithInvalidEndpoint() {
        String token = generateToken();

        JSONObject requestBody = new JSONObject();
        requestBody.put("count", 4);

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .body(requestBody.toString())
                .post(setInvalidApiEndpointForAssigningProductRating());
    }

    private String generateToken() {
        return "your_generated_token";
    }

    @Step("I receive status code assign product rating 200")
    public void receiveStatusCodeAssignProductRating200() {
        restAssuredThat(response -> response.statusCode(200));
    }
    @Step("I receive status code assign product rating 404")
    public void receiveStatusCodeAssignProductRating404() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
