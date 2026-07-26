@API
@RegressionDelete
Feature: Delete Booking

  Scenario: Delete booking
    Given Jonathan has a booking
    When he deletes the booking
    Then the booking should no longer exist