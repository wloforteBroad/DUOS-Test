#Author: wloforte@broadinstitute.org

Feature: USER LOG OUT
  I want to use this template for my feature file

  Scenario: Successful User Logout
  	Given The user is logged in and in the Admin Console
    When user enters clicks on User DropDown
    And clicks on Logout
    Then Sign in button is diplayed in header
