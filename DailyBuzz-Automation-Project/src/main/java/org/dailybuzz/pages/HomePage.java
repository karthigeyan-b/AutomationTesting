package org.dailybuzz.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.pagefactory.ElementLocatorFactory;

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

	public HomePage(WebDriver driver) {
		this.driver = driver;
		ElementLocatorFactory finder = new AjaxElementLocatorFactory(driver, 30);
		PageFactory.initElements(finder, this);
	}

	public Boolean verifyTheLogoIsPresent() {
		return logoIcon.isDisplayed();
	}

	public Boolean verifyTheHeaders() {
		System.out.println("Checking whether the headers are displayed.");
		return home.isDisplayed() && about.isDisplayed() && menu.isDisplayed() && reservations.isDisplayed()
				&& contact.isDisplayed();
	}

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

	public List<String> getAllTheTitles() {
		List<String> titleList = new ArrayList<String>();
		for (WebElement title : titleTexts) {
			titleList.add(title.getText().trim());
		}
		return titleList;
	}

}
