Feature: Register
  As a user
  I want to register an account
  So that I can access the platform's features

  Scenario: User successfully registers with valid data
    Given I set API endpoint for user registration
    When I send a POST request to register a new user with valid data
    Then I receive status code register 200
    And I receive valid registration data


  Scenario: User fails to register an account due to incorrect endpoint
    Given I set the wrong API endpoint for user registration
    When I send a POST request to register a new user with valid data
    Then I receive status code register 400

