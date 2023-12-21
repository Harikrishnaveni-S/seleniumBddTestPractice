package com.hkvBdd.stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.hkvBdd.utilities.CommonUtils;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class CommonStepDefinition{

	public static WebDriver driver;
	private String browser;
    private static final Logger logger = LogManager.getLogger(CommonStepDefinition.class);
    public static String ScenarioName;
	@Before
	public void launchBrowser(Scenario scenario) {
		ScenarioName = scenario.getName();
		CommonUtils util = new CommonUtils();
		
		browser = util.getBrowserName();
		if (driver == null) {
			logger.info("Launching browser");
			invoke();
			logger.info("browser launched");
		}
	}

	public void invoke() {
		switch (browser) {
			case "chrome": {
				driver = new ChromeDriver();
				break;
			}
			case "firefox": {
				driver = new FirefoxDriver();
				break;
			}
			case "edge": {
				driver = new EdgeDriver();
				break;
			}
		}
	}
	
	@After
	public void tearDown()
	{
		driver.quit();
	}
	
	@AfterStep
	public void attachScreenshot(Scenario scenario) {
		ScenarioName = scenario.getName();

		if(scenario.isFailed())
		{
			byte[] screenshotTaken = ((TakesScreenshot) (CommonStepDefinition.driver)).getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshotTaken, ".png", ScenarioName);
		}
	}

	
	

}
