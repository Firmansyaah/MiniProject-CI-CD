Feature: Get Product Ratings
  As a admin
  I Want to get product ratinfs
  So that I can view list product ratings


  Scenario: Successful retrieval of product ratings
    Given I set the API endpoint for retrieving product ratings
    When I send a GET request to retrieve product ratings for product
    Then I receive status code product ratings 200
    And the response contains product ratings data

  Scenario: Attempt to retrieve product ratings with invalid endpoint
    Given I set an invalid API endpoint for retrieving product ratings
    When I send a GET request to retrieve product ratings for product with invalid endpoint
    Then I receive status code product ratings 400
