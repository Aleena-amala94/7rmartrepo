package utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
	public void fileUploadUsingSendKeys(WebElement element,String path)
	{
		element.sendKeys(path);
	}
	public void fileUploadUsingRobotClass(WebElement element,String path) throws AWTException
	{
		StringSelection ss=new StringSelection(path);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);//copy file in ss to clipboard
		Robot robot=new Robot();
		robot.delay(2500);//delay to copy and paste 
		robot.keyPress(KeyEvent.VK_CONTROL);//VK-virtual key
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
	}

}
