package com.mashery.pagefactory;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Facebook_Login {

	public WebDriver driver;

	public Facebook_Login(WebDriver driver) {

		this.driver = driver;

	}

	@FindBy(how = How.XPATH, using = "//input[@name='firstname'] | //input[@label='First name']")
	WebElement first_Name;

	@FindBy(how = How.XPATH, using = "//input[@name='lastname'] | //input[@label='Surname']")
	WebElement sur_Name;

	@FindBy(how = How.XPATH, using = "//input[@name='reg_email__']")
	WebElement email_add;

	@FindBy(how = How.XPATH, using = "//input[@name='reg_passwd__']")
	WebElement password;

	@FindBy(how = How.XPATH, using = "//select[@id='day']")
	WebElement day;

	@FindBy(how = How.XPATH, using = "//select[@id='month']")
	WebElement month;

	@FindBy(how = How.XPATH, using = "//select[@id='year']")
	WebElement year;

	@FindBy(how = How.XPATH, using = "//span[text()='Next']")
	WebElement next_button;

	@FindBy(how = How.XPATH, using = "//label[text()='Female']/following::input[1]")
	WebElement female_radio;

	@FindBy(how = How.XPATH, using = "//label[text()='Male']/following::input[1]")
	WebElement male_radio;

	@FindBy(how = How.XPATH, using = "//label[text()='Custom']/following::input[1]")
	WebElement custom_radio;

	@FindBy(how = How.XPATH, using = "//a[text()='Already have an account?']")
	WebElement link;

	public void registerYourself() {

		first_Name.sendKeys("Nikhil");
		sur_Name.sendKeys("Jaltare");
		email_add.sendKeys("nikhiljaltare@gmail.com");
		password.sendKeys("abc");

		selectElement(day, "26");
		selectElement(month, "Feb");
		selectElement(year, "2022");

		custom_radio.click();
		female_radio.click();
		male_radio.click();

		// Returns Tag Name
		System.out.println(link.getTagName());
		// Returns Text associated
		System.out.println(link.getText());
		// Returns Attribute Value
		System.out.println(link.getAttribute("href"));

		link.click();

	}

	private void selectElement(WebElement e, String value) {

		Select sel = new Select(e);

		sel.selectByVisibleText(value);

		List<WebElement> list = new ArrayList<WebElement>(sel.getOptions());
		List list1 = new ArrayList();
		List list2 = new ArrayList();

		for (WebElement ele : list) {
			System.out.println(ele.getText());
			list1.add(ele.getText());

		}

		list2.addAll(list1);

		Collections.sort(list1);

		Assert.assertTrue(list2.equals(list1));

	}
}
