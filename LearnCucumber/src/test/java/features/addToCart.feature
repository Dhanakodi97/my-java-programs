Feature: Bookcart application demo

Background:
	Given User should navigate to the application
	
	
  Scenario Outline: Add a product to the cart
    And User should login as "<username>" and "<password>"
    And User search a "<book>"
    When User add the book to the cart
    Then the cart badge should be updated

    Examples: 
      | username  | password   | book                                    |
      | Sidhu     | Kodi@1997  | Harry Potter and the Chamber of Secrets |
      | Dhanakodi | Dhana@1997 | The Help                                |
