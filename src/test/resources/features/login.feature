Feature: Login

  @smoke @regression
  Scenario: Login with valid username and password
    Given I am on the login page
    When I enter a valid username "Admin"
    And I enter a valid password "admin123"
    And I click the login button
    Then I should be redirected to the dashboard

 # data driven testing

  @regression
  Scenario Outline: Login with various credentials
    Given I am on the login page
    When I enter username "<username>"
    And I enter password "<password>"
    And I click the login button
    Then I should see an error message "<expectedMessage>"

    Examples:
        | username  | password   | expectedMessage                 |
        | Admin     | wrongpassword  | Invalid credentials         |
        | invalid   | admin123   | Invalid credentials             |
        |           | admin123   | Required            |
        | Admin     |            | Required            |