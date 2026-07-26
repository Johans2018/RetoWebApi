@API
@RegressionGet
Feature: Get Booking

  Scenario: Retrieve an existing booking
    Given a booking already exists
    When Jonathan retrieves the booking
    Then the booking information should be returned