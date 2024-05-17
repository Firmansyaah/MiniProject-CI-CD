Feature: Get Product Comments
  As a user
  I want to retrieve comments for a product
  So that I can view other users' opinions or feedback

  Scenario: Successfully retrieve comments for a product
    Given I set the API endpoint for retrieving comments for a product
    When I send a GET request to retrieve comments for the product
    Then I receive a status code 200 indicating successful retrieval of comments
    And I receive the comments data for the product

  Scenario: Attempt to retrieve comments for a product with invalid product ID
    Given I set an invalid API endpoint for retrieving comments for a product
    When I send a GET request with an invalid product
    Then I receive a status code 404 indicating failure to retrieve comments
