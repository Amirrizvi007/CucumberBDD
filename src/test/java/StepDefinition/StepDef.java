package StepDefinition;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import PageObject.SearchCustomerPage;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ReadConfig;

public class StepDef extends BaseClass
{
	public  WebDriver driver;
	public LoginPage loginPage;
	public SearchCustomerPage searchcuspg;
	public AddNewCustomerPage addNewCusPg;

@Before()
public void setup()
{
	
	readConfig = new ReadConfig();
	//logger 
	log =LogManager.getLogger("StepDef");
	 System.out.println("Setup method executed...");
	 
	 String browser=readConfig.getBrowser();
	 switch(browser.toLowerCase())
	 {
	 case "chrome":
	 	WebDriverManager.chromedriver().setup();
	 	driver= new ChromeDriver();
	 	driver.manage().window().maximize();
	 	break;
	 case "msedge":
		 WebDriverManager.edgedriver().setup();
		 	driver= new EdgeDriver();
		 	break;
	 case "firefox":
		 WebDriverManager.edgedriver().setup();
		 	driver= new FirefoxDriver();
		 	break;
		 	default:
		 		driver =null;
		 		break;
	 }
	 
	
	 log.fatal("Setup executed...");
}
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() 
	{
		
	 loginPage= new LoginPage(driver);	 
	 addNewCusPg=new AddNewCustomerPage(driver);
	 searchcuspg= new SearchCustomerPage(driver);
	 log.info("User Launch chrome browser");
	}

	@When("User opens URl {string}")
	public void user_opens_u_rl(String url) 
	{	    
	   driver.get(url);
		 log.info("URL opened");
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String emailAdd, String password) 
	{
		loginPage.enterEmail(emailAdd);
		loginPage.enterPassword(password);
		 log.info("email address and password entered ");
	}

	@When("Click on Login")
	public void click_on_login() 
	{
		loginPage.clickonLoginButton();
		log.info("login buton click");
	}
				////////Login Feature////////
	
	@Then("Page Title should be {string}")
	public void page_title_should_be(String expectedTitle) 
	{
	   	String ActualTitle=driver.getTitle();
	   	if(ActualTitle.equals(expectedTitle))
	   	{
	   		log.warn("Login Feature :Page title matched");
	   		Assert.assertTrue(true);
	   	}
	   	else
	   	{
	   		
	   		Assert.assertTrue(false);
	   		log.warn("Test Failed : Login feature -page title not match");
	   		
	   	}
	}

	@When("User click on Log out link")
	public void user_click_on_log_out_link() throws Exception
	{
		Thread.sleep(5000);
	   	loginPage.clickonLogoutButton();
	   	log.info("user clicked on logout link");
	}
/*
	@Then("close browser")
	public void close_browser() 
	{
		driver.close();
		log.info("logout closed");
		//driver.quit();
	}
	*/
	///////////////////////////////////////////////////////////////////////////////////
	@Then("User can view Dashboard")
	public void user_can_view_dashboard() 
	{
		String ActualTitle=addNewCusPg.getPageTitle();
		String expectedTitle= "Dashboard / nopCommerce administration";
		if(ActualTitle.equals(expectedTitle))
		{
			log.info("User can view Dashboard test passed");
			Assert.assertTrue(true);
		}
		else
		{
			log.warn("User can view Dashboard test failed");
			Assert.assertTrue(false);
		}
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu()
	{
		addNewCusPg.clickOnCustomersMenu();
		log.info("customer menu click");
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() 
	{
		
		addNewCusPg.clickOnClickMenuItem();
		log.info("customer menu click");
	}

	@When("click on Add new button")
	public void click_on_add_new_button() 
	{
		
		addNewCusPg.clickOnAddnew();
		log.info("customer add button");
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() 
	{
	    String actualTitle=addNewCusPg.getPageTitle();
	    String expectedTitle="Add a new customer / nopCommerce administration";
		if(actualTitle.equals(expectedTitle))
		{
			log.info("User can view Add new customer page passed");
			Assert.assertTrue(true);
		}
		else
		{
			log.info("User can view Add new customer page");
			Assert.assertTrue(false);
		}
	}

	@When("User enter customer info")
	public void user_enter_customer_info() 
	{
		//addNewCusPg.enterEmail("test1@gmail.com");
		addNewCusPg.enterEmail(generateEmailId()+"@gmail.com");
		addNewCusPg.enterPassword("test1");
		addNewCusPg.enterFirstName("Amir");
		addNewCusPg.enterLastName("sohail");
		addNewCusPg.enterGender("Male");
		addNewCusPg.enterdob("27/03/1997");
		addNewCusPg.enterCompanyName("Sun system infotech pvt ltd");
		addNewCusPg.enterAdminContent("Admin content");
		addNewCusPg.enterManagerOfVendor("QA tester");
		
		log.info("customer information entered");
		
	}

	@When("click on Save button")
	public void click_on_save_button() 
	{
		addNewCusPg.clickOnSave();
		log.info("clicked on save button");
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String expectedConfirmation) 
	{
		String bodyTagText=driver.findElement(By.tagName("Body")).getText();
		if(bodyTagText.contains("expectedConfirmation"))
		{
			Assert.assertTrue(true);
			log.info("User can view confirmation message-passed");
		}
		else
		{
			Assert.assertTrue(false);
			log.warn("User can view confirmation message-failed");
		}
	}
/////////////////////////////////////////////
		@When("Enter Customer Email")
		public void enter_customer_email() 
		{
			searchcuspg.enterEmailAdd("victoria_victoria@nopCommerce.com");
			log.info("Email address entered");
		}
		
		@When("Click on Search button")
		public void click_on_search_button() 
		{
			searchcuspg.clickOnSearchButton();
			log.info("Clicked on search button");
		}
		@Then("User should found Email in the Search table")
		public void user_should_found_email_in_the_search_table() 
		{
			String expectedEmail="victoria_victoria@nopCommerce.com";
			
			if(searchcuspg.searchCustomerByEmail(expectedEmail)==true)
			{
				Assert.assertTrue(true);
				log.info("User should found Email in the Search table-passed");
			}
			else
			{
				Assert.assertTrue(false);
				log.info("User should found Email in the Search table-failed");
			}
			
		}
		@When("Enter customer FirstName")
		public void enter_customer_first_name()
		{
			searchcuspg.enterFirstName("Victoria");
			log.info("Enter customer FirstName");
		}

		@When("Enter customer LastName")
		public void enter_customer_last_name() 
		{
			searchcuspg.enterLastName("Terces");
			log.info("Enter customer LastName");
		}

	

		@Then("User Should found Name in the Search table")
		public void user_should_found_name_in_the_search_table() 
		{
			String expectedName="victoria Terces";
			
			if(searchcuspg.searchCustomerByName(expectedName)==true)
			{
				Assert.assertTrue(true);
				log.info("User Should found Name in the Search table-passed");
			}
			else
			{
				Assert.assertTrue(false);
				log.info("User Should found Name in the Search table-failed");
			}
			
		}
		
		//@After()
		public void teardown(Scenario sc) 
		{
			System.out.println("Tear Down method executed");
			if(sc.isFailed()==true)
			{
				//Convert web driver object to TakeScreenshot
				String fileWithPath="E:\\CucumberBBD\\CucumberFramework\\Screenshot\\test1.png";
				TakesScreenshot scrshot=((TakesScreenshot)driver);
			
				//call getScreenshot method to create image file
				File SrcFile=scrshot.getScreenshotAs(OutputType.FILE);
				File DestFile= new File(fileWithPath);
				try {
					FileUtils.copyFile(SrcFile, DestFile);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			}
			
			driver.quit();
		}
		
		@AfterStep
		public void addScreenshot(Scenario sc)
		{
			if(sc.isFailed())
			{
				final byte[]screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
				sc.attach(screenshot,"image/png",sc.getName());
			}
		}
		/*
		@BeforeStep
		public void beforeStepMethodDemo()
		{
			System.out.println("this is before step...");
		}
		@AfterStep
		public void AfterStepMethodDemo()
		{
			System.out.println("this is after step");
		}
		*/
		
}
