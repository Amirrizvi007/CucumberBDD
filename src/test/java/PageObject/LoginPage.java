package PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	public static WebDriver driver=null;
	
	public LoginPage(WebDriver driver)
	{
		
		PageFactory.initElements( driver,this);
		
	}
	@FindBy(id="Email")
	WebElement email;
	
	@FindBy(id="Password")
	WebElement password;
	
	@FindBy(xpath="//button[@class='button-1 login-button']")
	WebElement LoginBtn;
	
	@FindBy(linkText="Logout")
	WebElement logout;
	
	public void enterEmail(String emailAdd)
	{
		email.clear();
		email.sendKeys(emailAdd);
	}
	public void enterPassword(String pwd)
	{
		password.clear();
		password.sendKeys(pwd);
	}
	public void clickonLoginButton()
	{
		LoginBtn.click();
	}
	public void clickonLogoutButton() throws Exception
	{
		Thread.sleep(3000);
		logout.click();
	}

}
