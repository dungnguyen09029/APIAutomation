@API
Feature: Create a Booking

  Background:
    When User create a new booking

  Scenario: Verify status code
    Then The response status code should be 200

  Scenario: Verify book information
    Then Verify book information is returned in response

  Scenario: Verify booking id is number
    Then Verify returned booking id is a number

