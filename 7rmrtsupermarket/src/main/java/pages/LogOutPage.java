package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogOutPage {
	WebDriver driver;
	@FindBy(xpath="//a[@data-toggle='dropdown']")WebElement admin;
	@FindBy(xpath="//i[@class='ace-icon fa fa-power-off']")WebElement logout;
		public LogOutPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);

}
	public void admin()
	{
		admin.click();;
	}
	public void logOut()
	{
		logout.click();
	}
}
