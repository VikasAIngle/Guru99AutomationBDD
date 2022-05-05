package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.TestUtil;

public class LoginPage 
{
	
public WebDriver driver;
	
	@FindBy(name  = "uid")
	@CacheLookup
	WebElement email;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement password;
	
	@FindBy(name = "btnLogin")
	@CacheLookup
	WebElement logInBtn;
	
	@FindBy(linkText = "Log out")
	@CacheLookup
	WebElement logOutBtn;
	
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void sendUsername(String uname)
	{
		email.clear();
		email.sendKeys(uname);
	}
	
	public void sendPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		TestUtil.JSClick(driver, logInBtn);
	}
	
	public void clickLogOut()
	{
		TestUtil.JSClick(driver, logOutBtn);
	}
	
	
	
}
