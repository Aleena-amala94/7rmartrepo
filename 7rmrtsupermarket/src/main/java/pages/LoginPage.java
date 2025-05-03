package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;//globally declared
	@FindBy(xpath="//input[@name='username']")WebElement username;//to locate webelement using findby
	@FindBy(xpath="//input[@name='password']")WebElement passowrd;
	@FindBy(xpath="//button[@type='submit']")WebElement submit;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//i[@class='icon fas fa-ban']")WebElement alert;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);//pagefactory using to locate webelement initElements-using to intialize element,static method
	}
	public void enterUserName(String usernamevalue)
	{
	username.sendKeys(usernamevalue);
	}
	public void enterPassword(String passwordvalue)
	{
		passowrd.sendKeys(passwordvalue);
	}
	public void clickSignin()
	{
	submit.click();
	}
	public boolean isHomePageLoaded()
	{
		return dashboard.isDisplayed();
	}
    public boolean redAlert()
    {
		return alert.isDisplayed();
    	
    }


	
}
