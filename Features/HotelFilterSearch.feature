Feature: Searching with filtering data
  description: as a user I should be able to search for hotels with filtered data


  Background: user in Hotels page
    Given user is in "hotels page"



  Scenario Outline:  Select Rating Only
    When user clicks on Rating Circle button Star <stars>
    And  user clicks on search button
    Then Hotels with <stars> Star appear
    Examples:
    | stars |
    |  "1" |
    |  "2" |
