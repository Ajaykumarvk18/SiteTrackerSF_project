package HelperClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import CommonClasses.SFcommon;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	
	
	
	public static WebDriver driver;
	public static Properties objConfig;
	public static SFcommon objsfcommon;
	
	@BeforeMethod
	public void initialize() throws IOException
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		objConfig = new Properties();
		String filePath = System.getProperty("user.dir")+"\\resources\\config.properties";
		FileInputStream confFile = new FileInputStream(filePath);
		objConfig.load(confFile);
		driver.get(objConfig.getProperty("url"));
		driver.manage().window().maximize();
		objsfcommon = new SFcommon();
			
	    
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		driver.quit();
	}

}
