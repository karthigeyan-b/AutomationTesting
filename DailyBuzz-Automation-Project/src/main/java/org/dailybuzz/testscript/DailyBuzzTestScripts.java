package org.dailybuzz.testscript;

import org.dailybuzz.pages.HomePage;
import org.dailybuzz.utils.Constans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class DailyBuzzTestScripts {

	WebDriver driver;
	HomePage homePage;

	@BeforeTest
	public void initDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constans.URL);
		homePage = new HomePage(driver);
		System.out.println("The driver is launched successfully.");
	}

	@Test(description = "Verify the Application is loaded successfully!")
	public void loginToTheApplication() {
		Assert.assertTrue(homePage.verifyTheLogoIsPresent(), "The Application is loaded successfully.");
	}

	@Test(description = "Verify the Headers are displayed and the user able to click it.")
	public void verifyTheHeadersAreDisplayedAndClickable() {
		Assert.assertTrue(homePage.verifyTheHeaders(), "The Headers are displayed.");
		Assert.assertTrue(homePage.verifyUserAbleToClickTheHeaders(), "User able to click all the headers.");
	}

	@Test(description = "Verify the Titles are displayed.")
	public void verifyTheTitles() {
		Assert.assertEquals(homePage.getAllTheTitles(), Constans.titles, "All the titles are displayed as expected.");
	}

	@AfterTest
	public void quitDriver() {
		driver.quit();
		System.out.println("The driver is closed successfully.");
	}

}
