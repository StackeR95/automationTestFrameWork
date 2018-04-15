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
    |  1 |
    |  2 |
    |  3 |
    |  4 |
    |  5 |

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

#    @oneShot
#    Scenario: Trying Stuff
#      When put code to test here

    Scenario Outline: All Selected Amenities are presented in hotels page
      When user selects <anemities> from Aminities check boxes
      And  user clicks on search button
      Then all Amenities in <anemities> are displayed in hotels page
      Examples:
        | anemities |
        | "SPA"  |

    Scenario Outline: Select hotels with specific amenities
      When user selects <anemities> from Aminities check boxes
      And  user clicks on search button
      Then hotels with <anemities> Aminities are displayed
      Examples:
        | anemities |
        | "SPA"  |

    @debug
    Scenario Outline: Filter combinations
      When user clicks on Rating Circle button Star <stars>
      And user selects <anemities> from Aminities check boxes
      And user drags sliders to specify a price range <min> - <max>
      And  user clicks on search button
      Then hotels with <anemities> and <stars> and price range <min> - <max> are displayed
      Examples:
        | min | max | anemities               | stars |
        | 150 | 450 |  "SPA"                  |  3    |
        | 450 | 500 | "SPA, Airport Transport"|  5    |
