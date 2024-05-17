Feature: Delete Product
As a admin
  I want to delete product
  So that I can Deletion of product

  Scenario: Successful deletion of product
    Given I set API endpoint for deleting product
    When I send a DELETE request to delete product with ID
    Then I receive status code delete 200

  Scenario: Attempt to delete product with invalid endpoint
    Given I set invalid API endpoint for deleting product
    When I send a DELETE request to delete product with invalid endpoint
    Then I receive status code delete 404
