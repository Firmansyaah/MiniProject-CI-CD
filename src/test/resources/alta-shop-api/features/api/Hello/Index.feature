Feature: Index Retrieval
  As a user
  I want to be able to retrieve index information
  So that I can view basic information about the application

Scenario: Retrieve index successfully
Given I set the API endpoint for retrieving the index
When I send a GET request to retrieve the index
Then I receive status code 200 indicating
And I receive valid index information in the response

  Scenario: Retrieve index with incorrect endpoint
    Given I set an invalid API endpoint for retrieving the index
    When I send a GET request to retrieve the index invalid endpoint
    Then I receive status code 404 indicating