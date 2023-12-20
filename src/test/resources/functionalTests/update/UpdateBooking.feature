@API
Feature: Update a Booking

  Scenario: User update a booking
    When User create a new booking
      And The response status code should be 200
      And User save created booking Id
      And User sent authentication and receive token
    When User update booking id that just created
      And The response status code should be 200
    Then Verify booking updated with correct information
