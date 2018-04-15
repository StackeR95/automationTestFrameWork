Feature: Going through all booking stages
  description: as a user I should be able to book an hotel

  Background:  user is in hotels page
    Given user is in "hotels page"

  Scenario Outline: typical booking scenario
    When user selects an hotel
    And  user enters an available reservation period of <reservationPeriod> days
    And  user presses the modify button
    And  user enters the number of rooms to be <roomsCount>
    And  user presses the book now button
    And  user enters his/her personal details
    And  user presses the confirm booking button
    Then the correct invoice is ready
    Examples:
      | reservationPeriod | roomsCount |
      |        3          |    1       |
