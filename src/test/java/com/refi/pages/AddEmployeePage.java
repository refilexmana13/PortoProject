package com.refi.pages;

import com.refi.base.BasePage;
import org.openqa.selenium.By;

public class AddEmployeePage extends BasePage {

    private final By firstNameField = By.name("firstName");
    private final By middleNameField = By.name("middleName");
    private final By lastNameField = By.name("lastName");
    private final By saveButton = By.xpath("//*[@id=\"app\"]/div[1]/div[2]/div[2]/div/div/form/div[2]/button[2]");
    private final By successNotification = By.xpath("//p[text()='Successfully Saved']");



    public void enterFirstName(String firstName){
        type(firstNameField, firstName);
    }

    public void enterMiddleName(String middleName){
        type(middleNameField, middleName);
    }

    public void enterLastName(String lastName){
        type(lastNameField, lastName);
    }

    public void clickSaveButton(){
        click(saveButton);
    }

    public String isEmployeeAddedSuccessfully(){
        return getText(successNotification);
    }
}
