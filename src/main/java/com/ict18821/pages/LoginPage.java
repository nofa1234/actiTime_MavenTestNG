package com.ict18821.pages;

import com.ict18821.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {

    @FindBy(name = "username")
    WebElement username;
    @FindBy(name = "pwd")
    WebElement password;
    @FindBy(id = "loginButton")
    WebElement loginButton;
    @FindBy(xpath = "//div[contains(@class,'atLogoImg')]")
    WebElement logo;


    public LoginPage() {
        PageFactory.initElements(driver, this);
    }


    public String validateLoginPageTitle() {
        logger.info(driver.getTitle());
        return driver.getTitle();
    }

    public boolean validateLogo() {
        return logo.isDisplayed();
    }

    public HomePage login(String un, String pw) {
        username.sendKeys(un);
        password.sendKeys(pw);
        loginButton.click();
        return new HomePage();
    }

}
