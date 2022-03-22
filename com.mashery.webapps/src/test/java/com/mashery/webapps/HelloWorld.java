package com.mashery.webapps;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mashery.pagefactory.Facebook_Login;
import com.mashery.pagefactory.Twitter_Login;
import com.mashery.utilities.BrowserFactory;
import com.mashery.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class HelloWorld extends BaseClass {

	@Test(priority = 1)
	@Parameters({ "iBrowser" })
	public void verifyTwitterLogin(String browser) {

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		test = reports.startTest("Started Test: " + name + " on " + browser);

		BrowserFactory.getURL("https://www.twitter.com");

		Twitter_Login loggg = PageFactory.initElements(driver, Twitter_Login.class);

		test.log(LogStatus.INFO, "Performing Login");

		loggg.login("nikhiljaltare@gmail.com");

		Utilities.takesScreenshot(driver, test);

	}

	@Test(priority = 2)
	@Parameters({ "iBrowser" })
	public void verifyBrokenLinksTest(String browser) {

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		test = reports.startTest("Started Test: " + name + " on " + browser);

		BrowserFactory.getURL("https://www.google.com");

		// Utilities.takesScreenshot(driver, test);

		List<WebElement> lis = driver.findElements(By.tagName("a"));

		int size = lis.size();

		System.out.println("Total Link Count -> " + size);

		test.log(LogStatus.INFO, "Total Link Count -> " + size);

		test.log(LogStatus.INFO, "Verification of Link :");

		for (int i = 0; i <= size - 1; i++) {

			WebElement ele = lis.get(i);

			String url = ele.getAttribute("href");

			Utilities.verifyLinkActive(url, test);

		}
	}

	@Test(priority = 3)
	@Parameters({ "iBrowser" })
	public void verifyFacebookRegTest(String browser) {

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		test = reports.startTest("Started Test: " + name + " on " + browser);

		BrowserFactory.getURL("https://www.facebook.com/reg/");

		Facebook_Login log = PageFactory.initElements(driver, Facebook_Login.class);

		log.registerYourself();

		Utilities.takesScreenshot(driver, test);

	}

}