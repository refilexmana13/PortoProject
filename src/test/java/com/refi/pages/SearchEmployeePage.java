package com.refi.pages;

import com.refi.base.BasePage;
import org.openqa.selenium.By;

public class SearchEmployeePage extends BasePage {

    private final By btnSearch = By.xpath("//button[@type='submit']");
    private final By employeeCard = By.xpath("//div[contains(@class, 'orangehrm-container')]");


    public void clickSearchButton() {
        click(btnSearch);
    }

    public int getSearchResultsCount() {
        return countElement(employeeCard);
    }

}
