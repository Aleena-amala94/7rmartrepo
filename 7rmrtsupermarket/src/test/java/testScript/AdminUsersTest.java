package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.AdminUsersPage;
import pages.LogOutPage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class AdminUsersTest extends Base{
	public LogOutPage logoutpage;
	public AdminUsersPage adminuserpage;
	@Test(description="verify theat user is able to save user details")
	public void verifyThatUserIsAbleToSaveUserDeatils() throws Exception
	{
		
	
		String username=ExcelUtility.readStringData(1, 0,"loginpage");
		String password=ExcelUtility.readStringData(1, 1,"loginpage");
		FakerUtility fakerutility=new FakerUtility();
		String adminusername=fakerutility.creatARandomFirstName();
		String adminpassword=fakerutility.creatARandomFirstName();
		/*String adminusername=ExcelUtility.readStringData(0, 0,"adminuserpage");
		String adminpassword=ExcelUtility.readStringData(0, 1,"adminuserpage");*/
        
        LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username).enterPassword(password);
		logoutpage=loginpage.clickSignin();
	
		//AdminUsersPage adminuserpage=new AdminUsersPage(driver);
		//adminuserpage.adminUsersMoreInfo();
		adminuserpage=logoutpage.adminUsersMoreInfo();
		adminuserpage.adminUserNew().adminUserName(adminusername).adminUserPassword(adminpassword).adminUserType().adminUserSave();

		boolean alertdisplayed=adminuserpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed);
}
}
