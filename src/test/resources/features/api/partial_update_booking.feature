@API
@RegressionPartialUpdate
Feature: Partial Update Booking

  Scenario: Update only the first name
    Given Jonathan has a booking
    When he updates only the first name
    Then the booking should contain the new first name