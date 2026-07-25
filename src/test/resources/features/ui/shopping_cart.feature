@UI
@Regression
Feature: Shopping Cart

  @ShoppingOneProduct
  Scenario: Add one product to cart
    Given Jonathan is logged in
    When he adds the Backpack product
    Then the cart should contain "1" product

  @ShoppingTwoProduct
  Scenario: Add two different products
    Given Jonathan is logged in
    When he adds two products
    Then the cart badge should display "2"