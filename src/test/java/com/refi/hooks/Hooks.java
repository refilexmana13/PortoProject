package com.refi.hooks;

import com.refi.base.BaseTest;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks extends  BaseTest {

    @Before
    public void setup() {
        System.out.println("hook is processing, preparing the driver");
        getDriver();
        BaseTest.driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        close();
    }
}
