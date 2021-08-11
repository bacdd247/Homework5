Feature: Home Page
  As a customer
  I want to buy some books
  So that I need go to home page


  Scenario:  Home Page with three Sliders only
    Given Open home page
    And Click on Shop Menu
    When Click on Home menu button
    Then Verify the Home page has Three Sliders only


  Scenario: Home page with three Arrivals only
    Given Open home page
    And Click on Shop Menu
    When Click on Home menu button
    Then Verify the Home page has three Arrivals


  Scenario: Home page - Images in Arrivals should navigate
    Given Open home page
    When Click the image in the Arrivals Selenium Ruby
    Then Verify browser navigate to next page and user can add Selenium Ruby book into basket

  Scenario: Home page - Arrivals-Images-Description
    Given Open home page
    And Click the image in the Arrivals Selenium Ruby
    When Click on Description
    Then Verify description regarding that book

  Scenario: Home page - Arrivals-Images-Reviews
    Given Open home page
    And Click the image in the Arrivals Selenium Ruby
    When Click on Reviews tab
    Then Verify Reviews regarding that book

  Scenario: Home page - Arrivals-Images-Add to Basket
    Given Open home page
    And Click the image in the Arrivals Selenium Ruby
    When Click on the Add To Basket button
    Then User can view that Book in the Menu item with price


  Scenario: Home page - Arrivals-Add to Basket with more books
    Given Open home page
    And Click the image in the Arrivals Selenium Ruby
    When Select more books than the books in stock
    And Click on the Add To Basket button
    Then Verify error prompt you must enter right number


  Scenario: Home page - Arrivals-Add to Basket-Items
    Given Open home page
    And Click the image in the Arrivals Selenium Ruby
    When Click on the Add To Basket button
    And Click on Item link
    Then Verify broswer navigates to check out page


  Scenario: Home-Arrivals-Add to Basket-Items-Coupon
    Given Open home page
    And Click the image in the Arrivals Selenium Ruby
    When Click on the Add To Basket button
    And Click on Item link
    And Enter the Coupon code krishnasakinala
    Then Verify the total price is 50 rps off


  Scenario: Home-Arrivals-Add to Basket-Items-Coupon value<450
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click on Item link
    And Enter the Coupon code krishnasakinala
    Then Verify user can not able to apply coupon for the book price > 450 rps


  Scenario: Home-Arrivals-Add to Basket-Items-Remove book
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click on Item link
    And Click on Remove icon
    Then Verify the book Mastering JavaScript is removed from cart


  Scenario: Home-Arrivals-Add to Basket-Items-Add book
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click on Item link
    And Add 2 quantity of books: 2
    And Click on Update Basket
    Then Verrify Basket is updated

  Scenario: Home-Arrivals-Add to Basket-Items-Check-out-Book Final price
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click on Item link
    Then User can find the Total price of the book in the Check out grid


  Scenario: Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click on Item link
    Then The total < subtotal because taxes are added in the subtotal

  Scenario: Home-Arrivals-Add to Basket-Items-Check-out functionality
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click on Item link
    And Click on Proceed to Check out button
    Then Verify browser leads to payment gateway page


  Scenario: Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click view Basket
    And Click on Proceed to Check out button
    Then User can view Billing Details,Order Details,Additional details and Payment gateway details
    And User can fill his details in billing details form, add coupon and can opt any payment in the payment gateway


  Scenario: Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
    Given Open home page
    And Click the image in the Arrivals Mastering JavaScript
    When Click on the Add To Basket button
    And Click on Item link
    And Click on Proceed to Check out button
    And Fill details in billing details form and choose payment type in the payment gateway
    And Click on Place Order button
    Then  Verify Order confirmation page with order details,bank details
