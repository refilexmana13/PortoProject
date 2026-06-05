package com.refi.pages;

import com.refi.base.BasePage;
import com.refi.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.refi.base.BaseTest.driver;

public class LoginPage extends BasePage {

    //Locator
    private final By usernameField = By.name("username");
    private final By passwordField = By.name("password");
    private final By loginButton = By.cssSelector("button[type='submit']");
    private final By errorMessage = By.cssSelector(".oxd-alert-content-text");
    private final By requiredUsernameMessage = By.xpath("//*[@id=\"app\"]/div[1]/div/div[1]/div/div[2]/div[2]/form/div[1]/div/span");
    private final By requiredPasswordMessage = By.xpath("//span[text()='Required']");

    //Method untuk melakukan login
    public void enterUsername(String username){
        type(usernameField, username);
    }

    public void enterPassword(String password){
        type(passwordField, password);
    }

    public void clickButtonLogin(){
        click(loginButton);
        wait.until(ExpectedConditions.urlContains("/dashboard"));
    }

    public String getErrorMessage(){
        return getText(errorMessage);
    }

    public String getCurrentUrl(){
        return driver.getCurrentUrl();
    }

    public String getRequiredUsernameMessage(){
        return getText(requiredUsernameMessage);
    }

    public String getRequiredPasswordMessage(){
        return getText(requiredPasswordMessage);
    }

    public boolean isPasswordRequiredMessageDisplayed(){
        return countElement(requiredPasswordMessage) > 0;
    }
}
