@API
@SmokeCrud
Feature: Booking CRUD lifecycle

  Scenario: Complete CRUD flow
    Given Jonathan creates a booking
    When he retrieves the booking
    Then the booking information should be correct
    When he updates the booking
    Then the updated information should be displayed
    When he deletes the booking
    Then the booking should not exist anymore