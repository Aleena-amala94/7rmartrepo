package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

//import utility.PageUtility;

public class AdminUsersPage {
WebDriver driver;
@FindBy (xpath="((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-admin')])[2])")WebElement adminusersinfo;
@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement adminusersnewbutton;
@FindBy(xpath="//input[@id='username']")WebElement adminusername;
@FindBy(xpath="//input[@id='password']")WebElement adminuserpassword;
@FindBy(xpath="//select[@id='user_type']")WebElement adminusertype;
@FindBy(xpath="//button[@name='Create']")WebElement adminusersave;
@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement adminuseralert;
public AdminUsersPage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void adminUsersInfo()
{
	adminusersinfo.click();
}
public void adminUserNew()
{
	adminusersnewbutton.click();
}
public void adminUserName(String usernamevalue)
{
	adminusername.sendKeys(usernamevalue);
}
public void adminUserPassword(String passwordvalue)
{
	adminuserpassword.sendKeys(passwordvalue);
}
public void adminUserType()
{
	Select select=new Select(adminusertype);
	select.selectByValue("staff");
	//PageUtility pageutility=new PageUtility();
	//pageutility.selectByIndex(adminusertype, 1);
}
public void adminUserSave()
{
	adminusersave.click();	
}
public boolean isAlertDisplayed()
{
	return adminuseralert.isDisplayed() ;
	
}
}
