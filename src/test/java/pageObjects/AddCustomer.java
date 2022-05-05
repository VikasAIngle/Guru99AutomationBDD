package pageObjects;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtil;

public class AddCustomer 
{
	public WebDriver pdriver;
	
	
	public AddCustomer(WebDriver driver)
	{
		pdriver = driver;
		PageFactory.initElements(pdriver, this);
	}
	
	
	@FindBy(name = "name")
	WebElement custName;
	
	@FindBy(xpath = "//input[@value='m']")
	WebElement rMale;
	
	@FindBy(xpath = "//input[@value='f']")
	WebElement rFemale;
	
	@FindBy(id = "dob")
	WebElement dob;
	
	
	@FindBy(xpath = "//textarea")
	WebElement address;
	
	@FindBy(name = "city")
	WebElement city;
	
	@FindBy(name = "state")
	WebElement state;
	
	@FindBy(name = "pinno")
	WebElement pinno;
	
	
	@FindBy(name = "telephoneno")
	WebElement mobNo;
	
	@FindBy(name = "emailid")
	WebElement email;
	
	@FindBy(name = "password")
	WebElement password;
	
	
	@FindBy(name = "sub")
	WebElement submitBtn;
	
	@FindBy(linkText = "New Customer")
	WebElement newCust;
	
	// Action methods
	
	public void clickOnNewCust()
	{
		TestUtil.JSClick(pdriver, newCust);
	}
	
	public void setCustName(String name)
	{
		TestUtil.sendKeys(pdriver, custName, name);
	}
	
	public void setGender(String gender)
	{
		if(gender.equalsIgnoreCase("Female"))
		{
			rFemale.click();
		}
		
		
	}
	
	public void setDate() throws AWTException, InterruptedException
	{
//		((JavascriptExecutor)pdriver).executeScript ("document.getElementById('dob').removeAttribute('readonly',0);");
		dob.clear();
//		dob.sendKeys("13");
		
		Thread.sleep(2000);
		
		Actions action = new Actions(pdriver);
		action.moveToElement(dob).perform();
		action.doubleClick().perform();
		dob.click();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
		Thread.sleep(2000);
		
//		((JavascriptExecutor)pdriver).executeScript("document.getElementById('dob').setAttribute('value','10-Jan-2013')");

			}
	
	public void setAddress(String txt)
	{
		address.sendKeys(txt);
	}
	
	public void setCity(String txt)
	{
		city.sendKeys(txt);
	}
	
	public void setState(String txt)
	{
		state.sendKeys(txt);
	}
	
	public void setPin(String txt)
	{
		pinno.sendKeys(txt);
	}
	
	public void setMobNo(String no)
	{
		mobNo.sendKeys(no);
	}
	
	
	public void setEmail(String txt)
	{
		email.sendKeys(txt);
	}
	
	public void setPassword(String txt)
	{
		password.sendKeys(txt);
	}
	
	
	public void clickOnSubmit()
	{
		TestUtil.JSClick(pdriver, submitBtn);
	}
	
	public String getPageTitle()
	{
		return pdriver.getTitle();
	}
	
	
	
	
	
	
}
