Feature: Login
  Scenario: Login without credentials
    Given the user is on the gmail login page
    When tries to go to the enter password page without entering the email or username
    Then the enter an email or phone number error message should be displayed

  Scenario: Login with invalid username
    Given the user is on the gmail login page
    When the user enters a not existing email or username
    Then the Couldn't find your Google Account error message should be displayed

  Scenario: Login with invalid password
    Given the user is on the gmail login page
    When the user enters a valid username
    And the user enters an invalid password
    Then the Wrong password. Try again. error message should be displayed

  Scenario: Successful login
    Given the user is on the gmail login page
    When the user enters a valid username
    And the user enters an valid password
    Then the user should be on the home page