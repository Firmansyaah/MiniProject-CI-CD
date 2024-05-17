package starter.user.auth;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class Register {
    private static String correctUrl = "https://altashop-api.fly.dev/api/auth/register";
    private static String wrongUrl = "https://wrong-url.com/api/auth/register";

    @Step("I set API endpoint for user registration")
    public String setApiEndpoint() {
        return correctUrl;
    }

    @Step("I set the wrong API endpoint for user registration")
    public void setWrongApiEndpointForUserRegistration() {
    }

    @Step("I send a POST request to register a new user with valid data")
    public void sendRegisterRequestWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "kiwwik1234@mail.com");
        requestBody.put("password", "123123");
        requestBody.put("fullname", "Fireman");

        SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post(setApiEndpoint());
    }

    @Step("I receive status code register 200")
    public void receiveStatusCodeRegister200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid registration data")
    public void receiveValidRegistrationData() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.REGISTER);

        restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
        restAssuredThat(response -> response.body("data.Fullname", equalTo("Fireman")));
        restAssuredThat(response -> response.body("data.Email", equalTo("kiwwik1234@mail.com"))); //setiap tes diupdate
        restAssuredThat(response -> response.body("data.Password", equalTo("123123")));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code register 400")
    public void receiveStatusCodeRegister400() {
        restAssuredThat(response -> response.statusCode(400));
    }

    @Step("I receive an error message 'Endpoint Not Found'")
    public void receiveErrorMessageEndpointNotFound() {
        restAssuredThat(response -> response.body("error", equalTo("Endpoint Not Found")));
    }
}
