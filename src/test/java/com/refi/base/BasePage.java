package com.refi.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

    public class BasePage {
        protected WebDriverWait wait;

        public BasePage() {
            this.wait = new WebDriverWait(BaseTest.driver, Duration.ofSeconds(10));
        }

        protected void click(By locator) {
            wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
        }

        protected void type(By locator, String text) {
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.clear();
            element.sendKeys(text);
        }

        protected String getText(By locator) {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).getText();
        }

        protected int countElement(By locator) {
            return BaseTest.driver.findElements(locator).size();
        }

        protected void getItemList(By locator) {
            BaseTest.driver.findElements(locator);
        }
    }

