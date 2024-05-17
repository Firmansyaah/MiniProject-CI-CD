package starter.user.productCategory;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.notNullValue;

public class GetAllCategory {

    private static final String VALID_URL = "https://altashop-api.fly.dev/api/categories";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/categories/invalid";

    @Step("I set the API endpoint for retrieving all categories")
    public String setApiEndpointForRetrievingAllCategories() {
        return VALID_URL;
    }

    @Step("I set an invalid API endpoint for retrieving all categories")
    public String setInvalidApiEndpointForRetrievingAllCategories() {
        return INVALID_URL;
    }

    @Step("I send a GET request to retrieve all categories")
    public Response sendGetRequestToRetrieveAllCategories() {
        return SerenityRest.given()
                .get(setApiEndpointForRetrievingAllCategories());
    }

    @Step("I send a GET request to retrieve all categories with invalid endpoint")
    public Response sendGetRequestToRetrieveAllCategoriesWithInvalidEndpoint() {
        return SerenityRest.given()
                .get(setInvalidApiEndpointForRetrievingAllCategories());
    }

    @Step("I receive the data for all categories")
    public void receiveDataForAllCategories() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_CATEGORIES);

        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }
    @Step("I receive a status code 400 indicating category not found")
    public void receiveStatusCodeForCategoryNotFound400() {
        SerenityRest.then().statusCode(400);
    }
}
