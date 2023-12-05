@API
Feature: Login Successfully

  Scenario: Login Successfully
    When User get an list of booking
    Then The login response should be 200
