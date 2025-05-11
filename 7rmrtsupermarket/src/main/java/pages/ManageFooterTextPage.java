package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class ManageFooterTextPage {
	WebDriver driver;

	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1')]")
	WebElement action;
	@FindBy(xpath = "//textarea[@id='content']")
	WebElement address;
	@FindBy(xpath = "//input[@id='email']")
	WebElement email;
	@FindBy(xpath = "//input[@id='phone']")
	WebElement phone;
	@FindBy(xpath = "//button[@class='btn btn-block-sm btn-info']")
	WebElement update;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert;

	public ManageFooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public ManageFooterTextPage addAction() {
		action.click();
		return this;
	}

	public ManageFooterTextPage addAddress(String addresstext) {
		address.clear();
		address.sendKeys(addresstext);
		return this;
	}

	public ManageFooterTextPage addEmail(String emailtext) {
		email.clear();
		email.sendKeys(emailtext);
		return this;
	}

	public ManageFooterTextPage addPhone(String phonenumber) {
		phone.clear();
		phone.sendKeys(phonenumber);
		return this;
	}

	public ManageFooterTextPage updateDetails() {
		PageUtility pu = new PageUtility();
		pu.javaClickMethod(update, driver);
		return this;
	}

	public boolean isAlertDisplayed() {
		return alert.isDisplayed();
	}

	public boolean isUpdateDisplayed() {
		return update.isDisplayed();

	}
}
