package com.mashery.webapps;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.mashery.utilities.BrowserFactory;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class BaseClass {

	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;

	@BeforeSuite
	public void before_Suite() throws Exception {
		System.out.println("Archive Old Reports under \"./reports/\" folder");

	}

	@BeforeClass
	public void setUp() throws Exception {
		reports = new ExtentReports("./Report/report.html", true);

	}

	@BeforeMethod
	@Parameters({ "iBrowser" })
	public void before_Method(String browser) throws Exception {
		driver = BrowserFactory.browserFactory(browser);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

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
