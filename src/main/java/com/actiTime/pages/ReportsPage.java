package com.actiTime.pages;

import com.actiTime.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReportsPage extends TestBase {
    @FindBy(xpath = "//tr/td[contains(text(),'Reports Dashboard')]")
    WebElement reportPageDashboardHeading;
    public ReportsPage(){
        PageFactory.initElements(driver,this);
    }
    public boolean validateReportPageDashboardText(){
        return reportPageDashboardHeading.isDisplayed();
    }

}
