Feature: Get Category by ID
  As a user
  I want to retrieve a category by its ID
  So that I can view its details

  Scenario: Successfully retrieve a category by ID
    Given I set the API endpoint for retrieving a category by ID
    When I send a GET request to retrieve the category by ID
    Then I receive a status code 200 indicating successful retrieval
    And I receive the category data for the specified ID

  Scenario: Attempt to retrieve a category with invalid ID
    Given I set the API endpoint for retrieving a category by ID
    When I send a GET request to retrieve a category by ID with invalid endpoint
    Then I receive a status code 404 indicating category not found
