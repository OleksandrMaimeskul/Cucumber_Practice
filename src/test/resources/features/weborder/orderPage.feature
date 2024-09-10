Feature: Choose of various products and concerning@smoke

  Scenario Outline: Validation of various products
    Given User use username and password for log in to the website
    And User choose the order from the left side of Main Page
    When User choose '<product>', '<quantity>', and push button calculate
    Then User provide '<customerName>','<Street>','<city>','<state>' and '<zipCode>'
    And User choose '<cardType>', provide '<cardNumber>' and '<expireDate>' and click process button
    Then User validate '<message>'
    And User validate all the information '<customerName>','<product>','<quantity>','<Street>','<city>','<state>','<zipCode>','<cardType>','<cardNumber>','<expireDate>'
    Examples:
      | product     | quantity | customerName | Street           | city    | state | zipCode | cardType         | cardNumber   | expireDate | message                                |
      | MyMoney     | 3        | Oleksandr    | 2611 Buns Branch | Houston | TX    | 60123   | Visa             | 123123123123 | 11/25      | New order has been successfully added. |
      | FamilyAlbum | 6        | John         | 2611 Buns Branch | Houston | TX    | 60123   | MasterCard       | 123123123123 | 11/25      | New order has been successfully added. |
      | ScreenSaver | 4        | Travolta     | 2611 Buns Branch | Houston | TX    | 60123   | American Express | 123123123123 | 11/25      | New order has been successfully added. |

  Scenario: Validation of various products with Data Table
    Given User use username and password for log in to the website
    And User choose the order from the left side of Main Page
    When User choose and push button calculate
      | productName | MyMoney |
      | quantity    | 4       |
    Then User provide the adress information
      | customerName | Oleksandr        |
      | Street       | 2611 Buns Branch |
      | city         | Houston          |
      | state        | TX               |
      | zipCode      | 60123            |
    And User choose
      | cardType   | Visa         |
      | cardNumber | 123123123123 |
      | expireDate | 11/26        |
    Then User validate
      | New order has been successfully added. |