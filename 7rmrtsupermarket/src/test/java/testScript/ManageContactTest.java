package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class ManageContactTest extends Base {
	@Test(groups={"regression"},description = "Verify the user is able to update contact")
	public void verifyIfUserAbleToUpdateContactDetails() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		
		FakerUtility fakerutility = new FakerUtility();
		String manageConatctPhone= fakerutility.generatePhone();
		String manageContactEmail = fakerutility.generateEmail();
		String managecontactAddress = fakerutility.generateAddress();
		String manageContactDeliveryTime = "5 pm";
		String manageContactDeliveryCharge = "50";
		
		LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		
		ManageContactPage managecontactpage=new ManageContactPage(driver);
		managecontactpage.clickManageContactMoreInfo();
		managecontactpage.clickManageContactAction();
		managecontactpage.enterManageContactPhone(manageConatctPhone);;
		managecontactpage.enterManageConatctEmail(manageContactEmail);
		managecontactpage.enterManageConatctAddress( managecontactAddress);
		managecontactpage.enterManageContactDeliveryTime(manageContactDeliveryTime);
		managecontactpage.enterManageContactDeliveryCharge(manageContactDeliveryCharge);
		managecontactpage.clickManageContactUpdate();
		boolean isgreenalertdisplayed=managecontactpage.isManageContactAlertDisplayed();
		Assert.assertTrue(isgreenalertdisplayed);
		
		
	}

}
