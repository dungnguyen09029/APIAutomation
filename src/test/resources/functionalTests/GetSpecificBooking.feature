@API
Feature: Get Specific Booking Information

  Scenario: Get Booking with correct Id
    When User get a list of booking
      And User save the booking Id at 1
      And User sent data to get specific booking information
    Then Verify specific book information is returned correctly

  Scenario: Get Booking with wrong Id
    When User get specific booking information with id "abcxyz"
    Then The response status code should be 404
      And The response body should contain text "Not Found"

