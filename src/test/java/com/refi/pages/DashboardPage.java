package com.refi.pages;

import com.refi.base.BasePage;
import com.refi.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.refi.base.BaseTest.driver;

public class DashboardPage extends BasePage {

    //locator untuk verifikasi apakah sudah di Halaman Dashboard
    private final By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    //navigasi ke add Employee
    public void navigateTOAddEmployee(){
        driver.get(BaseTest.baseUrl.replace("/auth/login", "/pim/addEmployee"));

    }

    //navigasi ke search Employee
    public void navigateToSearchEmployee(){
        driver.get(BaseTest.baseUrl.replace("/auth/login", "/pim/viewEmployeeList"));
    }

    //cek apakah sudah di halaman Dashboard
    public boolean isOnDasgboard(){
        return countElement(dashboardHeader) > 0;
    }
}
