package Module1_Home_TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Module1_Home.Insurance_Broker_Insurance_WebPage;
import Module1_Home.Insurance_Login;
import Sample_1._Oct_Maven.Base_Class;
import Sample_1._Oct_Maven.Utility_Class;

public class Insurance_Test_Class extends Base_Class
{
	//public WebDriver driver;
	//InitializeBrowser()
	
	int TestCaseID;
	
	Insurance_Login Login;
	Insurance_Broker_Insurance_WebPage Broker;
	
	//Call Methods
	
	@BeforeClass
	public void OpenBrowser() 
	{
		InitializeBrowser();
		
		//Create Object of POM 1 class
	    Login=new Insurance_Login(driver);
		
	    //Create Object of POM 2 class
	    Broker=new Insurance_Broker_Insurance_WebPage(driver);
	    
	    
		
	}
	
	@BeforeMethod
	public void LoginToApp() throws IOException 
	{
		Login.EnterEmail(Utility_Class.getDataFromPF("EM"));		
		
		Login.EnterPass(Utility_Class.getDataFromPF("PSW"));
		
		Login.ClickLoginButton();
	}
	
	@Test(priority=1)
	public void VerifyEmailAddress() throws EncryptedDocumentException, IOException 
	{
		TestCaseID=100;
		
		String ActualEmail=Broker.getEmail();
		
		String ExpectedEmail=Utility_Class.getDataFromExcelSheet(1, 2);
		
		Assert.assertEquals(ActualEmail, ExpectedEmail);
		
	}
	
	@Test(priority=2)
	public void VerifyTitle() throws EncryptedDocumentException, IOException 
	{
		TestCaseID=101;
		
		String ActualTitle=driver.getTitle();
		
		String ExpectedTitle=Utility_Class.getDataFromExcelSheet(2, 1);
		
		Assert.assertEquals(ActualTitle, ExpectedTitle);
	}
	
	@AfterMethod
	public void CloseToApp(ITestResult Result) throws IOException 
	{
		if(Result.getStatus()==ITestResult.FAILURE) 
		{
			Utility_Class.capturescreenshot(driver, TestCaseID);
		}
		
		Broker.ClickLogOutButton();
	}
	
	@AfterClass
	public void CloseToBrowser() 
	{
		driver.close();
	}
	

}
