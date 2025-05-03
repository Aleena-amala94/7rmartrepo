package testScript;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageNewsPage;
import utility.ExcelUtility;

public class ManageNewsTest extends Base{
	
	@Test
	public void verifyThatUserIsAbleToSaveNews() throws Exception
	{
		//String username="admin";
		//String password="admin";
       // String text="welcome Page";
		String username=ExcelUtility.readStringData(1, 0,"loginpage");
		String password=ExcelUtility.readStringData(1, 1,"loginpage");
		String text=ExcelUtility.readStringData(1, 0,"managenewspage");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUserName(username);
		loginpage.enterPassword(password);
		loginpage.clickSignin();
		ManageNewsPage managenewspage=new ManageNewsPage(driver);
		managenewspage.manageNewsMoreInfo();
		managenewspage.clickNew();
		managenewspage.manageText(text);
		managenewspage.manageSubmit();
		boolean alertdisplayed=managenewspage.isGreenAlertDispalyed();
		Assert.assertTrue(alertdisplayed);
		
	}

}
