package com.actiTime.tests;

import com.actiTime.base.TestBase;
import com.actiTime.pages.HomePage;
import com.actiTime.pages.LoginPage;
import com.actiTime.util.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {

        LoginPage loginPage;
 	HomePage homepage;
	String SheetName  = "Users";
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage =  new LoginPage();
	}
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String title = loginPage.validatePageTitle();
		Assert.assertEquals(title, "actiTIME - Login");
	}
	
	@Test(priority = 2)
	public void loginPageLogoTest(){
		boolean logo = loginPage.validateActiTimeLogoImage();
		Assert.assertTrue(logo);
	}
	
	@DataProvider
	public Object [][] GetUserTestData()
	{
	   Object [][] data = 	TestUtil.getTestData(SheetName);
	   return data;
	}
	
	@Test(priority = 3,dataProvider = "GetUserTestData")
	public void loginTest(String Username,String Password) {
		homepage = loginPage.login(Username, Password);
		
	}
	
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
