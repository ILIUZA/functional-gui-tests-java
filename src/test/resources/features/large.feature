Feature: Selection Rows Functionality

  #Let's highlight selected elements
  Scenario: Verification of selection of rows
    Given I am on the Large page
    When I select the following headers
      |Siblings|
    And I select the following rows
      |1.3     |
      |13.2    |
