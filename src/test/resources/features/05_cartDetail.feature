Feature: Cart detail controls

  Background: Login with valid user informations
    Given Navigate to the homepage
   # And Click on the Sign in button
   # And Login with valid user account informations
    And Remove the cart if it is not empty

  Scenario: F005_TC001 - Successful calculate the total price for 2 products in the cart
    Given Click on the T-SHIRTS category title from the top menu
    And Click on the Add to cart button for the "1". ranked product
    And Close the popup
    And Click on the SUMMER DRESSES subcategory that is under DRESSES category title
    And Click on the Add to cart button for the "2". ranked product
    And Close the popup
    Then Should see product quantity as Cart 2 on the order button
    When Click on the Cart button

    





