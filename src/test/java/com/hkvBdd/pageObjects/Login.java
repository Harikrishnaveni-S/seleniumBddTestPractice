package com.hkvBdd.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {
	
	WebDriver driver;
	public Login(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name="username")
	private WebElement userName;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//*[@type=\"submit\"]")
	private WebElement loginbtn;
	
	
	public void setUserName(String username)
	{
		System.out.println(username);
		userName.sendKeys(username);
	}
	
	public void setPassword(String pwd)
	{
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		loginbtn.click();
	}

}
