@API
Feature: Create a Booking

  Scenario: User sent create booking request
    When User create a new booking
    Then The response status code should be 200
      And Verify book information is returned in response
      And Verify returned booking id is a number
      And User assert all issue

  Scenario: User sent create booking request with wrong data type
    When User create a new booking with "firstname" is 111
    Then The response status code should be 500
      And The response body should contain text "Internal Server Error"

  Scenario: User sent create booking request with wrong data type
    When User create a new booking with "lastname" is 111
    Then The response status code should be 500
    And The response body should contain text "Internal Server Error"

#    Case invalid but the api does not handle it
  Scenario: User sent create booking request with wrong data type
    When User create a new booking with "totalprice" is "Jim"
    Then The response status code should be 500
    And The response body should contain text "Internal Server Error"

#    Case invalid but the api does not handle it
  Scenario: User sent create booking request with wrong data type
    When User create a new booking with "additionalneeds" is 111
    Then The response status code should be 500
    And The response body should contain text "Internal Server Error"

