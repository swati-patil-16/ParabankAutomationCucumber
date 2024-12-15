Feature: Login page feature
  Background:
    Given user is on login page

  @Login
  Scenario: Login page title

    When user gets the title of the "login" page
    Then "login" page title should be "ParaBank | Welcome | Online Banking"

  @Login
  Scenario: Forgot Password link
    Given user is on login page
    Then forgot your password link should be displayed

   @skip
  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "sjp1"
    And user enters password "sjp"
    And user clicks on Login button
    Then user gets the title of the "Account" page
    And "Account" page title should be "ParaBank | Accounts Overview"