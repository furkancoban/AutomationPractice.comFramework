#Author: FurkanCoban
@Login
Feature: Login to AutomationPractice

  Scenario: Login to AutomationPractice.com with invalid credentials
  
    Given User navigates to the login page
    When User signs in with invalid credentials
    Then Verify that the user receives an error message

  Scenario: Create new account and login to AutomationPractice.com
  
    Given User navigates to the login page
    And User creates a new account, providing the minimum required information
    When User signs out
    Then User signs in with the newly created account
    And Verify that user signed in successfully.
  