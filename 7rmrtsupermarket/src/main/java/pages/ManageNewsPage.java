package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement managenewsnewbutton;
	@FindBy(xpath = "//textarea[@id='news']")
	WebElement managenewstext;
	@FindBy(xpath = "//button[@type='submit']")
	WebElement managesubmit;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	WebElement alert;

	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageNewsPage clickNew() {
		managenewsnewbutton.click();
		return this;
	}

	public ManageNewsPage manageText(String textmessage) {
		managenewstext.sendKeys(textmessage);
		return this;
	}

	public ManageNewsPage manageSubmit() {
		managesubmit.click();
		return this;
	}

	public boolean isGreenAlertDispalyed() {
		return alert.isDisplayed();

	}
}
