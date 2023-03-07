package com.actiTime.pages;

import com.actiTime.base.TestBase;
import com.actiTime.util.TestUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class UsersPage extends TestBase {

    org.apache.log4j.Logger log = org.apache.log4j.Logger.getLogger(UsersPage.class);
    @FindBy(xpath = "//div[contains(text(),'Users')]")
    WebElement usersText;
    @FindBy(xpath = "//div[contains(text(),'New User')]")
    WebElement newUserButton;
    @FindBy(xpath = "//div[contains(@class,'create_user_sliding_panel sliding_panel components_panelContainer')]")
    WebElement newUserSidePannel;
    @FindBy(xpath = "//div[contains(text(),'Add User')]")
    WebElement addUserText;
    @FindBy(xpath = "//input[@placeholder='First Name' and @id='createUserPanel_firstNameField']")
    WebElement fName;

    @FindBy(xpath = "//input[@placeholder='MI' and @id='createUserPanel_middleNameField']")
    WebElement mName;
    @FindBy(xpath = "//input[@placeholder='Last Name' and @id='createUserPanel_lastNameField']")
    WebElement lName;
    @FindBy(xpath = "//input[@placeholder='Email' and @id='createUserPanel_emailField']")
    WebElement email;
    @FindBy(xpath = "//div[contains(text(),'Save & Send Invitation')]")
    WebElement saveButton;

    public UsersPage() {
        PageFactory.initElements(driver, this);
    }

    public boolean validateUsersText() {
        return usersText.isDisplayed();
    }

    public boolean clickNewUserButton() {
        newUserButton.click();
        String cssValue = newUserSidePannel.getCssValue("display");
        return cssValue.contains("block") && addUserText.isDisplayed();
    }

    public void fillTheForm(String fname, String lname, String mname, String mail) {
        clickNewUserButton();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='First Name' and @id='createUserPanel_firstNameField']")));
        fName.sendKeys(fname);
        log.info(fName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='MI' and @id='createUserPanel_middleNameField']")));
        mName.sendKeys(mname);
        log.info(mName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Last Name' and @id='createUserPanel_lastNameField']")));
        lName.sendKeys(lname);
        log.info(lName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Email' and @id='createUserPanel_emailField']")));
        email.sendKeys(mail);
        log.info(email);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Save & Send Invitation')]")));
        saveButton.click();
        log.info(saveButton);
    }
}
