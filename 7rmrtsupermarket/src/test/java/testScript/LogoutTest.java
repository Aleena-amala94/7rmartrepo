package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LogoutTest extends Base{
	public LogOutPage logoutpage;
	@Test(description="verify if user is able to logout")
	public void verifyIfUserIsAbleToLogout() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username).enterPassword(password);
		logoutpage=loginpage.clickSignin();
		
		logoutpage.admin().logOut();
		boolean loginpageLoaded = logoutpage.isLoginPageLoaded();
		Assert.assertTrue(loginpageLoaded);
		
		
	}

}
