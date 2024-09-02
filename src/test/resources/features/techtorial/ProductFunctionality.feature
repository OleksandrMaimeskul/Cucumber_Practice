Feature: Testing product functionality
  Scenario: Happy Path AddProduct Functionality
    Given User provides username and password to the Sign In Box
    And User clicks Products buton on the left side and AddProduct Button from Product Page
    When User provides 'Truck-Mounted Crane' and '15000' to the product details box
    And User selects 'Lifting and Material Handling Equipment', 'Mobile Cranes' and '1' from drop downs
    And User clicks purchase check box and add 'It is a good product' into the description
    Then User validates products details 'Truck-Mounted Crane', '$16,500.00', 'Allowed' from table

    Scenario: Happy Path Product Filter Functionality
      Given User provides username and password to the Sign In Box
      When User clicks Products button
      Given User choose from product category 'Lifting and Material Handling Equipment'
      And User choose from sub product category 'Mobile Cranes'
      And User choose 1st 3dots button and view button
      Then User validates the ProductCategory with title 'Lifting and Material Handling Equipment'
