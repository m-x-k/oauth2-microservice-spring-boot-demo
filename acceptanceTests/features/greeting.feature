Feature: Greeting

  Scenario: Logged in user requests greeting resource
    Given   I am logged in
    And     I call the greeting resource
    Then    I am returned a successful greeting response

  Scenario: User not logged in requests greeting resource
    Given   I am not logged in
    And     I call the greeting resource
    Then    I am returned an unsuccessful response
