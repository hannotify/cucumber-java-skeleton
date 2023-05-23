Feature: Shopping Basket
  Scenario Outline: Adding an item
    Given I have an empty basket
    When I add <count> '<product>' to my basket
    Then my basket contains <count> '<product>'s

  Examples:
    | count | product |
    | 1     | banana  |
    | 1     | carrot  |
    | 3     | carrot  |
