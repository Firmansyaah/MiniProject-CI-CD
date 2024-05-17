Feature: Delete a Category
  As a user
  I want to delete a category
  So that I can remove unnecessary categories from the system

  Scenario: Successfully delete a category
    Given I set the API endpoint for deleting a category
    When I send a DELETE request to delete the category
    Then I receive a status code 200 indicating successful deletion

  Scenario: Attempt to delete a category with invalid ID
    Given I set the API endpoint for deleting a category
    When I send a DELETE request to delete a category with invalid endpoint
    Then I receive a status code 400 indicating category delete not found
