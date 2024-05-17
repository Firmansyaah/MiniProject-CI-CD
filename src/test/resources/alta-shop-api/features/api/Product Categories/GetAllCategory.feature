Feature: Get all Categories
  As a user
  I want to retrieve all categories
  So that I can view and manage them effectively

  Scenario: Successfully retrieve all categories
    Given I set the API endpoint for retrieving all categories
    When I send a GET request to retrieve all categories
    Then I receive a status code 200 indicating successful retrieval
    And I receive the data for all categories

  Scenario: Attempt to retrieve all categories with invalid endpoint
    Given I set an invalid API endpoint for retrieving all categories
    When I send a GET request to retrieve all categories with invalid endpoint
    Then I receive a status code 400 indicating category not found
