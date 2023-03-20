package com.actiTime.tests;

import com.actiTime.base.TestBase;
import com.actiTime.pages.HomePage;
import com.actiTime.pages.LoginPage;
import com.actiTime.pages.ReportsPage;
import com.actiTime.pages.UsersPage;
import com.actiTime.pages.TaskPage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class HomePageTest extends TestBase {
        HomePage homePage;
 	LoginPage loginPage;
	TaskPage taskpage;
	ReportsPage reportPage;
	UsersPage userPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =  new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	
	@Test(priority = 1)
	public void homePageTaskLinkTest() {
		taskpage = homePage.ClickOnTaskLink();
	}
	
	@Test(priority = 2)
	public void homePageReportLinkTest() {
		reportPage = homePage.ClickOnReportsLink();
	}
	
	@Test(priority = 3)
	public void homePageUserLinkTest() {
		userPage = homePage.ClickOnUsersLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
