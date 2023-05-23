Feature: Shopping Basket
  Scenario: Adding an item
    Given I have an empty basket
    When I add a banana to my basket
    Then my basket contains a banana