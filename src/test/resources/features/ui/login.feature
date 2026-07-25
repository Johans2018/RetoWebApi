@UI
@Smoke
Feature: Login into SauceDemo

 @LoginTest
 Scenario Outline: Successful login using different users
   Given Jonathan opens SauceDemo
   When he logs in using "<username>" and "<password>"
   Then he should see the products page "<result>"
   Examples:
     | username                | password     | result    |
     | standard_user           | secret_sauce | Swag Labs |
     | problem_user            | secret_sauce | Swag Labs |
     | performance_glitch_user | secret_sauce | Swag Labs |
     | visual_user             | secret_sauce | Swag Labs |

  @Negative1
  Scenario Outline: Locked user cannot log in
    Given Jonathan opens SauceDemo
    When he logs in using "locked_out_user" and "secret_sauce"
    Then he should see the locked user "<message>"
    Examples:
      | message                                             |
      | Epic sadface: Sorry, this user has been locked out. |

  @Negative2
  Scenario Outline: Invalid credentials
    Given Jonathan opens SauceDemo
    When he logs in using "standard_user" and "wrong_password"
    Then he should see the invalid credentials "<message>"
    Examples:
      | message                                                                   |
      | Epic sadface: Username and password do not match any user in this service |
