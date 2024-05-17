package starter.stepdefinitions.productCategory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import starter.user.productCategory.DeleteCategory;
import starter.user.productCategory.GetAllCategory;

public class DeleteCategorySteps {

    private final DeleteCategory deleteCategory = new DeleteCategory();
    private final GetAllCategory getAllCategories = new GetAllCategory();

    private String categoryID;

    @Given("I set the API endpoint for deleting a category")
    public void setApiEndpointForDeletingCategory() {
        deleteCategory.setApiEndpointForDeletingCategory();
    }

    @Given("I set an invalid API endpoint for deleting a category")
    public void setInvalidApiEndpointForDeletingCategory() {
        deleteCategory.setInvalidApiEndpointForDeletingCategory();
    }

    @When("I send a DELETE request to delete the category")
    public void sendDeleteRequestToDeleteCategory() {
        deleteCategory.sendDeleteRequestToDeleteCategory();
    }

    @When("I send a DELETE request to delete a category with invalid endpoint")
    public void sendDeleteRequestToDeleteCategoryWithInvalidEndpoint() {
        deleteCategory.sendDeleteRequestToDeleteCategoryWithInvalidEndpoint();
    }

    @Then("I receive a status code 200 indicating successful deletion")
    public void receiveStatusCodeForSuccessfulDeletion200() {
        deleteCategory.receiveStatusCodeForSuccessfulDeletion200();
    }
    @Then("I receive a status code 400 indicating category delete not found")
    public void receiveStatusCodeForCategoryDeleteNotFound400() {getAllCategories.receiveStatusCodeForCategoryNotFound400();
    }

}
