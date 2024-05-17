Feature: Get User Information
  As a admin
  I want to get user information
  SO that I can access user information

  Scenario: Retrieve user information successfully with correct endpoint
    Given I set the API endpoint for retrieving user information
    When I send a GET request to retrieve user information
    Then I receive status code 200 indicating
    And I receive valid user information in the response

  Scenario: Retrieve user information with incorrect endpoint
    Given I set an invalid API endpoint for retrieving user information
    When I send a GET request to retrieve user information invalid endpoint
    Then I receive status code 404 indicating
