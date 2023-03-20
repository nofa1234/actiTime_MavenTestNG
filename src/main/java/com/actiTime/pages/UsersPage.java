package com.actiTime.pages;

import com.actiTime.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class UsersPage extends TestBase {

  WebDriverWait wait = new WebDriverWait(driver, 10);
	
	@FindBy(xpath = "//div[@class='components_button withPlusIcon']")
	WebElement NewUserBtn;
	
	@FindBy(xpath = "//div[@class='components_button submitBtn']")
	WebElement SubmitBtn;
	
	@FindBy(xpath = "//input[@id='createUserPanel_firstNameField']")
	WebElement FirstNameField;
	
	@FindBy(xpath = "//input[@id='createUserPanel_lastNameField']")
	WebElement LastNameField;
	
	@FindBy(xpath = "//input[@id='createUserPanel_emailField']")
	WebElement EmailField;
	
	@FindBy(xpath = "//div[@class='invitationInfoHeader']")
	WebElement CreatedMessage;

	
//	actions / method 
	
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	
	public String UsersPageTitle() {
		return driver.getTitle();
	}

	
	public void ClickOnNewUserButton() {
		this.NewUserBtn.click();
	}
	
	public boolean verifyCreatedMessage()
	{
		return wait.until(ExpectedConditions.visibilityOf(CreatedMessage)).isDisplayed();
	}
	
	public boolean FillNewUserForm(String fname,String lname,String email)
	{
		wait.until(ExpectedConditions.elementToBeClickable(FirstNameField)).sendKeys(fname);
		wait.until(ExpectedConditions.elementToBeClickable(LastNameField)).sendKeys(lname);
		wait.until(ExpectedConditions.elementToBeClickable(EmailField)).sendKeys(email);
		wait.until(ExpectedConditions.elementToBeClickable(SubmitBtn)).click();
		return verifyCreatedMessage();
		
	}
}
