Feature: Create a New Product
  As a admin
  I want to to create a new product
  So that I can add it to the platform

  Scenario: Create a new product with valid data
    Given I set API endpoint for creating a new product
    When I send a POST request to create a new product with valid data
    Then I receive status code Created 200
    And I receive valid product data in the response

  Scenario: Create a new product with wrong API endpoint
    Given I set the wrong API endpoint for creating a new product
    When I send a POST request to create a new product with invalid endpoint
    Then I receive status code created 405
