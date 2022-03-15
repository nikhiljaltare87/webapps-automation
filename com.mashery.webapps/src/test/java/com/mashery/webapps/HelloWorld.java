package com.mashery.webapps;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.mashery.pagefactory.Login_Page;
import com.mashery.utilities.BrowserFactory;
import com.mashery.utilities.Utilities;
import com.relevantcodes.extentreports.LogStatus;

public class HelloWorld extends BaseClass {

	@Test(priority = 1)
	@Parameters({ "iBrowser" })
	public void verifyTwitterLogin(String browser) {

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		test = reports.startTest(name + " on " + browser);

		driver = BrowserFactory.browserFactory(browser, "https://www.twitter.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		Login_Page loggg = PageFactory.initElements(driver, Login_Page.class);

		test.log(LogStatus.INFO, "Performing Login");

		loggg.login("nikhiljaltare@gmail.com");

		Utilities.takesScreenshot(driver, test);

	}

	@Test(priority = 2)
	@Parameters({ "iBrowser" })
	public void verifyBrokenLinksTest(String browser) {

		String name = new Object() {
		}.getClass().getEnclosingMethod().getName();

		test = reports.startTest(name + " on " + browser);

		driver = BrowserFactory.browserFactory(browser, "https://www.google.com");

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Utilities.takesScreenshot(driver, test);

		List<WebElement> lis = driver.findElements(By.tagName("a"));

		int size = lis.size();

		test.log(LogStatus.INFO, "Total Link Count -> " + size);

		test.log(LogStatus.INFO, "Verification of Link :");

		for (int i = 0; i <= size - 1; i++) {

			WebElement ele = lis.get(i);

			String url = ele.getAttribute("href");

			Utilities.verifyLinkActive(url, test);

		}
	}
}