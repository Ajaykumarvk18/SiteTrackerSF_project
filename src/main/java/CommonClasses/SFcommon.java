package CommonClasses;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import HelperClasses.TestBase;

public class SFcommon extends TestBase {
	
	
	
	public void waitForElement(int maxSec,WebElement ele)
	{
		WebDriverWait wait = new WebDriverWait(driver,maxSec);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}
	
	public void scrollToElement(WebElement ele)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView({behaviour: \"auto\",block: \"center\",inline: \"nearest\"});", ele);
	}
	
	public void clickByJS(WebElement ele)
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click()", ele);
	}
	
	public void implicitlyWait(int maxSec)
	{
		driver.manage().timeouts().implicitlyWait(maxSec, TimeUnit.SECONDS);
	}
	
	public ArrayList<String> getRowData(String filepath,String sheetname,String rowname,String ColName)
	{
		ArrayList arrayList = null;
		int col = 0;
		int rowNum =0;
		try
		{
			arrayList = new ArrayList();
			FileInputStream filestream = new FileInputStream(filepath);
			XSSFWorkbook workbook = new XSSFWorkbook(filestream);
			Sheet sheet = workbook.getSheet(sheetname);
			
			for(int i=0;i<=sheet.getLastRowNum();i++)
			{
				if(sheet.getRow(i).getCell(col).getStringCellValue().trim().equals(rowname))
				{
					rowNum = i;
				}
			}
			Row row = sheet.getRow(rowNum);
			for(int j=1;j<row.getLastCellNum();j++)
			{
				String val = row.getCell(j).getStringCellValue().trim();
				arrayList.add(val);
			}
		}
		catch(Exception e)
		{
			System.out.println("Not able to read excel");
		}
		
		
		return arrayList;
		
	}
	
	public void waitTillPageLoad() throws InterruptedException
	{
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		while(!jse.executeScript("return document.readyState").equals("complete"))
		{
			Thread.sleep(2);
		}
		
	}

}
