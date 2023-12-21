package com.hkvBdd.runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
		features = "src/test/java/com/hkvBdd/featureFiles",
		glue = "com.hkvBdd.stepDefinitions",
		dryRun= false,
		monochrome = true,
		plugin = {"html:target/cucumber-reports/report.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
				"io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
				}
		
		)

public class TestRunner {

}
