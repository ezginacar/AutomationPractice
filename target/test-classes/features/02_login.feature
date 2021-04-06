Feature: Login features

  Background: User should be at My Account page with clicking Sign In button
    Given Navigate to the homepage
    And Click on the Sign in button

  Scenario: F002_TC001-Successful login with valid username and password
    When Try to login with given infos below:
      |Email                                  |Password       |
      |ezgi.test@mailinator.com               |123456         |

    Then Should seen account button



