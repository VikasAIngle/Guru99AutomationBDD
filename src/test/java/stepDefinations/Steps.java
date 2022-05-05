/**
 * 
 */
package stepDefinations;

import java.awt.AWTException;
import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.AddCustomer;
import pageObjects.LoginPage;
import utilities.TestUtil;

/**
 * @author Vikas Ingle
 *
 */
public class Steps 
{

	public WebDriver driver;
	public LoginPage loginPage;
	public Alert alert;
	public AddCustomer addCustPage;

	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
		
		  System.setProperty("webdriver.chrome.driver",
		  System.getProperty("user.dir")+"/Drivers/chromedriver.exe");
		  
		  ChromeOptions options = new ChromeOptions(); options.
		  addArguments("user-data-dir=C:\\Users\\VIKAS INGLE\\AppData\\Local\\Google\\Chrome\\User Data"
		  ); options.addArguments("disable-infobars");
		  
		  driver = new ChromeDriver(options);
		 
//		driver = new ChromeDriver();
		
		/*
		 * System.setProperty("webdriver.gecko.driver",
		 * System.getProperty("user.dir")+"/Drivers/geckodriver.exe"); driver = new
		 * FirefoxDriver();
		 */
		
		driver.manage().window().maximize();
		
	    loginPage = new LoginPage(driver);
		
		
	}

	@When("User opens URL {string}")
	public void user_opens_url(String url) 
	{
	    driver.get(url);
	}

	@When("User Enters username as {string} and Password as {string}")
	public void user_enters_username_as_and_password_as(String un, String pwd) 
	{
	    loginPage.sendUsername(un);
	    loginPage.sendPassword(pwd);
	}

	@When("Click on Login")
	public void click_on_login() 
	{
	    loginPage.clickLogin();
	}

	@Then("Page Title should be {string}")
	public void page_title_should_be(String title)
	{
				
	 	
		if(TestUtil.checkForAlert(driver, alert))
		{
			driver.close();
			Assert.assertTrue(false);
			
		}
		else {
			Assert.assertEquals(title, driver.getTitle());
		}
		
		
	}

	@When("User Click on Log out link")
	public void user_click_on_log_out_link() throws InterruptedException 
	{
		Thread.sleep(3000);
	    loginPage.clickLogOut();
	    
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.alertIsPresent());
	    
	    driver.switchTo().alert().accept();
	    
	}
	
	@Then("Close the Browser")
	public void close_the_browser() 
	{
	    driver.close();
	}
	
	
	// Add Customer 
	
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() throws InterruptedException 
	{
		addCustPage = new AddCustomer(driver);
		Thread.sleep(3000);
		
	    Assert.assertEquals("Guru99 Bank Manager HomePage", addCustPage.getPageTitle());
	    
	}

	@When("User click on New Customer menu")
	public void user_click_on_new_customer_menu() 
	{
	    addCustPage.clickOnNewCust();
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() throws InterruptedException
	{
		Thread.sleep(3000);
	    Assert.assertEquals("Guru99 Bank New Customer Entry Page", addCustPage.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws Exception
	{
	    addCustPage.setCustName("Vikas");
	    addCustPage.setGender("Female");
	    addCustPage.setDate();
	    addCustPage.setAddress("Cidco");
	    addCustPage.setCity("Aurangabad");
	    addCustPage.setState("Maharashtra");
	    addCustPage.setPin("431001");
	    addCustPage.setMobNo("9823819361");
	    
	    String email = TestUtil.randomString()+"@guru99.com";
	    
	    addCustPage.setEmail(email);
	    addCustPage.setPassword("Pass@123");
	    
	}

	@When("click on Submit button")
	public void click_on_submit_button() 
	{
	    addCustPage.clickOnSubmit();
		
		
	}

	@Then("User can view customer info with its customer id")
	public void user_can_view_customer_info_with_its_customer_id() throws InterruptedException 
	{
		Thread.sleep(3000);
	    
		Assert.assertEquals("Guru99 Bank Customer Registration Page", addCustPage.getPageTitle());
		
		
	}
	
	
	





	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
