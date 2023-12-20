@API
Feature: Partial Update a Booking

  Scenario: User partial update a booking
    When User create a new booking
      And The response status code should be 200
      And User save created booking Id
    When User sent authentication and receive token
      And The response status code should be 200
    When User want to update those information
      | firstname         | Son    |
      | lastname          | Lee    |
      And The response status code should be 200
    Then User sent data to get specific booking information
      And The response status code should be 200
    Then Verify partial update successfully
