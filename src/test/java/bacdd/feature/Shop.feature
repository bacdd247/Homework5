Feature: Shop
  As a customer
  I want to buy some books
  So that I need go to shop

  Scenario:  Shop-Filter By Price Functionality
    Given Open home page
    And Click on Shop Menu
    When Adjust the filter by price between 150 to 450 rps
    And Click on Filter button
    Then User can view books only between 150 to 450 rps price


  Scenario: Shop-Product Categories Functionality
    Given Open home page
    And Click on Shop Menu
    And Click JavaScript in the product category
    Then User can view only that particular product


  Scenario: Shop-Default Sorting Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on Sort by popularity in Default sorting dropdown
    Then User can view the popular products only

  Scenario: Shop-Default Sorting Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on Sort by average rating in Default sorting dropdown
    Then User can view the popular products only


  Scenario: Shop-Default Sorting Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on Sort by newness in Default sorting dropdown
    Then User can view the popular products only

  Scenario: Shop-Default Sorting Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on Sort by price: low to high in Default sorting dropdown
    Then User can view the popular products only


  Scenario: Shop-Default Sorting Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on Sort by price: high to low in Default sorting dropdown
    Then User can view the popular products only


  Scenario: Shop-Sale Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on Sale written product
    Then User can view the actual price with old price striken


  Scenario: Shop-Add to Basket-View Basket Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on the Add To Basket button of Android Quick Start Guide
    And Click on Item link
    And Click on Proceed to Check out button
    And Fill details in billing details form and choose payment type in the payment gateway
    And Click on Place Order button
    Then Verify Order confirmation page with order details,bank details


  Scenario: Shop-Add to Basket-View Basket through Item link
    Given Open home page
    And Click on Shop Menu
    When Click on the Add To Basket button of Android Quick Start Guide
    And Click on View Basket link
    And Click on Proceed to Check out button
    And Fill details in billing details form and choose payment type in the payment gateway
    And Click on Place Order button
    Then Verify Order confirmation page with order details,bank details

  @Test
  Scenario: Shop-Add to Basket-View Basket-Tax Functionality
    Given Open home page
    And Click on Shop Menu
    When Click on the Add To Basket button of Android Quick Start Guide
    And Click on Item link
    Then The total < subtotal because taxes are added in the subtotal
    And The tax rate variers for India compared to other countries