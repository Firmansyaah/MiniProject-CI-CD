package starter.user.products;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.rest.SerenityRest;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;

public class GetAllProducts {
    private static String url = "https://altashop-api.fly.dev/api/";
    private static String invalidUrl = "https://altashop-api.fly.dev/api/invalid";


    @Step("I set API endpoint for get all products")
    public String setApiEndpointForGetAllProduct() {
        return url + "products";
    }
    @Step("I set API invalid endpoint for get all products")
    public String setApiInvalidEndpointForGetAllProduct() {
        return invalidUrl + "products";
    }

    @Step("I send a request to get all products")
    public void sendGetAllProductsRequest() {
        SerenityRest.given()
                .get(setApiEndpointForGetAllProduct());
    }
    @Step("I send a request to get all products with invalid endpoint")
    public void sendGetAllProductsRequestInvalidEndpoint() {
        SerenityRest.given()
                .get(setApiInvalidEndpointForGetAllProduct());
    }

    @Step("I receive status code product 200")
    public void receiveStatusCodeProduct200() {
        restAssuredThat(response -> response.statusCode(200));
    }

    @Step("I receive valid data for all products")
    public void receiveValidAllProducts() {
        JsonSchemaHelper helper = new JsonSchemaHelper();
        String schema = helper.getResponseSchema(JsonSchema.GET_ALL_PRODUCTS);
        restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
    }

    @Step("I receive status code product 404")
    public void receiveStatusCodeProduct404() {
        restAssuredThat(response -> response.statusCode(404));
    }


}
