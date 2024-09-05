Feature:Testing Login Functionality for SauceLab

#  Scenario: Happy Path Login Functionality
#    Given User navigate to the 'https://www.saucedemo.com/'
#    When User provides 'standard_user' and 'secret_sauce' to Sauce Login Page
#    Then User validates the 'Swag Labs' from Sauce Main Page

  Scenario Outline: Happy Path Login Functionality with Scenario Outline
    Given User navigate to the '<url>'
    When User provides '<username>' and '<password>' to Sauce Login Page
    Then User validates the '<title>' from Sauce Main Page
    Examples:
      | url                        | username      | password     | title     |
      | https://www.saucedemo.com/ | standard_user | secret_sauce | Swag Labs |
#      | https://www.saucedemo.com/ | problem_user | secret_sauce | Swag Labs |
#      | https://www.saucedemo.com/ | performance_glitch_user | secret_sauce | Swag Labs |
#      | https://www.saucedemo.com/ | error_user | secret_sauce | Swag Labs |
#      | https://www.saucedemo.com/ | visual_user | secret_sauce | Swag Labs |

