package starter.user.auth;

import io.restassured.response.Response;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchemaHelper;
import starter.utils.JsonSchema;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetUserInformation {
    private static final String VALID_ENDPOINT = "https://altashop-api.fly.dev/api/auth/info";
    private static final String INVALID_ENDPOINT = "https://altashop-api.fly.dev/api/auth/info/invalid";
    private Response response;

    @Step("I set the API endpoint for retrieving user information")
    public String setApiEndpointForRetrievingUserInfo() {
        return VALID_ENDPOINT;
    }

    @Step("I set an invalid API endpoint for retrieving user information")
    public String setInvalidApiEndpointForRetrievingUserInfo() {
        return INVALID_ENDPOINT;
    }

    @Step("I send a GET request to retrieve user information")
    public void sendGetRequestToRetrieveUserInfo() {
        response = SerenityRest.given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setApiEndpointForRetrievingUserInfo());
    }
    @Step("I send a GET request to retrieve user information invalid endpoint")
    public void sendGetRequestToRetrieveUserInfoInvalidEndpoint() {
        response = SerenityRest.given()
                .contentType("application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .get(setInvalidApiEndpointForRetrievingUserInfo());
    }

    @Step("I receive status code 200 indicating successful user information retrieval")
    public void receiveStatusCodeUserInformation200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid user information in the response")
    public void receiveValidUserInfo() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_USER_INFORMATION);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code 404 indicating")
    public void receiveStatusCodeUserInformation404() {
        restAssuredThat(response -> response.statusCode(404));
    }
}
