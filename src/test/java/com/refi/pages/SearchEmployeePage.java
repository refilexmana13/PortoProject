package com.refi.pages;

import com.refi.base.BasePage;
import org.openqa.selenium.By;

public class SearchEmployeePage extends BasePage {

    private final By inputSearchName = By.xpath("//input[@placeholder='Type for hints...']");
    private final By btnSearch = By.xpath("//button[@type='submit']");
    private final By resultList = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");

    public void enterSearchName(String name) {
        type(inputSearchName, name);
    }

    public void clickSearchButton() {
        click(btnSearch);
    }

    public int getSearchResultsCount() {
        return countElement(resultList);
    }

}
