@API
Feature: Delete a Booking

  Scenario: Delete a booking
    When User create a new booking
      And User save created booking Id
    Then The response status code should be 200
    When User sent authentication and receive token
    Then The response status code should be 200
    When User sent delete booking request for previous created booking
    Then The response status code should be 201
    When User sent data to get specific booking information
    Then The response status code should be 404
      And The response body should contain text "Not Found"