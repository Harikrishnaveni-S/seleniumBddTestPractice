package com.hkvBdd.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.hkvBdd.stepDefinitions.CommonStepDefinition;

public class CommonUtils {
	File file = new File("./configurations/config.properties");
	FileInputStream fis;
	Properties prop;
	private Logger logger = LogManager.getLogger(CommonUtils.class);

	public CommonUtils() {

		try {
			System.out.println(file);
			fis = new FileInputStream(file);
			logger.info("Got file location");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String getUrl() {
		String url = prop.getProperty("AppUrl");
		System.out.println(url);
		return url;
	}

	public String getUserName() {
		String userName = prop.getProperty("UserName");
		return userName;
	}

	public String getPassword() {
		String password = prop.getProperty("Password");
		return password;
	}
	
	public String getBrowserName()
	{
		String browser =prop.getProperty("Browser");
		System.out.println(browser);
		return browser;
	}
	
	public static void takeScreenshot() throws IOException
	{
		File screenShot = ((TakesScreenshot) CommonStepDefinition.driver).getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(screenShot, new File("./screenshots/"+CommonStepDefinition.ScenarioName+".png"));
	}

}
