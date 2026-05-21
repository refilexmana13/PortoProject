Feature: Add Employee


  Background:
    Given I am logged in as an Admin
    And I click PIM

  @smoke @addEmployee
  Scenario: Add employee with valid data
    Given I am on the Add Employee page
    And I click add
    When I enter first name "John"
    And I enter middle name "A."
    And I enter last name "Doe"
    And I click on the Save button
    Then I should see a success message "Successfully Saved"
