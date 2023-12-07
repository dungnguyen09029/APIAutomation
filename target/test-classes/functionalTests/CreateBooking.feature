@API
Feature: Create a Booking

  Scenario: Create a Booking
    When User create a new booking
    Then The response status code should be 200
      And Checking the response create booking is correct

