Feature: Get Order by ID
  As a user
  I want to retrieve an order by its ID
  So that I can view the details of a specific order

  Scenario: Successfully retrieve an order by its ID
    Given I set the API endpoint for retrieving an order by ID
    When I send a GET request to retrieve the order by ID
    Then I receive a status code 200 indicating successful retrieval
    And I receive data confirming the order ID details

  Scenario: Attempt to retrieve an order with invalid ID
    Given I set the API endpoint for retrieving an order by ID
    When I send a GET request to retrieve an order by ID with an invalid endpoint
    Then I receive a status code in the 404 range indicating an error
