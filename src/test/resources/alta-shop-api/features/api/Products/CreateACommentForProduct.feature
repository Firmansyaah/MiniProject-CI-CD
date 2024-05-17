Feature: Create Comment for Product
  As a user
  I want to create a comment for a product
  So that I can share my opinion or feedback

  Scenario: Successfully create a comment for a product
    Given I set the API endpoint for creating a comment for product
    When I send a POST request to create a comment for product
    Then I receive status code create comment for product 200
    And the response contains the created comment data

  Scenario: Attempt to create a comment for a product with invalid content
    Given I set an invalid API endpoint for creating a comment for product
    When I send a POST request to create a comment for product with invalid endpoint
    Then I receive status code create comment for product 404
