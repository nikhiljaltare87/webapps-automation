package com.mashery.pagefactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class Twitter_Login {

	public WebDriver driver;

	public Twitter_Login(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//a[@data-testid='loginButton']")
	WebElement login_button;

	@FindBy(how = How.XPATH, using = "//input[@autocomplete='username']")
	WebElement username_textfield;

	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
	WebElement next_button;

	public void login(String username) {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		login_button.click();
		username_textfield.sendKeys(username);
		next_button.click();
	}

}
