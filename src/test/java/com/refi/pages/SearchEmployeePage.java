package com.refi.pages;

import com.refi.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SearchEmployeePage extends BasePage {

    private final By pageTitle = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[1]/div[1]/h5");
    private final By inputSearchID = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div[1]/div[2]/form/div[1]/div/div[2]/div/div[2]/input");
    private final By btnSearch = By.xpath("//button[@type='submit']");
    private final By resultList = By.xpath("//div[@class='oxd-table-body']//div[@class='oxd-table-card']");

    public void enterSearchName(String ID) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(pageTitle));
        type(inputSearchID, ID);
    }

    public void clickSearchButton() {
        click(btnSearch);
    }

    public int getSearchResultsCount() {
        return countElement(resultList);
    }

}
