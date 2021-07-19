Feature: Login
  As a customer
  I want to buy some books
  So that I need to login


  Scenario: Login with valid username and password
  And Open home page
  And Click on My Account Menu
  When Enter registered bacdd@paraline.com.vn in username textbox
  And Enter Paralinebacdd in password textbox
  And Click on login button
  Then User must successfully login to the web page

  Scenario: Login with incorrect username and incorrect password
    And Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com in username textbox
    And Enter Paraline in password textbox
    And Click on login button
    Then Proper error must be displayed Error: A user could not be found with this email address.

  Scenario: Login with correct username and empty password
    And Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Click on login button
    Then Proper error must be displayed Error: Password is required.

  Scenario: Login with correct username and empty username
    And Open home page
    And Click on My Account Menu
    When Enter Paralinebacdd in password textbox
    And Click on login button
    Then Proper error must be displayed Error: Username is required.

  Scenario: Log-in with empty username and empty username.
    And Open home page
    And Click on My Account Menu
    When Click on login button
    Then Proper error must be displayed Error: Username is required.


  Scenario: Login Password should be masked
    And Open home page
    And Click on My Account Menu
    When Enter Paraline in password textbox
    Then Password should be masked


  Scenario: Login Handles case sensitive
    And Open home page
    And Click on My Account Menu
    When Enter registered BACDD@paraline.com.vn in username textbox
    And Enter ParalineBACDD in password textbox
    And Click on login button
    Then Proper error must be displayed ERROR: The password you entered for the username BACDD@paraline.com.vn is incorrect. Lost your password?


  Scenario: Login Authentication
    And Open home page
    And Click on My Account Menu
    When Enter registered bacdd@paraline.com.vn in username textbox
    And Enter Paralinebacdd in password textbox
    And Click on login button
    And Click on logout button
    And Click on back button
    Then User is not signed in to his account again

