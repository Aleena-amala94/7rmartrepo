package testScript;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LogOutPage;
import pages.LoginPage;
import pages.SubCategoryPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class SubCategoryTest extends Base{
	public LogOutPage logoutpage;
	public SubCategoryPage subcategorypage;
	@Test(description="verify if user is able to add subcategory details")
	public void verifyIfUserIsAbleToAddSubCategoryDetails() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");

		FakerUtility fakerutility = new FakerUtility();
		String category1  = fakerutility.creatARandomFirstName();
			LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
			loginpage.enterUserName(username).enterPassword(password);
			
			logoutpage=loginpage.clickSignin();
			//SubCategoryPage subcategorypage = new SubCategoryPage(driver);
			subcategorypage=logoutpage.subCategoryMoreInfo();
			subcategorypage.clickNew().addCategory().enterSubCategory(category1).uploadImage().clickSave();
			
			boolean isgreenalertdisplayed = subcategorypage.isAlertDisplyed();
			Assert.assertTrue(isgreenalertdisplayed);
			
	}
	@Test(description="verify if user is able to update subcategory details")
	public void verifyIfUserIsAbleToUpdateSubCategoryDetails() throws Exception
	{
		String username = ExcelUtility.readStringData(1, 0, "loginpage");
		String password = ExcelUtility.readStringData(1, 1, "loginpage");
		FakerUtility fakerutility = new FakerUtility();
		//String category1  = fakerutility.creatARandomFirstName();
		String editcategory =fakerutility.creatARandomFirstName();
		//String category1 = ExcelUtility.readStringData(1, 0, "subcategory");
		//String editcategory = ExcelUtility.readStringData(1, 1, "subcategory");
			LoginPage loginpage = new LoginPage(driver);//parameterized construction need to create constructor in page class
			loginpage.enterUserName(username).enterPassword(password);
			
			logoutpage=loginpage.clickSignin();
			//SubCategoryPage subcategorypage = new SubCategoryPage(driver);
			subcategorypage=logoutpage.subCategoryMoreInfo();
			subcategorypage.clickAction().updatecategory().updateSubCategory(editcategory).updateImage().updateSave();
			
			boolean isgreenalertdisplayed = subcategorypage.isUpdateAlertDisplyed();
			Assert.assertTrue(isgreenalertdisplayed);
			
	}

}
