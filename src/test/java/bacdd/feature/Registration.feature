Feature: Registration
  As a customer
  I want to buy some books
  So that I need to register a new account

  @Test
  Scenario:  Registration and Signin
    And Open home page
    And Click on My Account Menu
    When Enter a radom email in register textbox
    And Enter Paralinebacdd in register password textbox
    And Click on register button
    Then User will be registered successfully and will be navigated to the Home page


  Scenario:  Registration with invalid Email-id
    And Open home page
    And Click on My Account Menu
    When Enter bacdd@mail in register username textbox
    And Enter Paralinebacdd in register password textbox
    And Click on register button
    Then Registration must fail with a warning message Error: Please provide a valid email address.


  Scenario:  Registration with empty Email-id
    And Open home page
    And Click on My Account Menu
    When Enter Paralinebacdd in register password textbox
    And Click on register button
    Then Registration must fail with a warning message Error: Please provide a valid email address.


  Scenario:  Registration with empty password
    And Open home page
    And Click on My Account Menu
    When Enter a radom email in register textbox
    And Click on register button
    Then Registration must fail with a warning message Error: Please enter an account password.

  Scenario:  Registration with empty Email-id and password
    And Open home page
    And Click on My Account Menu
    When Click on register button
    Then Registration must fail with a warning message Error: Please provide a valid email address.
