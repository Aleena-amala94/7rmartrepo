package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utility.PageUtility;

public class LogOutPage {
	WebDriver driver;
	@FindBy(xpath = "//a[@data-toggle='dropdown']")
	WebElement admin;
	@FindBy(xpath = "//i[@class='ace-icon fa fa-power-off']")
	WebElement logout;
	@FindBy(xpath = "//button[text()='Sign In']")
	WebElement signIn;

	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")
	WebElement adminusersmoreinfo;
	@FindBy(xpath = "//p[text()='Manage News']")
	WebElement managenewsmoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-category')])[3])")
	WebElement managecategorymoreinfo;
	@FindBy(xpath = "((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-footertext')])[2])")
	WebElement managefootermoreinfo;
	@FindBy(xpath = "(//a[@href='https://groceryapp.uniqassosiates.com/admin/list-contact'])[2]")
	WebElement manageContactMoreInfo;
	@FindBy(xpath = "//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-sub-category')]")
	WebElement subcategorymoreinfo;

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public AdminUsersPage adminUsersMoreInfo() {
		adminusersmoreinfo.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage manageNewsMoreInfo() {
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);
	}

	public ManageCategoryPage clickMoreInfo() {
		managecategorymoreinfo.click();

		return new ManageCategoryPage(driver);

	}

	public ManageFooterTextPage managefooterMoreInfo() {
		PageUtility pu = new PageUtility();
		pu.javaClickMethod(managefootermoreinfo, driver);
		return new ManageFooterTextPage(driver);
	}

	public ManageContactPage ManageContactMoreInfo() {
		manageContactMoreInfo.click();
		return new ManageContactPage(driver);
	}

	public SubCategoryPage subCategoryMoreInfo() {
		subcategorymoreinfo.click();
		return new SubCategoryPage(driver);
	}

	public LogOutPage admin() {
		admin.click();
		return this;
	}

	public LogOutPage logOut() {
		logout.click();
		return this;
	}

	public boolean isLoginPageLoaded() {
		return signIn.isDisplayed();

	}
}
