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

  Scenario: Removing products should result in an updated basket
    Given I have the following products in my basket
      | product | count |
      | cherry  | 10    |
      | potato  | 25    |
    When I remove from my basket
      | product | count |
      | cherry  | 2     |
    Then my basket contains
      | product | count |
      | cherry  | 8     |
      | potato  | 25    |

  Scenario: Adding a product with an empty name should make no difference to the basket
    Given I have the following products in my basket
      | product | count |
      | cherry  | 10    |
      | potato  | 25    |
    When I add 1 "" to my basket
    Then my basket contains
      | product | count |
      | cherry  | 10    |
      | potato  | 25    |

  Scenario: Adding different kinds of product should result in a correctly updated basket
    Given I have the following products in my basket
      | product | count |
      | cherry  | 10    |
      | potato  | 25    |
    When I add 20 "apple"s to my basket
    And I add 30 "pineapple"s to my basket
    Then my basket contains
      | product   | count |
      | cherry    | 10    |
      | potato    | 25    |
      | apple     | 20    |
      | pineapple | 30    |