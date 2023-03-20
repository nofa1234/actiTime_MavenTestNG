package com.actiTime.pages;

import com.actiTime.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

  @FindBy(xpath = "//input[@name='username']")
	WebElement username;
	
	@FindBy(xpath = "//input[@type='password'and @name='pwd']")
	WebElement password;
	
	@FindBy(xpath = "//a[@id='loginButton']")
	WebElement loginButton;
	
	@FindBy(xpath = "//input[@name='remember']")
	WebElement keepmeLoggedinCheckBox;
	
	@FindBy(xpath = "//a[@id='toPasswordRecoveryPageLink']")
	WebElement forgotYourPasswordLink;
	
	
	@FindBy(xpath = "//div[@class='atLogoImg']")
	WebElement actiTimeLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Action/Methods
	
	public String validatePageTitle() {
		return driver.getTitle();
	}
	
	public Boolean validateActiTimeLogoImage() {
		return actiTimeLogo.isDisplayed();
	}
	
	public HomePage login(String username,String password) {
		this.username.sendKeys(username);
		this.password.sendKeys(password);
		this.loginButton.click();
		return new HomePage();
	}
	
}
