package Sample_1._Oct_Maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

public class Utility_Class 
{
	//Automation Test Engineer: @Abhishek
	//Date: 15-feb-2023
	//Day: WednesDay
	//Title: Fetch Data From property file
	
	@Test
	public static String getDataFromPF(String key) throws IOException 
	{
		//To reach upto PropertyFile
		//Create Object Of FileInputStream
		FileInputStream file=new FileInputStream("C:\\Users\\ABHISHEK PAWAR\\eclipse-workspace\\1_Oct_Selenium\\PropertyFile.properties");
		
		//Create Object of properties class
		Properties Prop=new Properties();
		
		//To Open Property File
		Prop.load(file);
		
		//To fetch data from property file
		String Value1=Prop.getProperty(key);
		return Value1;
		
	}
	
	//Automation Test Engineer: @Abhishek
	//Date: 17-02-2023
	//Day: Friday
	//Title: To fetch data from Excelsheet
	
	@Test
	public static String getDataFromExcelSheet(int RowIndex, int CellIndex) throws EncryptedDocumentException, IOException 
	{
		FileInputStream file=new FileInputStream("C:\\Users\\ABHISHEK PAWAR\\eclipse-workspace\\1_Oct_Maven\\Testdata\\New XLSX Worksheet.xlsx");
		
		Sheet Sh=WorkbookFactory.create(file).getSheet("Sheet9");
		
		String S1=Sh.getRow(RowIndex).getCell(CellIndex).getStringCellValue();
		
		return S1;
		
	}
	
	@Test
	public static void capturescreenshot(WebDriver driver, int TestCaseID) throws IOException 
	{
		File Source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		System.out.println(Source);
		
		//create object 
		File Destination=new File("C:\\Users\\ABHISHEK PAWAR\\eclipse-workspace\\1_Oct_Maven\\Screenshot");
		
		FileHandler.copy(Source, Destination);
	}

	
	

}
