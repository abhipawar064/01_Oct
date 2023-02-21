package Sample_1._Oct_Maven;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Base_Class 
{
	//Open Browser
	
	public WebDriver driver;
	
	public void InitializeBrowser() 
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ABHISHEK PAWAR\\eclipse-workspace\\1_Oct_Maven\\Browser\\chromedriver.exe");
		
		driver=new ChromeDriver();
		
		driver.get("https://demo.guru99.com/insurance/v1/index.php");
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}

}
