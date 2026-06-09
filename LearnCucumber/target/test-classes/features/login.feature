
Feature: BookCart application demo

  Background: 
    Given User should navigate to the application
    And User clicks on the login link

  Scenario: Login should be success
    And User enter the username as Ortoni
    And User enter the password as Pass1234
    When User click the login button
    Then login should be success

  Scenario: Login should be fail
    And User enter the username as Dhanakodi
    And User enter the password as Dhana@1997
    When User click the login button
    But login should be fail
