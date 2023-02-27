package com.ict18821.pages;

import com.ict18821.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TasksPage extends TestBase {
    @FindBy(xpath = "//div[contains(text(),'All Customers')]")
    WebElement customersTitle;

    public TasksPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateAllcustomersTitle() {
        return customersTitle.isDisplayed();
    }
}
