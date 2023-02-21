package Module1_Home;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Insurance_Login 
{
	//POM: 1
	
	//1. Data members/Global Variables should be declared globally with access level private by using @findby Annotation
	@FindBy(xpath= "//input[@id='email']") private WebElement Email;
	
	@FindBy(xpath="//input[@id='password']") private WebElement Password;
	
	@FindBy(xpath="//input[@name='submit']") private WebElement LoginButton;
	
	//2. Initialize within a constructor with access level public using PageFactory
	public Insurance_Login(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}
	
	//3. Utilize within the methods with access level public
	public void EnterEmail(String email) 
	{
		Email.sendKeys(email);
	}
	public void EnterPass(String Pass) 
	{
		Password.sendKeys(Pass);
	}
	public void ClickLoginButton() 
	{
		LoginButton.click();
	}
	

}
