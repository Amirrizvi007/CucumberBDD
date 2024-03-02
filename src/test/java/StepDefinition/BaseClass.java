package StepDefinition;

import java.util.Properties;

import org.apache.commons.lang.RandomStringUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;


import PageObject.AddNewCustomerPage;
import PageObject.LoginPage;
import utilities.ReadConfig;

public class BaseClass 
{
	public static WebDriver driver;
	public LoginPage loginpage;
	public AddNewCustomerPage addNewCusPg;
	public static Logger log;
	public  ReadConfig readConfig;
	
	public String generateEmailId()
	{
		return(RandomStringUtils.randomAlphabetic(5));
	}
}
