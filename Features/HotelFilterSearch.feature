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
    |  "3" |
    |  "4" |
    |  "5" |

    Scenario Outline: Select Price Range
      When user drags sliders to specify a price range <min> - <max>
      And  user clicks on search button
      Then hotels with price range <min> - <max> are displayed
      Examples:
        | min | max |
        | 150 | 450 |
        | 450 | 500 |
        | 50  | 150 |
        | 150 | 250 |

    @oneShot
    Scenario: Trying Stuff
      When put code to test here

    @debug
    Scenario Outline: Select by Aminities Filter Only
      When user selects <anemities> from Aminities check boxes
      Then hotels with <anemities> Aminities are displayed
      Examples:
        | anemities |
        | "Business Center,SPA,Airport Transport,Swimming Pool"  |
