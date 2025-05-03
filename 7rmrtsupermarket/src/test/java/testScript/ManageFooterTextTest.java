package testScript;
import org.testng.Assert;
import org.testng.annotations.Test;


import pages.LoginPage;
import pages.ManageFooterTextPage;
import utility.ExcelUtility;

public class ManageFooterTextTest extends Base{
	@Test(groups="regression")
	
	public void verifyIfUserAbleToUpdateFooterDetails() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		String address=ExcelUtility.readStringData(1, 0,"managefooter");
		String email=ExcelUtility.readStringData(1, 1,"managefooter");
		String phone=ExcelUtility.readStringData(1, 2, "managefooter");
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickMoreInfo();
		managefootertextpage.addAction();
		managefootertextpage.addAddress(address);
		managefootertextpage.addEmail(email);
		managefootertextpage.addPhone(phone);
		managefootertextpage.updateDetails();
		boolean alertdisplayed=managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed);
		
	}
	@Test
	public void verifyIfUpdateButtonIsDisplayed() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage.clickMoreInfo();
		managefootertextpage.addAction();
		boolean isUpdateDisplayed=managefootertextpage.isUpdateDisplayed();
		Assert.assertTrue(isUpdateDisplayed);
	}
	 
	
}
