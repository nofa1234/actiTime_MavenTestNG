package com.actiTime.tests;

import com.actiTime.base.TestBase;
import com.actiTime.pages.HomePage;
import com.actiTime.pages.LoginPage;
import com.actiTime.pages.UsersPage;
import com.actiTime.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsersPageTest extends TestBase {
        LoginPage loginPage;
	HomePage homePage;
	UsersPage userPage;
	String SheetName = "NewUsers";
	
	public UsersPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =  new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		userPage = homePage.ClickOnUsersLink();
		
	}
	
	@Test(priority = 1)
	public void VerifyPageTitle() {
		
		Assert.assertEquals(userPage.UsersPageTitle(), "actiTIME - User List");
	}
	
	@DataProvider
	public Object [][] GetNewUserTestData()
	{
	   Object [][] data = 	TestUtil.getTestData(SheetName);
	   return data;
	}
	
	@Test(priority = 2, dataProvider = "GetNewUserTestData")
	public void ValidateNewUserForm(String fname,String lname ,String email) {
		
		userPage.ClickOnNewUserButton();
		
		Assert.assertTrue(userPage.FillNewUserForm(fname, lname,email),"The Created Message not Displayed");
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
