package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageCategoryPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class ManageCategoryTest extends Base {
	public LogOutPage logout;
	public ManageCategoryPage managecategory;

	@Test(description="verify user is able to add category")
	public void verifyIfUserIsAbleToAddCategory() throws Exception {
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		FakerUtility fakerutility = new FakerUtility();
		String category1 = fakerutility.creatARandomFirstName();
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);

		logout = loginpage.clickSignin();
		// ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
		managecategory = logout.clickMoreInfo();
		managecategory.clickNew().enterCategory(category1).clickDiscount().chooseImage().clickSave();

		boolean isgreenalertdisplayed = managecategory.isAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);

	}

}
