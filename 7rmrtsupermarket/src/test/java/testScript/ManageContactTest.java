package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageContactPage;
import utility.ExcelUtility;


public class ManageContactTest extends Base {
	public LogOutPage logoutpage;
	public ManageContactPage managecontactpage;
	@Test(groups={"regression"},description = "Verify the user is able to update contact details")
	public void verifyIfUserAbleToUpdateContactDetails() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		String manageConatctPhone=  ExcelUtility.readIntegerData(1, 0, "managecontact");
		String manageContactEmail = ExcelUtility.readStringData(1, 1, "managecontact");
		String managecontactAddress = ExcelUtility.readStringData(1, 2, "managecontact");
		String manageContactDeliveryTime =ExcelUtility.readIntegerData(1, 3, "managecontact");
		String manageContactDeliveryCharge =ExcelUtility.readIntegerData(1, 4,"managecontact") ;
		
		LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username).enterPassword(password);
		
		logoutpage=loginpage.clickSignin();
		
		//ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage=logoutpage.ManageContactMoreInfo();
		managecontactpage.clickManageContactAction().enterManageContactPhone(manageConatctPhone).enterManageConatctEmail(manageContactEmail).enterManageConatctAddress(managecontactAddress).enterManageContactDeliveryTime(manageContactDeliveryTime).enterManageContactDeliveryCharge(manageContactDeliveryCharge).clickManageContactUpdate();
		boolean isgreenalertdisplayed=managecontactpage.isManageContactAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);
		

		
		
		
		
	}

}
