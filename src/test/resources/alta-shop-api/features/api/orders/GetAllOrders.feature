Feature: Get All Orders
  As a user
  I want to retrieve all orders
  So that I can view a list of orders

  Scenario: Successfully retrieve all orders
    Given I set the API endpoint for retrieving all orders
    When I send a GET request to retrieve all orders
    Then I receive a status code 200 indicating successful retrieval
    And I receive data confirming the list of orders

  Scenario: Attempt to retrieve all orders with invalid endpoint
    Given I set an invalid API endpoint for retrieving all orders
    When I send a GET request to retrieve all orders with invalid endpoint
    Then I receive a status code in the 400 range indicating an error
