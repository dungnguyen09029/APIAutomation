@API
Feature: Create a Booking

  Scenario: User sent create booking request
    When User create a new booking
    Then The response status code should be 204
      And Verify book information is returned in response
      And Verify returned booking id is a number
      And User assert all issue

