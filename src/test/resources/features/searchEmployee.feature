Feature: Search Employee

    @smoke @searchEmployee @requestLogin
  Scenario: Search Employee by an existing name
    Given I am on the Employee List page
    When I enter "Admin" in the search name field
    And I click on the Search button
    Then I should see employee data is displayed in the search results