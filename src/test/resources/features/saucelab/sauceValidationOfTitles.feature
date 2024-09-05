Feature: Validation of title, description and prices

  Scenario Outline: Validation of each item
    Given User navigate to the 'https://www.saucedemo.com/'
    When User provides 'standard_user' and 'secret_sauce' to Sauce Login Page
    Then User choose each '<item>' by click-on it
    And User validate of '<title>', containt of '<description>' and '<price>'
    Examples:
      | item                              | title                             | description                    | price  |
      | Sauce Labs Backpack               | Sauce Labs Backpack               | with the sleek                 | $29.99 |
      | Sauce Labs Bike Light             | Sauce Labs Bike Light             | in testing but it sure helps   | $9.99  |
      | Sauce Labs Bolt T-Shirt           | Sauce Labs Bolt T-Shirt           | 100% ringspun                  | $15.99 |
      | Sauce Labs Fleece Jacket          | Sauce Labs Fleece Jacket          | across a midweight quarter-zip | $49.99 |
      | Sauce Labs Onesie                 | Sauce Labs Onesie                 | Reinforced 3-snap bottom       | $7.99  |
      | Test.allTheThings() T-Shirt (Red) | Test.allTheThings() T-Shirt (Red) | Sauce Labs t-shirt is perfect  | $15.99 |

