package com.refi.hooks;

import com.refi.base.BaseTest;
import com.refi.pages.LoginPage;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends  BaseTest {

    @Before
    public void setup() {
        System.out.println("hook is processing, preparing the driver");
        getDriver();
        BaseTest.driver.get(baseUrl);
    }

    @Before ("@requestLogin")
    public void login(){
        System.out.println("Performing login......");
        LoginPage loginPage = new LoginPage();
        loginPage.enterUsername("Admin");
        loginPage.enterPassword("admin123");
        loginPage.clickButtonLogin();
    }

    @After
    public void tearDown() {
        close();
    }
}
