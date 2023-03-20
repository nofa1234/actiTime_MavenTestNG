Feature: Login feature

  Scenario: Sucessfully login with valid credentials
    Given I am on the Loging Page
    When I Enter my credentials and I click on Loging button
    Then I should be able to successfuly loging to system
