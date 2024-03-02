package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchCustomerPage {
	
	public static WebDriver driver;
	
	public SearchCustomerPage(WebDriver driver)
	{
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="SearchEmail")
	WebElement emailAdd;
	
	@FindBy(id="search-customers")
	WebElement searchBtn;
	
	@FindBy(xpath="//table[@class='table table-bordered table-hover table-striped dataTable no-footer']")
	WebElement searchResult;
	
	@FindBy(xpath="//table[@id='customers-grid']//tbody/tr")
	List<WebElement> tableRows;
	
	//@FindBy(xpath="//table[@id='customers-grid']//tbody/tr[1]/td")
	//List<WebElement> tableColumns;
	
	@FindBy(id="SearchFirstName")
	WebElement FirstName;
	
	@FindBy(id="SearchLastName")
	WebElement LastName;
	
	
	public void enterEmailAdd(String email)
	{
		emailAdd.sendKeys(email);
	}
    public void clickOnSearchButton()
    {
    	searchBtn.click();
    }
    
    public boolean searchCustomerByEmail(String email)
    {
    	boolean found= false;
    	
    	//total  no. of rows in a grid
    	int ttlRows =tableRows.size();
    	
    	//total no. of columns
    	// int ttlcolumns=tableColumns.size();
    	for(int i=1;i<=ttlRows;i++)
    	{
    		WebElement webElementEmail = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i+ "]/td[2]"));
    		
    		String actualEmailAdd = webElementEmail.getText();
    		
    		if(actualEmailAdd.equals(email))
    		{
    			found=true;
    		}
    		
    	}    	
    	return found;
    }

	public void enterFirstName(String FirstNameText)
	{
		FirstName.sendKeys(FirstNameText);
	}
	public void enterLastName(String LastNameText)
	{
		LastName.sendKeys(LastNameText);
	}
	 public boolean searchCustomerByName(String name)
	    {
	    	boolean found= false;
	    	
	    	//total  no. of rows in a grid
	    	int ttlRows =tableRows.size();
	    	
	    	//total no. of columns
	    	// int ttlcolumns=tableColumns.size();
	    	for(int i=1;i<=ttlRows;i++)
	    	{
	    		WebElement webElementName = driver.findElement(By.xpath("//table[@id='customers-grid']//tbody/tr["+ i+ "]/td[3]"));
	    		
	    		String actualName = webElementName.getText();
	    		
	    		if(actualName.equals(name))
	    		{
	    			found=true;
	    			break;
	    		}
	    		
	    	}    	
	    	return found;
	    }
}