package com.refi.stepdefinitions;

import com.refi.base.BaseTest;
import com.refi.pages.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginSteps extends BaseTest {

    protected LoginPage loginPage = new LoginPage();

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        // Browser sudah dibuka di Hooks.java @Before
    }

    @When("I enter a valid username {string}")
    public void iEnterAValidUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("I click the login button")
    public void iClickTheLoginButton() {
        loginPage.clickButtonLogin();
    }

    @Then("I should be redirected to the dashboard")
    public void iShouldBeRedirectedToTheDashboard() {
        String currentUrl = loginPage.getCurrentUrl();

        System.out.println("currentUrl: " + currentUrl);

        Assert.assertTrue("Expected Dashboard URL, but got: " + currentUrl, currentUrl.contains("/dashboard"));
    }

    @Then("I should see an error message {string}")
    public void iShouldSeeAnErrorMessage(String expectedErrorMessage) {
        String actualMessage;

        if (expectedErrorMessage.equals("Required")) {
            if (loginPage.isPasswordRequiredMessageDisplayed()) {
                actualMessage = loginPage.getRequiredPasswordMessage();
            } else {
                actualMessage = loginPage.getRequiredUsernameMessage();
            }
        } else {
            actualMessage = loginPage.getErrorMessage();
        }
        Assert.assertEquals(expectedErrorMessage, actualMessage);
    }

    @And("I enter a valid password {string}")
    public void iEnterAValidPassword(String password) {
        loginPage.enterPassword(password);
    }

    @When("I enter username {string}")
    public void iEnterUsername(String username) {
        loginPage.enterUsername(username);
    }

    @And("I enter password {string}")
    public void iEnterPassword(String password) {
        loginPage.enterPassword(password);
    }
}
