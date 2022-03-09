package com.mashery.webapps;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.mashery.utilities.Utilities;

public class HelloWorld extends BaseClass {

	@Test
	public void verifyBrokenLinksTest() {

		List<WebElement> lis = driver.findElements(By.tagName("a"));

		int size = lis.size();

		System.out.println("Total Link Count : " + size);

		for (int i = 0; i <= size - 1; i++) {

			WebElement ele = lis.get(i);

			String url = ele.getAttribute("href");

			Utilities.verifyLinkActive(url);

		}

	}

}
