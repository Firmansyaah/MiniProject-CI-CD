package starter.user.productCategory;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
public class GetCategoryByID {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/categories/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/categories/32264/inv"; // Assuming 999 is an invalid category ID

    @Step("I set the API endpoint for retrieving a category by ID")
    public String setApiEndpointForRetrievingCategoryByID() {
        return VALID_URL + "32264";
    }

    @Step("I set an invalid API endpoint for retrieving a category by ID")
    public String setInvalidApiEndpointForRetrievingCategoryByID() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve the category by ID")
    public Response sendGetRequestToRetrieveCategoryByID() {
        return SerenityRest.given()
                .get(setApiEndpointForRetrievingCategoryByID());
    }

    @Step("I send a GET request to retrieve a category by ID with invalid endpoint")
    public Response sendGetRequestToRetrieveCategoryWithInvalidID() {
        return SerenityRest.given()
                .get(setInvalidApiEndpointForRetrievingCategoryByID());
    }

    @Step("I receive a status code 200 indicating successful retrieval")
    public void receiveStatusCodeForSuccessfulRetrieval200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive a status code 404 indicating category not found")
    public void receiveStatusCodeForCategoryNotFound404() {
        SerenityRest.then().statusCode(404);
    }

    @Step("I receive the category data for the specified ID")
    public void receiveCategoryDataForSpecifiedID() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_CATEGORY_BY_ID);
        restAssuredThat(response -> response.body("'data'.'ID'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Name'", notNullValue()));
        restAssuredThat(response -> response.body("'data'.'Description'", notNullValue()));

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
}
