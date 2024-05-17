Feature: Login
  As a user
  I want to login to the platform
  So that I can access my account features

  Scenario: Successful Login with Correct Endpoint
    Given I set API endpoint for user login
    When I send a POST request to login with valid data
    Then I receive status code login 200
    And I receive a token in the response

  Scenario: Login Attempt with Incorrect Endpoint
    Given I set the wrong API endpoint for user login
    When I send a POST request to login with invalid endpoint
    Then I receive status code login 404
