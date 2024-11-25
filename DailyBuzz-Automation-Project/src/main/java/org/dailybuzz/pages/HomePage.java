package org.dailybuzz.pages;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.dailybuzz.utils.Constans;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author karthigeyan.bala
 *
 */
public class HomePage {

	private WebDriver driver = null;

	@FindBy(css = "div.logo")
	WebElement logoIcon;

	@FindBy(css = "li a[href='#home']")
	WebElement home;

	@FindBy(css = "li a[href='#about']")
	WebElement about;

	@FindBy(css = "li a[href='#menu']")
	WebElement menu;

	@FindBy(css = "li a[href='#reservations']")
	WebElement reservations;

	@FindBy(css = "li a[href='#contact']")
	WebElement contact;

	@FindBy(css = "h2")
	List<WebElement> titleTexts;

	@FindBy(css = ".reservation-form input[name='name']")
	WebElement reservationName;

	@FindBy(css = ".reservation-form input[name='email']")
	WebElement reservationEmail;

	@FindBy(css = ".reservation-form input[name='phone']")
	WebElement reservationPhone;

	@FindBy(css = ".reservation-form input[name='date']")
	WebElement reservationDate;

	@FindBy(css = ".reservation-form input[name='time']")
	WebElement reservationTime;

	@FindBy(css = ".reservation-form textarea[name='message']")
	WebElement reservationMessage;

	@FindBy(css = ".reservation-form button[type='submit']")
	WebElement buttonSubmit;

	@FindBy(css = ".contact-form input[name='name']")
	WebElement contactUsName;

	@FindBy(css = ".contact-form input[name='email']")
	WebElement contactUsEmail;

	@FindBy(css = ".contact-form textarea[name='message']")
	WebElement contactUsMessage;

	@FindBy(css = ".contact-form button[type='submit']")
	WebElement buttonSendMessage;

	/**
	 * Constructor of HomePage class
	 * 
	 * @param driver
	 */
	public HomePage(WebDriver driver) {
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
	}

	/**
	 * To verify whether the Logo is present.
	 * 
	 * @return {@code true} if the Logo is present and visible; {@code false}
	 *         otherwise
	 */
	public Boolean verifyTheLogoIsPresent() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(logoIcon));
		return logoIcon.isDisplayed();
	}

	/**
	 * To verify whether the Headers are present.
	 * 
	 * @return {@code true} if the Headers are present and visible; {@code false}
	 *         otherwise
	 */
	public Boolean verifyTheHeaders() {
		System.out.println("Checking whether the headers are displayed.");
		return home.isDisplayed() && about.isDisplayed() && menu.isDisplayed() && reservations.isDisplayed()
				&& contact.isDisplayed();
	}

	/**
	 * To verify whether the Headers are clickable.
	 * 
	 * @return {@code true} if the Headers are clickable; {@code false} otherwise
	 */
	public Boolean verifyUserAbleToClickTheHeaders() {
		boolean flag = false;
		try {
			System.out.println("Click the headers.");
			home.click();
			about.click();
			menu.click();
			reservations.click();
			contact.click();
			System.out.println("All the headers are clickable.");
			flag = true;
		} catch (Exception e) {
			System.out.println("Error on clicking the headers.");
		}
		return flag;
	}

	/**
	 * To get the text of all titles.
	 * 
	 * @return List of all titles
	 */
	public List<String> getAllTheTitles() {
		List<String> titleList = new ArrayList<String>();
		for (WebElement title : titleTexts) {
			titleList.add(title.getText().trim());
		}
		return titleList;
	}

	/**
	 * To get Today's date.
	 * 
	 * @return Current Date in DD-MM-YYY format
	 */
	public String getCurrentDate() {
		LocalDate currentDate = LocalDate.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		String formattedDate = currentDate.format(formatter);
		System.out.println("Current Date: " + formattedDate);
		return formattedDate;
	}

	/**
	 * To verify whether the user able to make the reservation.
	 * 
	 * @return {@code true} if the reservation is done; {@code false} otherwise
	 */
	public Boolean verifyReservation() {
		boolean flag = false;
		try {
			reservationName.sendKeys(Constans.ClientName);
			reservationEmail.sendKeys(Constans.ClientEmail);
			reservationPhone.sendKeys(Constans.ClientPhoneNumber);
			reservationDate.sendKeys(getCurrentDate());
			reservationTime.sendKeys(Constans.ClientReservationTime);
			reservationTime.sendKeys(Constans.PM);
			reservationMessage.sendKeys(Constans.ClientMessage);
			buttonSubmit.click();
			System.out.println("Client able to make a reservation.");
			flag = true;
		} catch (Exception e) {
			System.out.println("Error on making a reservation.");
		}
		return flag;
	}

	/**
	 * To verify whether the user able to make the feedback.
	 * 
	 * @return {@code true} if the feedback is sent; {@code false} otherwise
	 */
	public Boolean verifyContactUs() {
		boolean flag = false;
		try {
			contactUsName.sendKeys(Constans.ClientName);
			contactUsEmail.sendKeys(Constans.ClientEmail);
			contactUsMessage.sendKeys(Constans.ClientMessage);
			buttonSendMessage.click();
			System.out.println("Client able to send the feedback message.");
			flag = true;
		} catch (Exception e) {
			System.out.println("Error on making a reservation.");
		}
		return flag;
	}

}
