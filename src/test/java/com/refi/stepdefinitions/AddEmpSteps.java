package com.refi.stepdefinitions;

import com.refi.base.BaseTest;
import com.refi.pages.AddEmployeePage;
import com.refi.pages.DashboardPage;
import com.refi.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AddEmpSteps extends BaseTest {

    protected AddEmployeePage addEmployeePage = new AddEmployeePage();

    @Given("I am on the Add Employee page")
    public void iAmOnTheAddEmployeePage() {
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateTOAddEmployee();

    }

    @When("I enter first name {string}")
    public void iEnterFirstName(String firstName) {
        addEmployeePage.enterFirstName(firstName);

    }

    @And("I enter middle name {string}")
    public void iEnterMiddleName(String middleName) {
        addEmployeePage.enterMiddleName(middleName);

    }

    @And("I enter last name {string}")
    public void iEnterLastName(String lastName) {
        addEmployeePage.enterLastName(lastName);

    }

    @And("I click on the Save button")
    public void iClickOnTheSaveButton() {
        addEmployeePage.clickSaveButton();

    }

    @Then("I should see a success message {string}")
    public void iShouldSeeASuccessMessage(String successMessage) {
        String actualMessage = addEmployeePage.isEmployeeAddedSuccessfully();
        if (!actualMessage.equals(successMessage)) {
            throw new AssertionError("Expected message: " + successMessage + " but got: " + actualMessage);
        }
        Assert.assertEquals(successMessage, actualMessage);
    }

}
