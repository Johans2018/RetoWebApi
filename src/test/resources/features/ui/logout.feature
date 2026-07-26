@UI
@Smoke
Feature: Logout

  @LogoutSuccessfully
  Scenario: Logout successfully
    Given Jonathan is logged in
    When he logs out
    Then he should return to the login page