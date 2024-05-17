Feature: Create a Category
  As a user
  I want to create a new category
  So that I can classify products effectively

  Scenario: Successfully create a new category
    Given I set the API endpoint for creating a category
    When I send a POST request to create a category with valid data
    Then I receive a status code 200 indicating successful category creation
    And I received data to create a category for the product


   Scenario: Attempt to create a category with invalid endpoint
    Given I set an invalid API endpoint for creating a category
    When I send a POST request to create a category with invalid endpoint
    Then I receive a status code 405 indicating endpoint