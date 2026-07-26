@API
@SmokeApi
Feature: Create Booking

  Scenario: Create a new booking
    Given Jonathan has valid booking information
    When he creates the booking
    Then the booking should be created successfully