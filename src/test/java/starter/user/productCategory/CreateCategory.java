package starter.user.productCategory;

import io.restassured.RestAssured;
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

public class CreateCategory {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/categories";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/categories/invalid";

    @Step("I set the API endpoint for creating a category")
    public String setApiEndpointForCreatingCategory() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for creating a category")
    public String setInvalidApiEndpointForCreatingCategory() {
        return INVALID_URL;
    }

    @Step("I send a POST request to create a category with valid data")
    public Response sendPostRequestToCreateCategoryWithValidData() {
        JSONObject requestBody = new JSONObject();
        requestBody.put("name", "gaming");
        requestBody.put("description", "for gaming purposes");

        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .post(setApiEndpointForCreatingCategory());
    }

    @Step("I send a POST request to create a category with invalid endpoint")
    public Response sendPostRequestToCreateCategoryWithInvalidEndpoint() {
        return SerenityRest.given()
                .header("Content-Type", "application/json")
                .header("Authorization", "Bearer " + "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJGdWxsbmFtZSI6IkZpcm1hbnN5YWgxMzMiLCJFbWFpbCI6IkZpcm1hbmdobnk1OUBnbWFpbC5jb20ifQ.5UZzq2zXGSEBGR0JrflFNWexrqwYWTdP1ZIIgK9rTEM")
                .post(setInvalidApiEndpointForCreatingCategory());
    }


    @Step("I receive a status code 200 indicating successful category creation")
    public void receiveStatusCodeForSuccessfulCategoryCreation200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive a status code 405 indicating endpoint")
    public void receiveStatusCodeForInvalidEndpoint405() {
        SerenityRest.then().statusCode(405);
    }

    @Step("I received data to create a category for the product")
    public void receivDataToCreateCategoryForProduct() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.CREATE_A_CATEGORY);
        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }


}
