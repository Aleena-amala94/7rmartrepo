package testScript;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import constants.Constants;

import pages.LoginPage;
import utility.ExcelUtility;

public class LoginTest extends Base {

	@Test(groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "verify the user able to login with valid crendentials")
	public void verifyTheUserIsAbleToLoginUsingValidCredentials() throws Exception {
		// String username="admin";
		// String password="abcd";
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);// parameterized construction need to create constructor in page
													// class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);

		loginpage.clickSignin();
		boolean isdashboardloaded = loginpage.isHomePageLoaded();
		Assert.assertTrue(isdashboardloaded);

	}

	@Test(groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "verify the user able to login with correct username and incorrect password")
	public void verifyWhetherUserIsAbleToLoginUsingCorrectUsernameAndIncorrectPassword() throws Exception

	{

		String username = ExcelUtility.readStringData(2, 0, "loginpage");
		String password = ExcelUtility.readStringData(2, 1, "loginpage");

		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUserName(username).enterPassword(password);
		loginpage.clickSignin();
		boolean alert = loginpage.redAlert();
		Assert.assertTrue(alert, Constants.LOGINWITHVALIDUSERNAMEANDINVALIDPASSWORD);

	}

	@Test(groups = {
			"regression" }, retryAnalyzer = retry.Retry.class, description = "verify the user able to login with incorrect username and correct password")
	public void verifyWhetherUserIsAbleToLoginUsingInCorrectUsernameAndCorrectPassword() throws Exception {

		String username = ExcelUtility.readStringData(3, 0, "loginpage");
		String password = ExcelUtility.readStringData(3, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		loginpage.clickSignin();

		boolean alert = loginpage.redAlert();
		Assert.assertTrue(alert, Constants.LOGINWITHINVALIDUSERNAMEANDVALIDPASSWORD);
	}

	@Test( description = "verify the user able to login with incorrect username and incorrect password")
	public void verifyWhetherUserIsAbleToLoginUsingInCorrectUsernameAndInCorrectPassword(String username,
			String password) throws Exception {

		// String username=ExcelUtility.readStringData(4, 0, "loginpage");
		// String password=ExcelUtility.readStringData(4, 1, "loginpage");
		LoginPage loginpage = new LoginPage(driver);

		loginpage.enterUserName(username).enterPassword(password);
		loginpage.clickSignin();

		boolean alert = loginpage.redAlert();
		Assert.assertTrue(alert, Constants.LOGINWITHINVALIDUSERNAMEANDINVALIDPASSWORD);
	}

	/*@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() throws Exception {
		return new Object[][] {
				{ ExcelUtility.readStringData(4, 0, "loginpage"), ExcelUtility.readStringData(4, 1, "loginpage") } };
	}*/
}
