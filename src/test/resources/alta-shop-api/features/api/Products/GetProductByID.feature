Feature: Get Product By ID
  As a user
  I want to retrieve product information by its ID
  So that I can view details of a specific product

  Scenario: As an admin, I can get product by ID
    Given I set product API endpoint for get product by ID
    When I send GET request to get product by ID
    Then I receive a response product by ID 200
    And I receive detail product with ID

  Scenario: As an admin, I can get product by ID with invalid endpoint
    Given I set invalid product API endpoint
    When I send GET request to get product by ID with invalid endpoint
    Then I receive a response product by ID 404
