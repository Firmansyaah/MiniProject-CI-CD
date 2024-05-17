package starter.user.hello;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Index {

    private static final String VALID_ENDPOINT = "https://altashop-api.fly.dev/api/hello";
    private static final String INVALID_ENDPOINT = "https://altashop-api.fly.dev/api/hello/invalid";

    private Response response;

    @Step("I set the API endpoint for retrieving the index")
    public String setApiEndpointForRetrievingIndex() {
        return VALID_ENDPOINT;
    }

    @Step("I set an invalid API endpoint for retrieving the index")
    public String setInvalidApiEndpointForRetrievingIndex() {
        return INVALID_ENDPOINT;
    }

    @Step("I send a GET request to retrieve the index")
    public void sendGetRequestToRetrieveIndex() {
        response = SerenityRest.given()
                .contentType("application/json")
                .get(setApiEndpointForRetrievingIndex());
    }
    @Step("I send a GET request to retrieve the index invalid endpoint")
    public void sendGetRequestToRetrieveIndexInvalidEndpoint() {
        response = SerenityRest.given()
                .contentType("application/json")
                .get(setInvalidApiEndpointForRetrievingIndex());
    }

    @Step("I receive valid index information in the response")
    public void receiveValidIndexInfo() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.INDEX);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
