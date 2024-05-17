Feature: Get all products
  As a admin
  I want to get all products
  So that I can view list of products

  Scenario: As a user I can get all products
    Given I set API endpoint for get all products
    When I send a request to get all products
    Then I receive status code product 200
    And I receive valid data for all products


  Scenario: As a user, I attempt to retrieve all products but encounter an unexpected error
    Given I set API invalid endpoint for get all products
    When I send a request to get all products with invalid endpoint
    Then I receive status code product 404
