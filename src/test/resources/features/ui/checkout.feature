@UI
@Regression
Feature: Checkout

 @Successful
 Scenario Outline: Successful checkout
   Given Jonathan has products in the cart
   When he completes "<firstname>" "<lastname>" "<postal>" the checkout process
   Then he should see the confirmation "<message>"
   Examples:
     | firstname | lastname  | postal | message                   |
     | Jonathan  | Ballestes | 877730 | Thank you for your order! |


  @NegativeCheckout
  Scenario Outline: Checkout without first name
    Given Jonathan has products in the cart
    When he leaves the first name empty "<firstname>" "<lastname>" "<postal>"
    Then he should see the required field "<message>"
    Examples:
      | firstname | lastname  | postal | message                       |
      |           | Ballestes | 877730 | Error: First Name is required |