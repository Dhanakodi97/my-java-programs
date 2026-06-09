Feature: Sauce Demo Application

  Scenario: Login and add a product to cart
    Given User navigates to SauceDemo
    When User logs in with "standard_user" and "secret_sauce"
    And User adds product to cart and goes to cart
    Then User proceeds to checkout
