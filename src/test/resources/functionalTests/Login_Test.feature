#Author: wloforte@broadinstitute.org

Feature: LOG IN
  I want to use this template for my feature file

  @run
  Scenario: Successful Login as an admin
    Given The user is in the Home Page
    And user navigates to Login Page
    When user enters correct AdminUserName and AdminPassword
    Then user navigates to Admin Console
