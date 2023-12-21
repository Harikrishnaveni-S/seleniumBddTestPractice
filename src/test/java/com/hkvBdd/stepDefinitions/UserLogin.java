package com.hkvBdd.stepDefinitions;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.hkvBdd.pageObjects.Login;
import com.hkvBdd.utilities.CommonUtils;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class UserLogin{

	CommonUtils util = new CommonUtils();
	WebDriver driver = 	CommonStepDefinition.driver;
	
	Login login = new Login(driver);
	private static final Logger logger = LogManager.getLogger(UserLogin.class);

	
	@Given("the user is on web app login page")
	public void the_user_is_on_web_app_login_page() throws InterruptedException {
        logger.info("Hello World!");

		driver.get(util.getUrl());
		logger.info("url loaded");
		Thread.sleep(5000);
	   
	}
	@When("the user enters a value in the userName input field")
	public void the_user_enters_a_value_in_the_admin_input_field() {
		login.setUserName(util.getUserName());
		logger.info("Entered Username");

	}
	@And("the user enters a value in the password input field")
	public void the_user_enters_a_value_in_the_admin123_input_field() {
	    login.setPassword(util.getPassword());
		logger.info("Entered password");

	}
	@And("the user clicks the login button")
	public void the_user_clicks_the_login_button() {
	    login.clickLogin();
	}
	@Then("the user should land on the dashboard page")
	public void the_user_should_land_on_the_dashboard_page() throws IOException, InterruptedException {
	    String currentUrl = driver.getCurrentUrl();
	    if(currentUrl.contains("dashboardlll"))
	    {
	    	Assert.assertTrue(true);
	    }
	    else {
			Thread.sleep(3000);

	    	CommonUtils.takeScreenshot();
	    	Assert.assertTrue(false);
	    }
	    	
	}



}
