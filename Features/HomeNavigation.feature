Feature: Navigating to main pages
  description: as a user I should be able to navigate to any of the main pages from the home page


  Background: user in home page
    Given user is in "home page"



  Scenario: Go to hotels page
    When user clicks on hotels button
    Then user is redirected to "hotels page"

  Scenario: Go to flights page
    When user clicks on flights button
    Then user is redirected to "flights page"

  Scenario: Go to tours page
    When user clicks on tours button
    Then user is redirected to "tours page"

  Scenario: Go to cars page
    When user clicks on cars button
    Then user is redirected to "cars page"

  Scenario: Go to offers page
    When user clicks on offers button
    Then user is redirected to "offers page"

  Scenario: Go to visa page
    When user clicks on visa button
    Then user is redirected to "visa page"

  Scenario: Go to blog page
    When user clicks on blog button
    Then user is redirected to "blog page"
