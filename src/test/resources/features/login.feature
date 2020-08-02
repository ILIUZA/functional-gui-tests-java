Feature: Login Functionality

  Scenario Outline: Verification of login with valid credentials
    Given I am on the Login page
    When I enter credentials <username> and <password>
    And I press the button to login
    Then I am on Secure page
    And I see the success message contains "You logged into a secure area!"
    Examples:
      |username|password|
      |***|***|


  Scenario Outline: Verification of login with invalid password
    Given I am on the Login page
    When I enter credentials <username> and <password>
    And I press the button to login
    Then I see the error message contains "Your password is invalid!"
    And I am on Login page
    Examples:
      |username|password|
      |123|123|

