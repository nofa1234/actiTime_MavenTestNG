package com.actiTime.stepdefinitions;



import org.junit.Assert;

import com.actiTime.base.TestBase;
import com.actiTime.pages.HomePage;
import com.actiTime.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginUserStepDefinitions extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	@Given("I am on the Loging Page")
	public void i_am_on_the_loging_page() {
	    // Write code here that turns the phrase above into concrete actions
		initialization();
		loginPage =  new LoginPage();
	}

	@When("I Enter my credentials and I click on Loging button")
	public void i_enter_my_credentials_and_i_click_on_loging_button() {
	    // Write code here that turns the phrase above into concrete actions
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		
	}

	@Then("I should be able to successfuly loging to system")
	public void i_should_be_able_to_successfuly_loging_to_system() {
	    // Write code here that turns the phrase above into concrete actions
		boolean logo = homePage.validateActiTimeLogoImage();
		Assert.assertTrue(logo);
		driver.quit();
	}
}
