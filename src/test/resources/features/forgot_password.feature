Feature: Retrieve forgotten password Functionality

  Scenario Outline: Verification of successful retrieving forgotten password
    Given I am on the Forgot Password page
    When I enter email <email>
    And I press the button to retrieve password
    Then I am on the Email_sent page
    And I see the message "Your e-mail's been sent!"
    Examples:
    |email|
    |test.test@tt.com|

  #Scenario: Get string variable from previous scenario
    #Given Print var value in console

  # Scenario: Verification of retrieving invalid password
  # Create when Internal Server Error is fixed
  # Example of invalid pass "123@@"
