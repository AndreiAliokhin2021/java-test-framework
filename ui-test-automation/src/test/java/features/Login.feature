Feature: Login

  Scenario: Successful login with valid credentials
    Given I am on the login page
    When I enter valid credentials
    Then I should see a success message