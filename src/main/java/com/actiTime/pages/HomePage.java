package com.actiTime.pages;

import com.actiTime.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(xpath = "//a[@class='content tasks']")
    WebElement taskLink;
		
    @FindBy(xpath = "//a[@class='content reports']")
    WebElement reportsLink;
		
    @FindBy(xpath = "//a[@class='content users']")
    WebElement usersLink;
		
    @FindBy(xpath = "//div[@id='logo_aT']")
    WebElement actitimeLogo;
		
		
	public HomePage() {
        	PageFactory.initElements(driver, this);
	}
		

	public Boolean validateActiTimeLogoImage() {
		return actitimeLogo.isDisplayed();
	}
		
	public TaskPage ClickOnTaskLink() {
		this.taskLink.click();
		return new TaskPage();
	}
		
	public ReportsPage ClickOnReportsLink() {
		this.reportsLink.click();
		return new ReportsPage();
	}
		
	public UsersPage ClickOnUsersLink() {
		this.usersLink.click();
		return new UsersPage();		}
}
