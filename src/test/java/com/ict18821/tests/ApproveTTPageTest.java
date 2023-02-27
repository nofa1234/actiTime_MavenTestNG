package com.ict18821.tests;

import com.ict18821.base.TestBase;
import com.ict18821.pages.ApproveTTPage;
import com.ict18821.pages.HomePage;
import com.ict18821.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ApproveTTPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    ApproveTTPage approveTTPage;

    public ApproveTTPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
        homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
        approveTTPage = homePage.ClickApproveTimeTrack();
    }

    @Test(priority = 1)
    public void validateTitleTest() {
        String title = approveTTPage.validateTitle();
        Assert.assertEquals(title, "actiTIME - Approve Time-Track", "title mis-matched");
    }

    @Test(priority = 2)
    public void acceptTtTest() {
        Assert.assertTrue(approveTTPage.acceptTt());
    }

    @Test(priority = 3)
    public void rejectTtTest() {
        Assert.assertTrue(approveTTPage.rejectTt());
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
