Feature: Mpulse application demo    

  Scenario Outline: Login should be success
  	Given User should navigate to the application login
    And User enter the username as MNW3368
    And User enter the password as Dhana!1234
    When User click the login button
    Then login should be success

  