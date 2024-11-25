package org.dailybuzz.testscript;

import org.dailybuzz.pages.HomePage;
import org.dailybuzz.utils.Constans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author karthigeyan.bala
 *
 */
public class DailyBuzzTestScripts {

	WebDriver driver;
	HomePage homePage;

	@BeforeTest
	public void InitDriver() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(Constans.URL);
		homePage = new HomePage(driver);
		System.out.println("The driver is launched successfully.");
	}

	@Test(description = "Verify the Application is loaded successfully!")
	public void LoginToTheApplication() {
		Assert.assertTrue(homePage.verifyTheLogoIsPresent(), "The Application is loaded successfully.");
	}

	@Test(description = "Verify the Headers are displayed and the user able to click it.")
	public void VerifyTheHeadersAreDisplayedAndClickable() {
		Assert.assertTrue(homePage.verifyTheHeaders(), "The Headers are displayed.");
		Assert.assertTrue(homePage.verifyUserAbleToClickTheHeaders(), "User able to click all the headers.");
	}

	@Test(description = "Verify the Titles are displayed.")
	public void VerifyTheTitles() {
		Assert.assertEquals(homePage.getAllTheTitles(), Constans.titles, "All the titles are displayed as expected.");
	}

	@Test(description = "Verify user able to make a reservation.")
	public void VerifyUserAbleToMakeReservation() {
		Assert.assertTrue(homePage.verifyReservation(), "User able to make a reservation.");
	}

	@Test(description = "Verify user able to send the feedback message.")
	public void VerifyUserAbleToFeedbackSendMessage() {
		Assert.assertTrue(homePage.verifyContactUs(), "User able to send the feedback.");
	}

	@AfterTest
	public void quitDriver() {
		driver.quit();
		System.out.println("The driver is closed successfully.");
	}

}
