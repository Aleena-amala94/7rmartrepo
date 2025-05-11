package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import utility.PageUtility;

public class AdminUsersPage {
	WebDriver driver;

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement adminusersnewbutton;
	@FindBy(xpath = "//input[@id='username']")
	WebElement adminusername;
	@FindBy(xpath = "//input[@id='password']")
	WebElement adminuserpassword;
	@FindBy(xpath = "//select[@id='user_type']")
	WebElement adminusertype;
	@FindBy(xpath = "//button[@name='Create']")
	WebElement adminusersave;
	@FindBy(xpath = "//i[@class='icon fas fa-check']")
	WebElement adminuseralert;

	public AdminUsersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public AdminUsersPage adminUserNew() {
		adminusersnewbutton.click();
		return this;
	}

	public AdminUsersPage adminUserName(String usernamevalue) {
		adminusername.sendKeys(usernamevalue);
		return this;
	}

	public AdminUsersPage adminUserPassword(String passwordvalue) {
		adminuserpassword.sendKeys(passwordvalue);
		return this;
	}

	public AdminUsersPage adminUserType() {
		Select select = new Select(adminusertype);
		select.selectByValue("staff");
		// PageUtility pageutility=new PageUtility();
		// pageutility.selectByIndex(adminusertype, 1);
		return this;
	}

	public AdminUsersPage adminUserSave() {
		adminusersave.click();
		return this;
	}

	public boolean isAlertDisplayed() {
		return adminuseralert.isDisplayed();

	}
}
