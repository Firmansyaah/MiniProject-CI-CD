Feature: Create a New Order
  As a user
  I want to create a new order
  So that I can purchase products effectively

  Scenario: Successfully create a new order
    Given I set the API endpoint for creating an order
    When I send a POST request to create an order with valid data
    Then I receive a status code 200 indicating successful retrieval
    And I receive data confirming the order details

  Scenario: Attempt to create an order with invalid endpoint
    Given I set an invalid API endpoint for creating an order
    When I send a POST request to create an order with invalid endpoint
    Then I receive a status code 405 indicating endpoint
