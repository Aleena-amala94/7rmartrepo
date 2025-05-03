package testScript;

import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import utility.ExcelUtility;

public class LogoutTest extends Base{
	@Test
	public void verifyIfUserIsAbleToLogout() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		LogOutPage logout=new LogOutPage(driver);
		logout.admin();
		logout.logOut();
		
	}

}
