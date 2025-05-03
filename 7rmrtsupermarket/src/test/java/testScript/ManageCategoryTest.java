package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageCategoryPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class ManageCategoryTest extends Base{
	@Test
	public void verifyIfUserIsAbleToAddCategory() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
	
		FakerUtility fakerutility = new FakerUtility();
		String category1 = fakerutility.creatARandomFirstName();
			LoginPage loginpage = new LoginPage(driver);
			loginpage.enterUserName(username);
			loginpage.enterPassword(password);
			loginpage.clickSignin();
			ManageCategoryPage managecategorypage = new ManageCategoryPage(driver);
			managecategorypage.clickMoreInfo();
			managecategorypage.clickNew();
			managecategorypage.enterCategory(category1);
			managecategorypage.clickDiscount();
			managecategorypage.chooseImage();
			managecategorypage.clickSave();
			boolean isgreenalertdisplayed = managecategorypage.isAlertDisplayed();
			Assert.assertTrue(isgreenalertdisplayed);
			
			
			
	}
	
	
	

}
