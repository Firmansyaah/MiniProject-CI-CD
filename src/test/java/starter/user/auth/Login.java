package starter.user.auth;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.equalTo;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Login {

    private static String correctUrl = "https://altashop-api.fly.dev/api/auth/login";
    private static String wrongUrl = "https://altashop-api.fly.dev/api/auth/login/invalid";

    @Step("I set API endpoint for user login")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set the wrong API endpoint for user login")
    public String setWrongApiEndpointForUserLogin() {
        return wrongUrl;
    }

    @Step("I send a POST request to login with valid data")
    public void sendLoginRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Firmanghny59@gmail.com");
        requestBody.put("password", "123123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }
    @Step("I send a POST request to login with valid data invalid endpoint")
    public void sendLoginRequestWithValidDataInvalidEndpoint() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "Firmanghny59@gmail.com");
        requestBody.put("password", "123123");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setWrongApiEndpointForUserLogin());
    }
    @Step("I receive status code login 200")
    public void receiveStatusCodeLogin200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive a token in the response")
    public void receiveTokenInResponse() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.LOGIN);

        restAssuredThat(response -> response.body("data", Matchers.notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code login 404")
    public void receiveStatusCodeLogin404() {
        restAssuredThat(response -> response.statusCode(404));
    }


}
