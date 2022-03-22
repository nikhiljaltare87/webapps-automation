package com.mashery.utilities;

import java.io.File;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class Utilities {

	public static void verifyLinkActive(String aUrl, ExtentTest test) {

		try {

			URL url = new URL(aUrl);

			HttpURLConnection HttpURLConnecton = (HttpURLConnection) url.openConnection();

			HttpURLConnecton.setConnectTimeout(2000);

			HttpURLConnecton.connect();

			if (HttpURLConnecton.getResponseCode() == 200) {
				// System.out.println("URL " + " - " + aUrl + " -> " +
				// HttpURLConnecton.getResponseCode());
				test.log(LogStatus.PASS, "URL " + " - " + aUrl + " -> " + HttpURLConnecton.getResponseCode());

			} else if (HttpURLConnecton.getResponseCode() == HttpURLConnection.HTTP_NOT_FOUND) {
				// System.out.println("URL " + " - " + aUrl + " -> " +
				// HttpURLConnection.HTTP_NOT_FOUND);
				test.log(LogStatus.FAIL, "URL " + " - " + aUrl + " -> " + HttpURLConnection.HTTP_NOT_FOUND);

			} else if (HttpURLConnecton.getResponseCode() == HttpURLConnection.HTTP_CLIENT_TIMEOUT) {
				// System.out.println("URL " + " - " + aUrl + " -> " +
				// HttpURLConnection.HTTP_CLIENT_TIMEOUT);
				test.log(LogStatus.FAIL, "URL " + " - " + aUrl + " -> " + HttpURLConnection.HTTP_CLIENT_TIMEOUT);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void takesScreenshot(WebDriver d, ExtentTest test) {

		TakesScreenshot s = (TakesScreenshot) d;
		try {
			FileUtils.copyFile(s.getScreenshotAs(OutputType.FILE), new File("./ScreenShots/shot.png"));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
