package com.refi.base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class BaseTest {

    public static WebDriver driver;

    public static String baseUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

    // Method untuk inisialisasi WebDriver
    protected void getDriver(){
        //menggunakan chrome
        ChromeOptions options = new ChromeOptions();

        // setting untuk menonaktifkan pop up dari browser
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-web-security");
        options.addArguments("--allow-running-insecure-content");

        options.addArguments("--disable-features=PasswordLeakDetection,PasswordManager");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        //untuk CI env
        boolean isCI = Boolean.parseBoolean(System.getenv("CI"));

        if(isCI){
            //mode CI
            options.addArguments("--headless");
            options.addArguments("--window-size=1920,1080"); //tambahan
            options.addArguments("--no-sandbox");
            options.addArguments("--disable-dev-shm-usage");
            System.out.println("Running CI mode Headless");
        } else {
            System.out.println("Running Local");
        }

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }

    public void close(){
        if (driver != null) {
            driver.quit();
        }
    }
}
