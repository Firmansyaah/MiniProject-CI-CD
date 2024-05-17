package starter.user.products;

import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.Matchers.*;

public class GetProductRatings {

    private static final String VALID_URL = "https://altashop-api.fly.dev/api/products/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/products/invalid";

    public GetProductRatings() {
    }

    @Step("I set the API endpoint for retrieving product ratings")
    public String setApiEndpointForRetrievingProductRatings() {
        return VALID_URL + "1/ratings";
    }

    @Step("I set an invalid API endpoint for retrieving product ratings")
    public String setInvalidApiEndpointForRetrievingProductRatings() {
        return INVALID_URL + "1/ratings";
    }

    @Step("I send a GET request to retrieve product ratings for product")
    public Response sendGetRequestToRetrieveProductRatings() {
        return SerenityRest.given()
                .get(setApiEndpointForRetrievingProductRatings());
    }
    @Step("I send a GET request to retrieve product ratings for product")
    public Response sendGetRequestToRetrieveProductRatingsInvalidEndpoint() {
        return SerenityRest.given()
                .get(setInvalidApiEndpointForRetrievingProductRatings());
    }

    @Step("I receive status code product ratings 200")
    public void receiveStatusCodeProductRatings200() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_PRODUCT_RATINGS);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));    }

    @Step("the response contains product ratings data")
    public void verifyProductRatingsData() {
    }

    @Step("I receive status code 400")
    public void receiveStatusCodeProductRatings400() {
        SerenityRest.then().statusCode(400);
    }

}
