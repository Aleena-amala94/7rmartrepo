package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageFooterTextPage {
	WebDriver driver;
	@FindBy(xpath="((//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/list-footertext')])[2])")WebElement managefootermoreinfo;
	@FindBy(xpath="//a[contains(@href,'https://groceryapp.uniqassosiates.com/admin/Footertext/edit?edit=1')]")WebElement action;
	@FindBy(xpath="//textarea[@id='content']")WebElement address;
	@FindBy(xpath="//input[@id='email']")WebElement email;
	@FindBy(xpath="//input[@id='phone']")WebElement phone;
	@FindBy(xpath="//button[@class='btn btn-block-sm btn-info']")WebElement update;
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alert;
	public ManageFooterTextPage(WebDriver driver)
	 {
		 this.driver=driver;
			PageFactory.initElements(driver, this);
	 }
	public void clickMoreInfo()
	{
		//managefootermoreinfo.click();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", managefootermoreinfo);
	}
	public void addAction()
	{
		action.click();
	}
	public void addAddress(String addresstext)
	{
		address.clear();
		address.sendKeys(addresstext);
	}
	public void addEmail(String emailtext)
	{
		email.clear();
		email.sendKeys(emailtext);
	}
	public void addPhone(String phonenumber)
	{
		phone.clear();
		phone.sendKeys(phonenumber);
	}
	public void updateDetails()
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",update);
	}
	public boolean isAlertDisplayed()
	{
		return alert.isDisplayed();
	}
	public boolean isUpdateDisplayed()
	{
		return update.isDisplayed();
		
	}
}
