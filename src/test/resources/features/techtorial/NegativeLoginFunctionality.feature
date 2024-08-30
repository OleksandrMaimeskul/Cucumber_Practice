Feature: Negative login functionality
  Scenario: Negative login functionality
  Given User validate 'techtorial' title
  And User validate the log in is visible on the page
  When User entered incorrect email and password
  Then User validate the text 'These credentials do not match our records.'
  And that color of text is red from Sign in Page



