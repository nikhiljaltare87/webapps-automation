package com.mashery.webapps;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;

	@BeforeClass
	public void setUp() throws Exception {
		reports = new ExtentReports("./Report/report.html", true);

	}

	@AfterMethod
	public void after_test() {

		reports.endTest(test);
		driver.quit();
	}

	@AfterClass
	public void after_class() {

		reports.flush();

	}
}
