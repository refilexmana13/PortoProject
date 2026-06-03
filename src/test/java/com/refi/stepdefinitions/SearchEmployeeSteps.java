package com.refi.stepdefinitions;

import com.refi.base.BaseTest;
import com.refi.pages.DashboardPage;
import com.refi.pages.SearchEmployeePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SearchEmployeeSteps extends BaseTest {

    protected SearchEmployeePage searchEmployeePage = new SearchEmployeePage();

    @Given("I am on the Employee List page")
    public void iAmOnTheEmployeeListPage() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToSearchEmployee();

    }

    @When("I enter {string} in the search ID field")
    public void iEnterInTheSearchIDField(String inputName) {
        searchEmployeePage.enterSearchName(inputName);
    }

    @And("I click on the Search button")
    public void iClickOnTheSearchButton() {
        searchEmployeePage.clickSearchButton();
    }

    @Then("I should see employee data is displayed in the search results")
    public void iShouldSeeEmployeeDataIsDisplayedInTheSearchResults() {
        searchEmployeePage.getSearchResultsCount();
    }
}
