@API
Feature: Get List of Booking

  Scenario: Get List of Booking
    When User get a list of booking
    Then The response status code should be 200
      And The booking id should be a number

