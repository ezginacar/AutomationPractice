Feature: Product list features

  Background: User should be navigated to the homepage
    Given Navigate to the homepage


  Scenario: F003_TC001-Successful navigate any product category page from the top menu
    When Click on the T-SHIRTS category title from the top menu
    Then Should see "T-SHIRTS" category title

  Scenario: F003_TC002-Successful navigate any sub category page from the top menu
    When Click on the SUMMER DRESSES subcategory that is under "DRESSES" category title
    Then Should see "SUMMER DRESSES" category title

  Scenario: F003_TC003-Successful add a product to card from a specific product category
    When Click on the T-SHIRTS category title from the top menu







