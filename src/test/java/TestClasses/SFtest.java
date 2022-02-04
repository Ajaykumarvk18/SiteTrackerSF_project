package TestClasses;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BussinesFunctionClasses.SFbusinessclass;
import DataClasses.SFDataclass;
import HelperClasses.TestBase;

public class SFtest extends TestBase{
	
	SFDataclass objData;
	SFbusinessclass objBusiness;
	
	@BeforeMethod(alwaysRun = true)
	public void beforeMethod()
	{
		objData = new SFDataclass();
		objBusiness = new SFbusinessclass();
	}
	
	@Test
	public void test1()
	{
		String methodname = new Object() {}.getClass().getEnclosingMethod().getName();
		objBusiness.setTestData(objData,methodname);
		SimpleDateFormat fom= new SimpleDateFormat("MMM d, yyyy");
		Date date = new Date();
		objData.setDate(fom.format(date));
		objBusiness.clickOncomponentReferenceTab();
		objBusiness.searchAndSelectComponentFromQuickFind(objData.getComponent());
		objBusiness.editAndUpdateTheTableRowData(objData);
		objBusiness.verifyUpdatedValues(objData);
	}

}
