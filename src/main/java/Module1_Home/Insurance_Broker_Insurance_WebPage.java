package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Broker_Insurance_WebPage
{
	//POM: 2
	
	//1. Data members/Global Variables should be declared globally with access level private by using @findby Annotation
	//For VerifyEmail
	@FindBy(xpath="//h4[text()='saradeg41@gmail.com']") private  WebElement SignedInAs;
	
	//For Click on LogOut button
	@FindBy(xpath="//input[@type='submit']") private WebElement Logout;
	
	//2. Initialize within a constructor with access level public using PageFactory
	public Insurance_Broker_Insurance_WebPage(WebDriver driver1)
	{
		PageFactory.initElements(driver1, this);
	}
	
	//3. Utilize within the methods with access level public
	public String getEmail() 
	{
		String ActualEmail=SignedInAs.getText();
		
		return ActualEmail;
		
	}
	
	public void ClickLogOutButton() 
	{
		Logout.click();
	}

}
