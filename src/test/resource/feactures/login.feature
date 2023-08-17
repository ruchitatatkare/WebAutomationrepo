Feature: Verify the login functionality for open card website
  Background:
    Given :User on opencart login page
  Scenario:Successfully login with valid credential.
    Given  user enter valid Username and Password.
    When user click on login button.
    Then  user should be successful login.
  Scenario Outline: Unsuccessful login with invalid and empty credential.
    Given user enter invalid "<username>" and "<password>".
    When user click on login button.
    Then user should see the <Error Message>.


Examples:
      | username           | password              |Error Message
      | invalid@gmail.com | invalididpassword      |Warning: No match for E-Mail Address and/or Password.
      | abccs              | validpassword         |Warning: No match for E-Mail Address and/or Password.
      | Email Address      | someone@gmail.com     |Warning: No match for E-Mail Address and/or Password.
  Scenario:Navigate to forgot password page.
    When user click on "forgotPassword" link.
    Then user should be redirect to reset password pag.

