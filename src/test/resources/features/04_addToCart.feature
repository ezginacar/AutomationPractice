Feature: Cart controls for adding product scenarios



  Background: Login with valid user informations
    Given Navigate to the homepage
   # And Click on the Sign in button
   # And Login with valid user account informations
  #  And Remove the cart if it is not empty

  Scenario: F004_TC001 - Add at least 1 product to cart
    Given Click on the T-SHIRTS category title from the top menu
    When Click on the Add to cart button for the "1". ranked product
    And Close the popup
    Then Should see product quantity as Cart 1 on the order button






