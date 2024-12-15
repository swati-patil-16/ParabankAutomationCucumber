Feature: Account Page Feature

  Background:
    Given user is on login page
    Given user has already logged in to application
      | username | password |
      | sjp11    | sjp      |

  @accounts
  Scenario: Accounts page title
    When user gets the title of the "Account" page
    Then "Account" page title should be "ParaBank | Accounts Overview"

  @accounts
  Scenario: Accounts section count
    Then user gets accounts services
      | Open New Account    |
      | Accounts Overview   |
      | Accounts Overview   |
      | Transfer Funds      |
      | Bill Pay            |
      | Find Transactions   |
      | Update Contact Info |
      | Request Loan        |
      | Log Out             |
    And accounts section count should be "8"