package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ManageNewsPage {
	WebDriver driver;
	@FindBy(xpath="//p[text()='Manage News']")WebElement managenewsmoreinfo;
	
	@FindBy(xpath="//a[@class='btn btn-rounded btn-danger']")WebElement managenewsnewbutton;
	@FindBy(xpath="//textarea[@id='news']") WebElement managenewstext;
	@FindBy(xpath="//button[@type='submit']")WebElement managesubmit;
	@FindBy(xpath="//i[@class='icon fas fa-check']")WebElement alert;
	
	 public ManageNewsPage(WebDriver driver)
	 {
		 this.driver=driver;
			PageFactory.initElements(driver, this);
	 }
	 public void manageNewsMoreInfo()
	 {
		 managenewsmoreinfo.click();
	 }
	  public void clickNew() {
		  managenewsnewbutton.click();
		  }
	  public void manageText(String textmessage)
	  {
		  managenewstext.sendKeys(textmessage);
	  }
	  public void manageSubmit()
	  {
		  managesubmit.click();
	  }
	  public boolean isGreenAlertDispalyed()
	  {
		return alert.isDisplayed();
		  
	  }
}
