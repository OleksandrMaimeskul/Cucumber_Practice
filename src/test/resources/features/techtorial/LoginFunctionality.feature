#Feature is a general description of what you are testing (Pizza)
#Feature: Testing Login Functionality
  #Scenario is a testCase of main functionality (slice of pizza)
 # Scenario: Happy Path login functionality
    #Given is a precondition for the test case
   # Given User validate the title is 'techtorial' from Login Page
    #And is a contunues process, it can come after any steps
   # And User validate the log in is visible on the page
    #When is all about actions
   # When User provides username and password to the Sign In Box
    #Then is all about result of actions
    #Then User validates the title is 'Dashboard' from Main Page

Feature: Testing Login Functionality
  Background:
    Given User validate the title is 'techtorial' from Login Page
    And User validate the log in is visible on the page
  Scenario: Happy Path login functionality
    ....
    When User provides username and password to the Sign In Box
    Then User validates the title is 'Dashboard' from Main Page

    Scenario: Negative LogIn