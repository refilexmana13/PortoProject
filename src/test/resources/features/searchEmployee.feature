Feature: Search Employee can show employee data

    @smoke @searchEmployee @requestLogin
  Scenario: Search Employee by an existing name
    Given I am on the Employee List page
    And I click on the Search button
    Then I should see employee data is displayed in the search results