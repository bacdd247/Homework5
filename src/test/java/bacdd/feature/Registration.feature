Feature: Registration
  As a customer
  I want to buy some books
  So that I need to register a new account

  Scenario:  Registration and Signin
    Given Open home page
    And Click on My Account Menu
    When Enter a radom email in register textbox
    And Enter Paralinebacdd in register password textbox
    And Click on register button
    Then User will be registered successfully and will be navigated to the Home page


  Scenario:  Registration with invalid Email-id 1
    Given Open home page
    And Click on My Account Menu
    When Enter bacdd@mail in register username textbox
    And Enter Paralinebacdd in register password textbox
    And Click on register button
    Then Registration must fail with a warning message Error: Please provide a valid email address.


  Scenario:  Registration with empty Email-id 2
    Given Open home page
    And Click on My Account Menu
    When Enter Paralinebacdd in register password textbox
    And Click on register button
    Then Registration must fail with a warning message Error: Please provide a valid email address.


  Scenario:  Registration with empty password
    Given Open home page
    And Click on My Account Menu
    When Enter a radom email in register textbox
    And Click on register button
    Then Registration must fail with a warning message Error: Please enter an account password.

  Scenario:  Registration with empty Email-id and password
    Given Open home page
    And Click on My Account Menu
    When Click on register button
    Then Registration must fail with a warning message Error: Please provide a valid email address.

