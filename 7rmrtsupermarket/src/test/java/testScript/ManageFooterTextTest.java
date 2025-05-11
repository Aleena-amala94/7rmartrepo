package testScript;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import pages.ManageFooterTextPage;
import utility.ExcelUtility;

public class ManageFooterTextTest extends Base{
	public LogOutPage logoutpage;
	public ManageFooterTextPage managefootertext;
	@Test(groups="regression",description="verify if user is able to update footer details")
	
	public void verifyIfUserAbleToUpdateFooterDetails() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username).enterPassword(password);
		
		logoutpage=loginpage.clickSignin();
		String address=ExcelUtility.readStringData(1, 0,"managefooter");
		String email=ExcelUtility.readStringData(1, 1,"managefooter");
		String phone=ExcelUtility.readStringData(1, 2, "managefooter");
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage=logoutpage.managefooterMoreInfo();
		managefootertextpage.addAction().addAddress(address).addEmail(email).addPhone(phone).updateDetails();
	boolean alertdisplayed=managefootertextpage.isAlertDisplayed();
		Assert.assertTrue(alertdisplayed);
		
	}
	@Test(description="verify if update button is displayed")
	public void verifyIfUpdateButtonIsDisplayed() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
        LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
		loginpage.enterUserName(username).enterPassword(password);
	
		logoutpage=loginpage.clickSignin();
		ManageFooterTextPage managefootertextpage=new ManageFooterTextPage(driver);
		managefootertextpage=logoutpage.managefooterMoreInfo();
		managefootertextpage.addAction();
		boolean isUpdateDisplayed=managefootertextpage.isUpdateDisplayed();
		Assert.assertTrue(isUpdateDisplayed);
	}
	 
	
}
