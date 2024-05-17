package starter.user.products;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;
import org.hamcrest.Matchers;
import org.json.JSONArray;
import org.json.JSONObject;
import starter.utils.JsonSchema;
import starter.utils.JsonSchemaHelper;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.*;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;


public class CreateANewProduct {
        private static String correctUrl = "https://altashop-api.fly.dev/api/products";
        private static String wrongUrl = "https://altashop-api.fly.dev/api/products/invalid";

        @Step("I set API endpoint for creating a new product")
        public String setApiEndpointForCreatingNewProduct() {
            return correctUrl;
        }

        @Step("I set the wrong API endpoint for creating a new product")
        public String setWrongApiEndpointForProductCreation() {
            return wrongUrl;
        }

        @Step("I send a POST request to create a new product with valid data")
        public void sendCreateProductRequestWithValidData() {
            JSONObject requestBody = new JSONObject();
            requestBody.put("name", "Sony PS5");
            requestBody.put("description", "play has no limits");
            requestBody.put("price", 299);
            requestBody.put("categories", new JSONArray().put(1));


            SerenityRest.given()
                    .contentType("application/json")
                    .body(requestBody.toString())
                    .post(setApiEndpointForCreatingNewProduct());
        }
    @Step("I Send a POST request to create a new product with invalid endpoint")
    public void sendCreateProductRequestWithInvalidEndpoint() {

        SerenityRest.given()
                .contentType("application/json")
                .post(setWrongApiEndpointForProductCreation());
    }

        @Step("I receive status code Created 200")
        public void receiveStatusCodeCreated200() {
            restAssuredThat(response -> response.statusCode(200));
        }

        @Step("I receive valid product data in the response")
        public void receiveValidProductData() {
            JsonSchemaHelper helper = new JsonSchemaHelper();
            String schema = helper.getResponseSchema(JsonSchema.CREATE_A_NEW_PRODUCT);

            restAssuredThat(response -> response.body("data.ID", Matchers.notNullValue()));
            restAssuredThat(response -> response.body("data.Name", equalTo("Sony PS5")));
            restAssuredThat(response -> response.body("data.Description", equalTo("play has no limits")));
            restAssuredThat(response -> response.body("data.Price", equalTo(299)));
            restAssuredThat(response -> response.body("data.Ratings", equalTo(0)));


            restAssuredThat(response -> response.body(matchesJsonSchema(schema)));
        }

        @Step("I receive status code created 405")
        public void receiveStatusCodeCreated405() {
            restAssuredThat(response -> response.statusCode(405));
        }

}
