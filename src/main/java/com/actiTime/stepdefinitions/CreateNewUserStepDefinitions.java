package com.actiTime.stepdefinitions;

import org.junit.Assert;

import com.actiTime.base.TestBase;
import com.actiTime.pages.HomePage;
import com.actiTime.pages.LoginPage;
import com.actiTime.pages.UsersPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CreateNewUserStepDefinitions extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	UsersPage userPage;
	
	@Given("I am on the Actitime Loging Page")
	public void i_am_on_the_actitime_loging_page() {
	    // Write code here that turns the phrase above into concrete actions
		initialization();
		loginPage =  new LoginPage();
	}

	@When("I Enter admin credentials and I click on Loging button")
	public void i_enter_admin_credentials_and_i_click_on_loging_button() {
	    // Write code here that turns the phrase above into concrete actions
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
	}

	@When("I should be able to successfuly loging to Actitime")
	public void i_should_be_able_to_successfuly_loging_to_actitime() {
	    // Write code here that turns the phrase above into concrete actions
		boolean logo = homePage.validateActiTimeLogoImage();
		Assert.assertTrue(logo);
	}

	@When("I Click on the Users section")
	public void i_click_on_the_users_section() {
	    // Write code here that turns the phrase above into concrete actions
		userPage = homePage.ClickOnUsersLink();
	}

	@Then("I should be able to successfuly switch Users Section")
	public void i_should_be_able_to_successfuly_switch_users_section() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(userPage.UsersPageTitle(), "actiTIME - User List");
	}

	@When("I Click on the New User button")
	public void i_click_on_the_new_user_button() {
	    // Write code here that turns the phrase above into concrete actions
		userPage.ClickOnNewUserButton();
	}

	@Then("I should be able to fill the New user Form and click on submit button")
	public void i_should_be_able_to_fill_the_new_user_form_and_click_on_submit_button() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(userPage.FillNewUserForm("Dasun", "Sennath","dasun@gmail.com"));
	}

	@Then("I should be able to successfuly create new user")
	public void i_should_be_able_to_successfuly_create_new_user() {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertTrue(userPage.verifyCreatedMessage());
	}

	@Then("Close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}
