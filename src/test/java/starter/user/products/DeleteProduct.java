package starter.user.products;

import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;

public class DeleteProduct {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/products/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/products/invalid/";

    @Step("I set API endpoint for deleting product")
    public void setApiEndpointForDeletingProduct() {
    }

    @Step("I set invalid API endpoint for deleting product")
    public void setInvalidApiEndpointForDeletingProduct() {
    }

    @Step("I send a DELETE request to delete product with ID")
    public void sendDeleteRequestToDeleteProduct() {
        SerenityRest.delete(VALID_URL + 1);
    }
    @Step("I send a DELETE request to delete product with ID {int}")
    public void sendDeleteRequestToDeleteProductWithInvalidEndpoint() {
        SerenityRest.delete(INVALID_URL + 1);
    }

    @Step("I receive status code delete 200")
    public void receiveStatusCodeDelete200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive status code delete 404")
    public void receiveStatusCodeDelete404() {
        SerenityRest.then().statusCode(404);
    }
}
