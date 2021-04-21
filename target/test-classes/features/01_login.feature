@test
Feature: login features

  Background: User should be at login screen
    Given Navigate to the homepage
    And Click on the Sign in button

  Scenario: F001_TC001 - Successful login with valid user informations
    When Try to login with given infos below:
         |mail                     |password          |
         |ezgi.test@mailinator.com |123456            |
    Then Should seen Sign out button

