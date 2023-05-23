Feature: Shopping Basket
  Scenario: Adding an item
    Given I have an empty basket
    When I add a 'banana' to my basket
    Then my basket contains a 'banana'

  Scenario: Adding a carrot
    Given I have an empty basket
    When I add a 'banana' to my basket
    Then my basket contains a 'banana'

  Scenario: Adding 3 carrots
    Given I have an empty basket
    When I add 3 'carrot's to my basket
    Then my basket contains 3 'carrot's