Feature: Homepage controls

  Background: User should be at homepage
    Given Navigate to the homepage

  Scenario: F001_TC001-Successful navigate to 'my account' page with clicking Sign in button
    When Click on the Sign in button
    Then Should be at "/index.php?controller=authentication&back=my-account" page

