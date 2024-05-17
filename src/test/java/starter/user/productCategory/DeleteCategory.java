package starter.user.productCategory;


import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.serenitybdd.annotations.Step;

public class DeleteCategory {
    private static final String VALID_URL = "https://altashop-api.fly.dev/api/categories/";
    private static final String INVALID_URL = "https://altashop-api.fly.dev/api/categories/invalid";

    @Step("I set the API endpoint for deleting a category")
    public String setApiEndpointForDeletingCategory() {
        return VALID_URL + "1";
    }

    @Step("I set an invalid API endpoint for deleting a category")
    public String setInvalidApiEndpointForDeletingCategory() {
        return INVALID_URL;
    }

    @Step("I send a DELETE request to delete the category")
    public Response sendDeleteRequestToDeleteCategory() {
        return SerenityRest.given()
                .delete(setApiEndpointForDeletingCategory());
    }

    @Step("I send a DELETE request to delete a category with invalid endpoint")
    public Response sendDeleteRequestToDeleteCategoryWithInvalidEndpoint() {
        return SerenityRest.given()
                .delete(setInvalidApiEndpointForDeletingCategory());
    }

    @Step("I receive a status code 200 indicating successful deletion")
    public void receiveStatusCodeForSuccessfulDeletion200() {
        SerenityRest.then().statusCode(200);
    }

    @Step("I receive a status code 400 indicating category delete not found")
    public void receiveStatusCodeForCategoryDeleteNotFound400() {
        SerenityRest.then().statusCode(400);
    }


}
