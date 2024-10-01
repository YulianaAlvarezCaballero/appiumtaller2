Feature: Calculator functionality

  Scenario: Perform addition
    Given The calculator app is open
    When I press 2
    And I press plus
    And I press 3
    And I press equals
    Then The result should be 5

  Scenario: Perform subtraction
    Given The calculator app is open
    When I press 9
    And I press minus
    And I press 4
    And I press equals
    Then The result should be 5

  Scenario: Perform multiplication
    Given The calculator app is open
    When I press 7
    And I press multiply
    And I press 6
    And I press equals
    Then The result should be 42

  Scenario: Perform division
    Given The calculator app is open
    When I press 8
    And I press divide
    And I press 2
    And I press equals
    Then The result should be 4
