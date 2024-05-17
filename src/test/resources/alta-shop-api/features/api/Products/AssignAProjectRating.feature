Feature: Assign a Product Rating
  As a admin
  I want to assign a rating to a product
  So that I can provide feedback and improve product recommendations

  Scenario: Successful assignment of product rating
    Given I set the API endpoint for assigning product rating
    When I send a POST request to assign a rating of 4 to product
    Then I receive status code assign product rating 200

  Scenario: Attempt to assign product rating with invalid endpoint
    Given I set an invalid API endpoint for assigning product rating
    When I send a POST request to assign a rating of 4 to product with invalid endpoint
    Then I receive status code assign product rating 404
