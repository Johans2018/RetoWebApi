@API
@Negative
Feature: Negative Booking Scenarios

  Scenario: Retrieve non existing booking
    Given booking id 999999999
    When Jonathan retrieves the booking
    Then the response code should be 404

  Scenario: Update booking without authentication
    Given Jonathan has a booking
    When he updates the booking without authentication
    Then the response code should be 403

  Scenario: Delete booking without authentication
    Given Jonathan has a booking
    When he deletes the booking without authentication
    Then the response code should be 403