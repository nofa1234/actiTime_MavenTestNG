
@tag
Feature: Create New User
  I want to use this template for my feature file

  @tag1
  Scenario: admin should be able create new user
    Given I am on the Actitime Loging Page
    When I Enter admin credentials and I click on Loging button
    And I should be able to successfuly loging to Actitime
    When I Click on the Users section
    Then I should be able to successfuly switch Users Section
    When I Click on the New User button
    Then I should be able to fill the New user Form and click on submit button
    And I should be able to successfuly create new user
    And Close the browser


