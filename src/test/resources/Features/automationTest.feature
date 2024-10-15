Feature: SauceDemo website for Automation Practical Feature

  Scenario: Successfully navigate to Sauce demo website and Verify landing page
    Given I navigate to the SauceDemo website
    Then I should see "Swag Labs" in the title

  Scenario: Successful Login
      Given I navigate to the SauceDemo website
      When I enter "standard_user" as the username
      And I enter "secret_sauce" as the password
      And I click the login button
      Then I should see "Swag Labs" in the title

    Scenario: Unsuccessful Login
      Given I navigate to the SauceDemo website
      When I enter "invalid_user" as the username
      And I enter "wrong_password" as the password
      And I click the login button
      Then I should see "Epic sadface: Username and password do not match any user in this service"

    Scenario: Successful Checkout
      Given I navigate to the SauceDemo website
      When I enter "standard_user" as the username
      And I enter "secret_sauce" as the password
      And I click the login button
      And I add two items to the cart
      And I proceed to checkout
      And I enter "First" as the first name
      And I enter "Last" as the last name
      And I enter "12345" as the postal code
      And I submit the checkout form
      And I Finish Checkout
      Then I should see Thank you for your order on the Page
