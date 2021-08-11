Feature: My Account
  As a customer
  I want to buy some books
  So that I need to see my account

  Scenario: My Accounts-Dashboard
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    Then User must view Dashboard of the site

  Scenario: My Accounts-Orders 1
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    And  Click on Orders link
    Then User must view their orders on clicking orders link

  Scenario: My Accounts-Orders 2
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    And Click on Orders link
    And Click view button
    Then User must view his Order details,customer details and billing details

  Scenario: My Accounts-Orders 3
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    And Click on Orders link
    And Click view button
    Then User must view Order Number Ordered date and Status of the order


  Scenario: My Accounts-Address Functionality 1
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    And Click on Address link
    Then User must view billing address and ship address

  Scenario: My Accounts-Address Functionality 2
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    And Click on Address link
    And Click Edit on Shipping Address
    Then User can Edit Shipping address

  Scenario:  My Accounts-Account Details
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    And Click on Account details
    Then User can view account details where he can change his pasword also


  Scenario:  My Accounts-Account Details
    Given Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    Then User must successfully login to the web page
    And Click on logout button
    Then User successfully comes out from the site
