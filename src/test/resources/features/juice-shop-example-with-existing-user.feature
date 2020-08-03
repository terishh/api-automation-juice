
Feature: juice shop example using new user Feature

  Background:
    Given the user logs in using the following data:
      | email    | admin@juice-sh.op |
      | password | admin123          |
    # Find the correct status code
    Then user gets status code "200"

  Scenario: User logs in with default account
    # Find the right XX & YYY JSON Keys
    And the value of path "user --> email" is "admin@juice-sh.op"

  Scenario: User changes password - negative
    When the user changes password using the following data:
      | current | admin123XXX |
      | new     | admin1234   |
      | repeat  | admin1234   |
    # Find the correct status code
    Then user gets status code "401"
