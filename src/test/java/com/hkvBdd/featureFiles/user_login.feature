@userLogin
Feature: user login

  @validLogin
  Scenario: Verify user can login with valid userName and password
    Given the user is on web app login page
    When the user enters a value in the userName input field
    And the user enters a value in the password input field
    And the user clicks the login button
    Then the user should land on the dashboard page

