@API
@RegressionUpdate
Feature: Update Booking

  Scenario: Update an existing booking
    Given Jonathan has a valid booking
    When he updates the booking
    Then the booking should be updated